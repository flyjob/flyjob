package az.rock.flyjob.js.domain.presentation.ports.input.services.query.concretes;

import az.rock.flyjob.js.domain.core.exception.ContactDomainException;
import az.rock.flyjob.js.domain.core.exception.ContactDomainPresentationException;
import az.rock.flyjob.js.domain.core.root.detail.ContactRoot;
import az.rock.flyjob.js.domain.presentation.dto.response.resume.contact.AnyContactResponseModel;
import az.rock.flyjob.js.domain.presentation.dto.response.resume.contact.MyContactResponseModel;
import az.rock.flyjob.js.domain.presentation.dto.response.resume.contact.simple.SimpleAnyContactResponseModel;
import az.rock.flyjob.js.domain.presentation.dto.response.resume.contact.simple.SimpleMyContactResponseModel;
import az.rock.flyjob.js.domain.presentation.ports.input.services.query.abstracts.AbstractContactQueryDomainPresentationService;
import az.rock.flyjob.js.domain.presentation.ports.output.repository.query.AbstractContactQueryRepositoryAdapter;
import az.rock.flyjob.js.domain.presentation.security.AbstractSecurityContextHolder;
import az.rock.lib.domain.RootID;
import az.rock.lib.domain.id.auth.EmailID;
import az.rock.lib.domain.id.js.ContactID;
import az.rock.lib.domain.id.js.ResumeID;
import az.rock.lib.valueObject.SimplePageableRequest;
import az.rock.lib.valueObject.SimplePageableResponse;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class ContactQueryDomainPresentationService implements AbstractContactQueryDomainPresentationService {
    private final AbstractSecurityContextHolder abstractSecurityContextHolder;
    private  final AbstractContactQueryRepositoryAdapter abstractContactQueryRepositoryAdapter;

    public ContactQueryDomainPresentationService(AbstractSecurityContextHolder abstractSecurityContextHolder, AbstractContactQueryRepositoryAdapter abstractContactQueryRepositoryAdapter) {
        this.abstractSecurityContextHolder = abstractSecurityContextHolder;
        this.abstractContactQueryRepositoryAdapter = abstractContactQueryRepositoryAdapter;
    }

    @Override
    public SimplePageableResponse<AnyContactResponseModel> queryAllAnyContacts(SimplePageableRequest simplePageableRequest) {
//        var pageRequest = simplePageableRequest.of(pageableRequest.getPage(), pageableRequest.getSize());
//        var allAnyContacts = this.abstractContactQueryRepositoryAdapter.findAllByPID(contactId, pageRequest, modifierList);
//        if (!allAnyInterests.isEmpty()) {
//            return allAnyInterests;
//        } else throw new RuntimeException();
        return null;
    }

    @Override
    public SimplePageableResponse<MyContactResponseModel> queryAllMyContacts(SimplePageableRequest simplePageableRequest) {
        return null;
    }

    @Override
    public SimplePageableResponse<SimpleMyContactResponseModel> queryAllMySimpleContacts(SimplePageableRequest simplePageableRequest) {
        return null;
    }

    @Override
    public SimplePageableResponse<SimpleAnyContactResponseModel> queryAllAnySimpleContacts(UUID targetResumeID, SimplePageableRequest simplePageableRequest) {
        return null;
    }

    @Override
    public MyContactResponseModel findMyContactById(UUID uuid) {
        var contactAvailable = abstractSecurityContextHolder.availableResumeID();
        var optionalContact = this.abstractContactQueryRepositoryAdapter
                .findById(ContactID.of(uuid));
        return optionalContact.map(MyContactResponseModel::of)
                .orElseThrow(()->new ContactDomainPresentationException("F0000000011"));
    }

    @Override
    public AnyContactResponseModel findAnyContactById(UUID uuid) {
        var contactAvailable = abstractSecurityContextHolder.availableResumeID();
        var contactId = abstractContactQueryRepositoryAdapter.findById(ContactID.of(uuid));
        if (contactId.isEmpty()) throw new ContactDomainPresentationException("F0000000011");
        var contactResume = contactId.get();
        var response = AnyContactResponseModel.of(contactResume);
        if (contactResume.isValid()) {
             return response;
        } else throw new ContactDomainPresentationException("F0000000015");
    }
}
