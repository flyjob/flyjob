package az.rock.flyjob.js.dataaccess.adapter.query;

import az.rock.flyjob.js.dataaccess.mapper.abstracts.AbstractContactDataAccessMapper;
import az.rock.flyjob.js.dataaccess.repository.abstracts.query.jpa.AbstractContactQueryJPARepository;
import az.rock.flyjob.js.domain.core.root.detail.ContactRoot;
import az.rock.flyjob.js.domain.presentation.ports.output.repository.query.AbstractContactQueryRepositoryAdapter;
import az.rock.lib.domain.id.js.ContactID;
import az.rock.lib.domain.id.js.ResumeID;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Component
public class ContactQueryRepositoryAdapter implements AbstractContactQueryRepositoryAdapter {
    private final AbstractContactQueryJPARepository contactQueryJPARepository;
    private final AbstractContactDataAccessMapper contactMapper;

    public ContactQueryRepositoryAdapter( AbstractContactQueryJPARepository abstractContactQueryJPARepository,
                                         @Qualifier(value = "contactDataAccessMapper") AbstractContactDataAccessMapper abstractContactDataAccessMapper) {
        this.contactQueryJPARepository = abstractContactQueryJPARepository;
        this.contactMapper = abstractContactDataAccessMapper;
    }

    @Override
    public Boolean isExistContact(ContactRoot contactRoot) {
        return this.contactQueryJPARepository.existByContact(contactRoot);
    }

    @Override
    public Optional<ContactRoot> findContact(ResumeID resumeID, UUID uuid) {
        var entity = contactQueryJPARepository.findResumeIAndContactID(resumeID.getRootID(), uuid);
        if (entity.isEmpty()) return Optional.empty();
        return this.contactMapper.toRoot(entity.get());
    }

    @Override
    public Optional<ContactRoot> findOwnByID(ResumeID resumeID, ContactID contactID) {
        var entity = contactQueryJPARepository.findResumeIAndContactID(resumeID.getRootID(), contactID.getRootID());
        if (entity.isEmpty()) return Optional.empty();
        return this.contactMapper.toRoot(entity.get());
    }

    @Override
    public Optional<ContactRoot> findById(ContactID rootId) {
        var entity = this.contactQueryJPARepository.findById(rootId.getAbsoluteID());
        if (entity.isEmpty()) return Optional.empty();
        return this.contactMapper.toRoot(entity.get());
    }

    @Override
    public Optional<ContactRoot> findByPID(ResumeID parentID) {
        var entity = this.contactQueryJPARepository.findByPID(parentID.getAbsoluteID());
        if (entity.isEmpty()) return Optional.empty();
        return this.contactMapper.toRoot(entity.get());
    }

    @Override
    public List<ContactRoot> findAllByPID(ResumeID parentID) {
        var contactEntityList = contactQueryJPARepository.findAllByPID(parentID.getAbsoluteID());
        return contactEntityList.stream()
                .map(this.contactMapper::toRoot)
                .filter(Optional::isPresent)
                .map(Optional::get)
                .toList();
    }
}
