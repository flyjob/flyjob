package az.rock.flyjob.js.dataaccess.adapter.command.detail;

import az.rock.flyjob.js.dataaccess.mapper.abstracts.AbstractProjectDataAccessMapper;
import az.rock.flyjob.js.dataaccess.repository.abstracts.command.custom.detail.AbstractProjectCustomCommandJPARepository;
import az.rock.flyjob.js.dataaccess.repository.abstracts.query.jpa.AbstractProjectQueryJPARepository;
import az.rock.flyjob.js.domain.core.root.detail.ProjectRoot;
import az.rock.flyjob.js.domain.presentation.mapper.abstracts.AbstractProjectDomainMapper;
import az.rock.flyjob.js.domain.presentation.ports.output.repository.command.AbstractProjectCommandRepositoryAdapter;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Component
public class ProjectCommandRepositoryAdapter implements AbstractProjectCommandRepositoryAdapter {

    private final AbstractProjectCustomCommandJPARepository projectCustomCommandJPARepository;
    private final AbstractProjectDataAccessMapper projectDataAccessMapper;

    public ProjectCommandRepositoryAdapter(AbstractProjectCustomCommandJPARepository projectCustomCommandJPARepository, AbstractProjectDataAccessMapper projectDataAccessMapper) {
        this.projectDataAccessMapper = projectDataAccessMapper;
        this.projectCustomCommandJPARepository = projectCustomCommandJPARepository;
    }

    @Override
    public Optional<ProjectRoot> create(ProjectRoot root) {
        var entity = this.projectDataAccessMapper.toEntity(root);
        if (entity.isEmpty()) return Optional.empty();
        var savedEntity = this.projectCustomCommandJPARepository.persist(entity.get());
        return this.projectDataAccessMapper.toRoot(savedEntity);
    }

    @Override
    public void update(ProjectRoot root) {
        AbstractProjectCommandRepositoryAdapter.super.update(root);
    }

    @Override
    public void delete(ProjectRoot root) {
        AbstractProjectCommandRepositoryAdapter.super.delete(root);
    }

    @Override
    public void updateAll(List<ProjectRoot> emailRoots) {
        AbstractProjectCommandRepositoryAdapter.super.updateAll(emailRoots);
    }

    @Override
    public void inActive(ProjectRoot root) {
        AbstractProjectCommandRepositoryAdapter.super.inActive(root);
    }

    @Override
    public void deleteAll(List<ProjectRoot> roots) {
        AbstractProjectCommandRepositoryAdapter.super.deleteAll(roots);
    }

    @Override
    public void rollback(Collection<ProjectRoot> roots) {
        AbstractProjectCommandRepositoryAdapter.super.rollback(roots);
    }

    @Override
    public void rollback(ProjectRoot root) {
        AbstractProjectCommandRepositoryAdapter.super.rollback(root);
    }
}
