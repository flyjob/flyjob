package az.rock.flyjob.js.dataaccess.repository.concretes.command.custom.detail;

import az.rock.flyjob.js.dataaccess.model.entity.resume.ResumeEntity;
import az.rock.flyjob.js.dataaccess.model.entity.resume.details.PersonalSummaryEntity;
import az.rock.flyjob.js.dataaccess.repository.abstracts.command.custom.detail.AbstractPersonalSummaryCustomCommandJPARepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Component;

@Component
public class PersonalSummaryCustomCommandJPARepository implements AbstractPersonalSummaryCustomCommandJPARepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public EntityManager entityManager() {
        return this.entityManager;
    }

    @Override
    public <S extends PersonalSummaryEntity> S persist(S entity) {
        var resumeEntity = this.entityManager.getReference(ResumeEntity.class, entity.getResume().getUuid());
        entity.setResume(resumeEntity);
        this.entityManager.persist(entity);
        return entity;
    }

    @Override
    public <S extends PersonalSummaryEntity> S merge(S entity) {
        var reference = this.entityManager.getReference(ResumeEntity.class, entity.getResume().getUuid());
        entity.setResume(reference);
        return this.entityManager.merge(entity);
    }
}
