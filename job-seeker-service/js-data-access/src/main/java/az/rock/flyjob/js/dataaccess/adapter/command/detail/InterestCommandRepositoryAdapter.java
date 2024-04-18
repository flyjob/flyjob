package az.rock.flyjob.js.dataaccess.adapter.command.detail;

import az.rock.flyjob.js.dataaccess.mapper.abstracts.AbstractInterestDataAccessMapper;
import az.rock.flyjob.js.dataaccess.model.entity.resume.details.InterestEntity;
import az.rock.flyjob.js.dataaccess.repository.abstracts.command.custom.detail.AbstractInterestCustomCommandJPARepository;
import az.rock.flyjob.js.domain.core.root.detail.InterestRoot;
import az.rock.flyjob.js.domain.presentation.mapper.concretes.InterestDomainMapper;
import az.rock.flyjob.js.domain.presentation.ports.output.repository.command.AbstractInterestCommandRepositoryAdapter;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Component
public class InterestCommandRepositoryAdapter implements AbstractInterestCommandRepositoryAdapter {

    private final AbstractInterestCustomCommandJPARepository interestCustomCommandJPARepository;
    private final AbstractInterestDataAccessMapper interestDataAccessMapper;

    public InterestCommandRepositoryAdapter(AbstractInterestCustomCommandJPARepository interestCustomCommandJPARepository, AbstractInterestDataAccessMapper interestDataAccessMapper) {
        this.interestCustomCommandJPARepository = interestCustomCommandJPARepository;
        this.interestDataAccessMapper = interestDataAccessMapper;
    }

    @Override
    public void delete(InterestRoot root) {
        var entity = this.interestDataAccessMapper.toEntity(root);
        entity.ifPresent(this.interestCustomCommandJPARepository::delete);

    }

    @Override
    public Optional<InterestRoot> create(InterestRoot root) {
        var optionalEntity = this.interestDataAccessMapper.toEntity(root);
        if (optionalEntity.isPresent()) {
            var savedEntity = this.interestCustomCommandJPARepository.persist(optionalEntity.get());
            return this.interestDataAccessMapper.toRoot(savedEntity);
        } else return Optional.empty();
    }

    @Override
    public void update(InterestRoot root) {
        var entity = this.interestDataAccessMapper.toEntity(root);
        entity.ifPresent(this.interestCustomCommandJPARepository::merge);
    }


    @Override
    public void rollback(InterestRoot root) {
        AbstractInterestCommandRepositoryAdapter.super.rollback(root);
    }
}
