package az.rock.flyjob.js.dataaccess.repository.concretes.command.custom.detail;

import az.rock.flyjob.js.dataaccess.model.entity.resume.ResumeEntity;
import az.rock.flyjob.js.dataaccess.model.entity.resume.details.InterestEntity;
import az.rock.flyjob.js.dataaccess.repository.abstracts.command.custom.detail.AbstractInterestCustomCommandJPARepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Component;

@Component
public class InterestCustomCommandJPARepository implements AbstractInterestCustomCommandJPARepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public EntityManager entityManager() {
        return this.entityManager;
    }

    @Override
    public <S extends InterestEntity> S persist(S entity) {
        var resumeEntity = this.entityManager.getReference(ResumeEntity.class, entity.getResume().getUuid());
        entity.setResume(resumeEntity);
        this.entityManager.persist(entity);
        return entity;
    }

    @Override
    public <S extends InterestEntity> S merge(S entity) {
        var resumeEntity = this.entityManager.getReference(ResumeEntity.class, entity.getResume().getUuid());
        entity.setResume(resumeEntity);
        return this.entityManager.merge(entity);
    }

}
