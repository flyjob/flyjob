package az.rock.flyjob.js.dataaccess.repository.concretes.command.custom.detail;

import az.rock.flyjob.js.dataaccess.model.entity.resume.ResumeEntity;
import az.rock.flyjob.js.dataaccess.model.entity.resume.details.EducationEntity;
import az.rock.flyjob.js.dataaccess.repository.abstracts.command.custom.detail.AbstractCustomEducationCommandJpaRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Component;

@Component
public class EducationCustomCommandJPARepository implements AbstractCustomEducationCommandJpaRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public EntityManager entityManager() {
        return this.entityManager;
    }

    @Override
    public <S extends EducationEntity> S persist(S entity) {
        var resumeEntityReference = this.entityManager.getReference(ResumeEntity.class, entity.getResume().getUuid());
        entity.setResume(resumeEntityReference);
        this.entityManager.persist(entity);
        return entity;
    }

    @Override
    public <S extends EducationEntity> S merge(S entity) {
        var resumeEntityReference = this.entityManager.getReference(ResumeEntity.class, entity.getResume().getUuid());
        entity.setResume(resumeEntityReference);
        return this.entityManager.merge(entity);
    }

    @Override
    public <S extends EducationEntity> void inActive(S entity) {
        var resumeEntityReference = this.entityManager.getReference(ResumeEntity.class, entity.getResume().getUuid());
        entity.setResume(resumeEntityReference);
        entity.inActive();
        entityManager.merge(entity);
    }
}
