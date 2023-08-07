package az.rock.flyjob.repository.concretes.command.custom.detail;

import az.rock.flyjob.model.entity.resume.details.AwardEntity;
import az.rock.flyjob.model.entity.resume.details.ReferenceEntity;
import az.rock.flyjob.repository.abstracts.command.custom.detail.AbstractAwardCustomCommandJPARepository;
import az.rock.flyjob.repository.abstracts.command.custom.detail.AbstractReferenceCustomCommandJPARepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Component;

@Component
public class ReferenceCustomCommandJPARepository implements AbstractReferenceCustomCommandJPARepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public EntityManager entityManager() {
        return this.entityManager;
    }

    @Override
    public <S extends ReferenceEntity> S persist(S entity) {
        this.entityManager.persist(entity);
        return entity;
    }

    @Override
    public <S extends ReferenceEntity> S merge(S entity) {
        return this.entityManager.merge(entity);
    }
}
