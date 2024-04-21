package az.rock.flyjob.js.dataaccess.adapter.command.detail;

import az.rock.flyjob.js.dataaccess.mapper.abstracts.AbstractExperienceDataAccessMapper;
import az.rock.flyjob.js.dataaccess.repository.abstracts.command.custom.detail.AbstractExperienceCustomCommandJPARepository;
import az.rock.flyjob.js.domain.core.root.detail.ExperienceRoot;
import az.rock.flyjob.js.domain.presentation.ports.output.repository.command.AbstractExperienceCommandRepositoryAdapter;
import az.rock.lib.domain.RootID;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Component
public class ExperienceCommandRepositoryAdapter implements AbstractExperienceCommandRepositoryAdapter {
    public AbstractExperienceDataAccessMapper experienceDataAccessMapper;
    public AbstractExperienceCustomCommandJPARepository experienceCustomCommandJPARepository;

    public ExperienceCommandRepositoryAdapter(AbstractExperienceDataAccessMapper experienceDataAccessMapper
            , AbstractExperienceCustomCommandJPARepository experienceCustomCommandJPARepository) {
        this.experienceDataAccessMapper = experienceDataAccessMapper;
        this.experienceCustomCommandJPARepository = experienceCustomCommandJPARepository;
    }

    @Override
    public Optional<ExperienceRoot> create(ExperienceRoot root) {
        var entity = experienceDataAccessMapper.toEntity(root);
        if (entity.isEmpty()) return Optional.empty();
        var savedEntity = this.experienceCustomCommandJPARepository.persist(entity.get());
        return this.experienceDataAccessMapper.toRoot(savedEntity);
    }

    @Override
    public void update(ExperienceRoot root) {
        var entity = this.experienceDataAccessMapper.toEntity(root);
        entity.ifPresent(this.experienceCustomCommandJPARepository::merge);
    }

    @Override
    public void delete(ExperienceRoot root) {
        var entity = this.experienceDataAccessMapper.toEntity(root);
       entity.ifPresent(this.experienceCustomCommandJPARepository::delete);
    }


    @Override
    public void updateAll(List<ExperienceRoot> experienceRoots) {
        experienceRoots.stream()
                .map(this.experienceDataAccessMapper::toEntity)
                .filter(Optional::isPresent)
                .map(Optional::get)
                .forEach(this.experienceCustomCommandJPARepository::update);
    }

    @Override
    public void inActive(ExperienceRoot root) {
        AbstractExperienceCommandRepositoryAdapter.super.inActive(root);
    }

    @Override
    public void deleteAll(List<ExperienceRoot> roots) {
        AbstractExperienceCommandRepositoryAdapter.super.deleteAll(roots);
    }

    @Override
    public void rollback(Collection<ExperienceRoot> roots) {
        AbstractExperienceCommandRepositoryAdapter.super.rollback(roots);
    }

    @Override
    public void rollback(ExperienceRoot root) {
        AbstractExperienceCommandRepositoryAdapter.super.rollback(root);
    }
}
