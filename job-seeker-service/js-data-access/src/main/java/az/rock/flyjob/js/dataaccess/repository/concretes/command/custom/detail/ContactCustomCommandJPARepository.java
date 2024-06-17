package az.rock.flyjob.js.dataaccess.repository.concretes.command.custom.detail;

import az.rock.flyjob.js.dataaccess.model.entity.resume.ResumeEntity;
import az.rock.flyjob.js.dataaccess.model.entity.resume.details.ContactEntity;
import az.rock.flyjob.js.dataaccess.repository.abstracts.command.AbstractContactCommandJPARepository;
import az.rock.flyjob.js.dataaccess.repository.abstracts.command.custom.detail.AbstractContactCustomCommandJPARepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.UUID;

@Component
public class ContactCustomCommandJPARepository implements AbstractContactCommandJPARepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public EntityManager entityManager() {
        return this.entityManager;
    }

    @Override
    public <S extends ContactEntity> S persist(S entity) {
        var userContactReference = this.entityManager.getReference(ResumeEntity.class, entity.getResume().getUuid());
        entity.setResume(userContactReference);
        this.entityManager.persist(entity);
        return entity;
    }

    @Override
    public <S extends ContactEntity> S merge(S entity) {
        var userContactReference = this.entityManager.getReference(ResumeEntity.class, entity.getResume().getUuid());
        entity.setResume(userContactReference);
        return this.entityManager.merge(entity);
    }
}
