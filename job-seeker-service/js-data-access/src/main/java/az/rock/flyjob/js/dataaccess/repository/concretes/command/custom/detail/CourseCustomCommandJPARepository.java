package az.rock.flyjob.js.dataaccess.repository.concretes.command.custom.detail;

import az.rock.flyjob.js.dataaccess.model.entity.resume.ResumeEntity;
import az.rock.flyjob.js.dataaccess.model.entity.resume.details.CourseEntity;
import az.rock.flyjob.js.dataaccess.repository.abstracts.command.custom.detail.AbstractCourseCustomCommandJPARepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class CourseCustomCommandJPARepository implements AbstractCourseCustomCommandJPARepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public EntityManager entityManager() {
        return this.entityManager;
    }

    @Override
    public <S extends CourseEntity> S persist(S entity) {
        var resumeReference = entityManager.getReference(ResumeEntity.class,entity.getResume().getUuid());
        entity.setResume(resumeReference);
        this.entityManager.persist(entity);
        return entity;
    }

    @Override
    public <S extends CourseEntity> S merge(S entity) {
        var resumeReference = entityManager.getReference(ResumeEntity.class,entity.getResume().getUuid());
        entity.setResume(resumeReference);
        return this.entityManager.merge(entity);
    }

}
