package az.rock.flyjob.js.dataaccess.adapter.command;

import az.rock.flyjob.js.dataaccess.mapper.abstracts.AbstractContactDataAccessMapper;
import az.rock.flyjob.js.dataaccess.model.entity.resume.details.ContactEntity;
import az.rock.flyjob.js.dataaccess.repository.abstracts.command.AbstractContactCommandJPARepository;
import az.rock.flyjob.js.domain.core.root.detail.ContactRoot;
import az.rock.flyjob.js.domain.presentation.ports.output.repository.command.AbstractContactCommandRepositoryAdapter;
import az.rock.lib.domain.id.js.ResumeID;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.rmi.server.UID;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
@Slf4j
public class ContactCommandRepositoryAdapter implements AbstractContactCommandRepositoryAdapter {
    private final AbstractContactDataAccessMapper abstractContactDataAccessMapper;
    private final AbstractContactCommandJPARepository repository;

    public ContactCommandRepositoryAdapter(AbstractContactDataAccessMapper abstractContactDataAccessMapper,
                                           @Qualifier("contactCustomCommandJPARepository") AbstractContactCommandJPARepository repository) {
        this.abstractContactDataAccessMapper = abstractContactDataAccessMapper;
        this.repository = repository;
    }


    @Override
    public Optional<ContactRoot> create(ContactRoot root) {
        var entity = this.abstractContactDataAccessMapper.toEntity(root);
        if (entity.isEmpty()) return Optional.empty();
        var savedEntity = this.repository.persist(entity.get());
        return this.abstractContactDataAccessMapper.toRoot(savedEntity);
    }

    @Override
    public void update(ContactRoot root) {
        var entity = this.abstractContactDataAccessMapper.toEntity(root);
        entity.ifPresent(this.repository::merge);
    }

    @Override
    public void delete(ContactRoot root) {
        var entity = this.abstractContactDataAccessMapper.toEntity(root);
        entity.ifPresent(this.repository::delete);
    }

    @Override
    public void deleteAll(List<ContactRoot> roots) {
        var entityList = roots
                .stream()
                .map(abstractContactDataAccessMapper::toEntity)
                .filter(Optional::isPresent)
                .map(Optional::get)
                .toList();
        repository.deleteAll(entityList);

    }

    @Override
    public void updateAll(List<ContactRoot> contactRoots) {
        var entityList = contactRoots
                .stream()
                .map(this.abstractContactDataAccessMapper::toEntity)
                .filter(Optional::isPresent)
                .map(Optional::get)
                .toList();
        this.repository.updateAll(entityList);
    }

    @Override
    public void inActive(ContactRoot root) {
        var entity = this.abstractContactDataAccessMapper.toEntity(root);
        entity.ifPresent(this.repository::delete);
    }


    @Override
    public void rollback(Collection<ContactRoot> contactRoots) {
        var optionalEntity = this.abstractContactDataAccessMapper.toEntity((ContactRoot) contactRoots);
        optionalEntity.ifPresentOrElse(
                this.repository::rollback,
                () -> log.error("User cannot rollback because of entity is null")
        );
    }

}
