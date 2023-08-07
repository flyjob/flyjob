package az.rock.flyjob.repository.concretes.command.custom.detail;

import az.rock.flyjob.model.entity.resume.details.AwardEntity;
import az.rock.flyjob.model.entity.resume.details.ExperienceEntity;
import az.rock.flyjob.repository.abstracts.command.custom.detail.AbstractAwardCustomCommandJPARepository;
import az.rock.flyjob.repository.abstracts.command.custom.detail.AbstractExperienceCustomCommandJPARepository;
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
        this.entityManager.persist(entity);
        return entity;
    }

    @Override
    public <S extends ExperienceEntity> S merge(S entity) {
        return this.entityManager.merge(entity);
    }
}
