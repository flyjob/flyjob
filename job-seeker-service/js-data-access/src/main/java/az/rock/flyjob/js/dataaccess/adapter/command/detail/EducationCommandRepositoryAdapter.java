package az.rock.flyjob.js.dataaccess.adapter.command.detail;

import az.rock.flyjob.js.dataaccess.mapper.abstracts.AbstractEducationDataAccessMapper;
import az.rock.flyjob.js.dataaccess.repository.abstracts.command.custom.detail.AbstractCustomEducationCommandJpaRepository;
import az.rock.flyjob.js.domain.core.root.detail.EducationRoot;
import az.rock.flyjob.js.domain.presentation.ports.output.repository.command.AbstractEducationCommandRepositoryAdapter;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;


@Component
public class EducationCommandRepositoryAdapter implements AbstractEducationCommandRepositoryAdapter {
    private final AbstractEducationDataAccessMapper educationDataAccessMapper;
    private final AbstractCustomEducationCommandJpaRepository educationCustomCommandJpaRepository;


    public EducationCommandRepositoryAdapter(AbstractEducationDataAccessMapper educationDataAccessMapper, AbstractCustomEducationCommandJpaRepository educationCustomCommandJpaRepository) {
        this.educationDataAccessMapper = educationDataAccessMapper;
        this.educationCustomCommandJpaRepository = educationCustomCommandJpaRepository;
    }


    public Optional<EducationRoot> create(EducationRoot root) {
        var entity = educationDataAccessMapper.toEntity(root);
        if (entity.isEmpty()) return Optional.empty();
        var savedEntity = this.educationCustomCommandJpaRepository.persist(entity.get());
        return this.educationDataAccessMapper.toRoot(savedEntity);
    }

    @Override
    public void update(EducationRoot root) {
        var entity = this.educationDataAccessMapper.toEntity(root);
        entity.ifPresent(this.educationCustomCommandJpaRepository::merge);
    }


    @Override
    public void updateAll(List<EducationRoot> educationRoots) {
        educationRoots.stream()
                .map(this.educationDataAccessMapper::toEntity)
                .filter(Optional::isPresent)
                .map(Optional::get)
                .forEach(this.educationCustomCommandJpaRepository::update);
    }

    @Override
    public void inActive(EducationRoot root) {
        var entity = this.educationDataAccessMapper.toEntity(root);
        entity.ifPresent(this.educationCustomCommandJpaRepository::delete);
    }

    @Override
    public void rollback(EducationRoot root) {
        AbstractEducationCommandRepositoryAdapter.super.rollback(root);
    }


}

