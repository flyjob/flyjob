package az.rock.flyjob.js.dataaccess.repository.concretes.command.custom.detail;

import az.rock.flyjob.js.dataaccess.model.entity.resume.ResumeEntity;
import az.rock.flyjob.js.dataaccess.model.entity.resume.details.ExperienceEntity;
import az.rock.flyjob.js.dataaccess.repository.abstracts.command.custom.detail.AbstractExperienceCustomCommandJPARepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Component;

@Component
public class ExperienceCustomCommandJPARepository implements AbstractExperienceCustomCommandJPARepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public EntityManager entityManager() {
        return this.entityManager;
    }

    @Override
    public <S extends ExperienceEntity> S persist(S entity) {
        var resumeEntityReference = this.entityManager.getReference(ResumeEntity.class, entity.getResume().getUuid());
        entity.setResume(resumeEntityReference);
        this.entityManager.persist(entity);
        return entity;
    }

    @Override
    public <S extends ExperienceEntity> S merge(S entity) {
        var resumeEntityReference = this.entityManager.getReference(ResumeEntity.class, entity.getResume().getUuid());
        entity.setResume(resumeEntityReference);
        return this.entityManager.merge(entity);
    }
}
