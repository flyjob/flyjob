package az.rock.flyjob.js.domain.presentation.handler.concretes;
import az.rock.flyjob.js.domain.core.exception.ContactNotFoundException;
import az.rock.flyjob.js.domain.core.root.detail.ContactRoot;
import az.rock.flyjob.js.domain.core.service.abstracts.AbstractContactDomainService;
import az.rock.flyjob.js.domain.presentation.dto.request.abstracts.CreateRequest;
import az.rock.flyjob.js.domain.presentation.dto.request.abstracts.ReorderRequest;
import az.rock.flyjob.js.domain.presentation.dto.request.abstracts.UpdateRequest;
import az.rock.flyjob.js.domain.presentation.dto.request.item.ContactCommandModel;
import az.rock.flyjob.js.domain.presentation.exception.UnknownSystemException;
import az.rock.flyjob.js.domain.presentation.handler.abstracts.AbstractContactCommandHandler;
import az.rock.flyjob.js.domain.presentation.mapper.abstracts.AbstractContactCommandDomainMapper;
import az.rock.flyjob.js.domain.presentation.ports.output.repository.command.AbstractContactCommandRepositoryAdapter;
import az.rock.flyjob.js.domain.presentation.ports.output.repository.query.AbstractContactQueryRepositoryAdapter;
import az.rock.flyjob.js.domain.presentation.security.AbstractSecurityContextHolder;
import az.rock.lib.domain.id.js.ContactID;
import az.rock.lib.domain.id.js.ResumeID;
import com.intellibucket.lib.payload.event.create.ContactCreatedEvent;
import com.intellibucket.lib.payload.event.delete.ContactDeleteEvent;
import com.intellibucket.lib.payload.event.reorder.ContactReorderEvent;
import com.intellibucket.lib.payload.event.update.ContactUpdateEvent;
import com.intellibucket.lib.payload.payload.ContactPayload;
import org.springframework.stereotype.Component;
import java.util.Comparator;
import java.util.Optional;
import java.util.UUID;

@Component
public class ContactCommandPresentationHandler implements AbstractContactCommandHandler {
    private final AbstractContactCommandRepositoryAdapter abstractContactCommandRepositoryAdapter;

    private final AbstractContactQueryRepositoryAdapter abstractContactQueryRepositoryAdapter;
    private final AbstractContactCommandDomainMapper contactCommandDomainMapper;
    private final AbstractSecurityContextHolder contextHolder;
    private final AbstractContactDomainService domainService;

    public ContactCommandPresentationHandler(AbstractContactCommandRepositoryAdapter abstractContactCommandRepositoryAdapter,
                                             AbstractContactQueryRepositoryAdapter contactQueryRepositoryAdapter,
                                             AbstractContactCommandDomainMapper contactCommandDomainMapper,
                                             AbstractSecurityContextHolder contextHolder,
                                             AbstractContactDomainService domainService) {
        this.abstractContactCommandRepositoryAdapter = abstractContactCommandRepositoryAdapter;
        this.abstractContactQueryRepositoryAdapter = contactQueryRepositoryAdapter;
        this.contactCommandDomainMapper = contactCommandDomainMapper;
        this.contextHolder = contextHolder;
        this.domainService = domainService;
    }

    private ContactPayload toPayload(ContactRoot contactRoot) {
        return ContactPayload.Builder
                .builder()
                .id(contactRoot.getRootID().getAbsoluteID())
                .data(contactRoot.getData())
                .orderNumber(contactRoot.getOrderNumber())
                .build();
    }

    @Override
    public ContactCreatedEvent createContact(CreateRequest<ContactCommandModel> createRequest) {
        var currentResumeId = this.contextHolder.availableResumeID();
        var allSavedContacts = this.abstractContactQueryRepositoryAdapter.findAllByPID(currentResumeId);
        var contactRoot = this.contactCommandDomainMapper.toNewRoot(createRequest.getModel(), currentResumeId);
        var validateContact = this.domainService.validateContactDuplication(allSavedContacts, contactRoot);
        var optionalContactRoot = this.abstractContactCommandRepositoryAdapter.create(validateContact);
        if (optionalContactRoot.isEmpty())
            throw new UnknownSystemException();
        var contactPayload = this.toPayload(optionalContactRoot.get());
        return ContactCreatedEvent.of(contactPayload);
    }

    @Override
    public ContactUpdateEvent updateContact(UpdateRequest<ContactCommandModel> updateRequest) {
        var resumeID = contextHolder.availableResumeID();
        Optional<ContactRoot> foundContact = this.abstractContactQueryRepositoryAdapter.findContact(resumeID,updateRequest.getTargetId());
        if (foundContact.isPresent()) {
            var newRoot = contactCommandDomainMapper.isExistRoot(updateRequest.getModel(),foundContact.get());
            this.abstractContactCommandRepositoryAdapter.update(newRoot);
            var payload = this.toPayload(newRoot);
            return ContactUpdateEvent.of(payload);
        } else throw new ContactNotFoundException();
    }

    @Override
    public ContactDeleteEvent deleteContact(UUID id) {
        var currentContact = this.contextHolder.availableResumeID();
        var optionalContact = this.abstractContactQueryRepositoryAdapter.findOwnByID(currentContact, ContactID.of(id));
        if (optionalContact.isPresent()) {
            var contactIDNumber = optionalContact.get();
            this.abstractContactCommandRepositoryAdapter.inActive(contactIDNumber);
            return ContactDeleteEvent.of(toPayload(contactIDNumber));
        } else throw new ContactNotFoundException();
    }

    @Override
    public ContactDeleteEvent deleteAllContact(ResumeID resumeID) {
        return null;
    }

    @Override
    public ContactReorderEvent reOrderContact(ReorderRequest<ContactCommandModel> commandModel) {

        var contactList = this.abstractContactQueryRepositoryAdapter.findAllByPID(contextHolder.availableResumeID());
        var contact = contactList.stream()
                .filter(c -> c.getRootID().getRootID().toString()
                        .equals(commandModel.getTargetId().toString()))
                .findFirst().orElseThrow(ContactNotFoundException::new);
        var reOrderNumber = commandModel.getModel().getOrderNumber();
        if (reOrderNumber > contact.getOrderNumber()) ++reOrderNumber;
        contact.changeOrderNumber(reOrderNumber);
        contactList.stream()
                .filter(c -> c.getOrderNumber() >= contact.getOrderNumber() && !c.equals(contact))
                .forEach(c -> c.changeOrderNumber(c.getOrderNumber() + 1));
        int orderCounter = 1;
        for (ContactRoot contactRoot : contactList.stream()
                .sorted(Comparator.comparingInt(ContactRoot::getOrderNumber))
                .toList()) {
            contactRoot.changeOrderNumber(orderCounter++);

        }
        abstractContactCommandRepositoryAdapter.updateAll(contactList);
        return ContactReorderEvent.of(ContactPayload.Builder.builder().build());
    }

}
