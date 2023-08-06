package az.rock.flyjob.repository.concretes.command.custom.main;

import az.rock.flyjob.model.entity.resume.main.InformationEntity;
import az.rock.flyjob.model.entity.resume.main.LinkEntity;
import az.rock.flyjob.repository.abstracts.command.custom.main.AbstractInformationCustomCommandJPARepository;
import az.rock.flyjob.repository.abstracts.command.custom.main.AbstractLinkCustomCommandJPARepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Component;

@Component
public class LinkCustomCommandJPARepository implements AbstractLinkCustomCommandJPARepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public EntityManager entityManager() {
        return this.entityManager;
    }

    @Override
    public <S extends LinkEntity> S persist(S entity) {
        this.entityManager.persist(entity);
        return entity;
    }

    @Override
    public <S extends LinkEntity> S merge(S entity) {
        return this.entityManager.merge(entity);
    }
}
