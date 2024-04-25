package az.rock.flyjob.js.dataaccess.adapter.query;

import az.rock.flyjob.js.dataaccess.mapper.abstracts.AbstractProjectDataAccessMapper;
import az.rock.flyjob.js.dataaccess.repository.abstracts.query.jpa.AbstractProjectQueryJPARepository;
import az.rock.flyjob.js.domain.core.root.detail.ProjectRoot;
import az.rock.flyjob.js.domain.presentation.ports.output.repository.query.AbstractProjectQueryRepositoryAdapter;
import az.rock.lib.domain.id.js.ResumeID;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Component
public class ProjectQueryRepositoryAdapter implements AbstractProjectQueryRepositoryAdapter {
    private final AbstractProjectQueryJPARepository projectQueryJPARepository;
    private final AbstractProjectDataAccessMapper projectDataAccessMapper;

    public ProjectQueryRepositoryAdapter(AbstractProjectQueryJPARepository projectQueryJPARepository
            , AbstractProjectDataAccessMapper projectDataAccessMapper) {
        this.projectQueryJPARepository = projectQueryJPARepository;
        this.projectDataAccessMapper = projectDataAccessMapper;
    }

    @Override
    public Optional<ProjectRoot> findByResumeAndUuidAndRowStatusTrue(ResumeID resumeID, UUID projectId) {
        var entity = this.projectQueryJPARepository.findByIdAndResumeIdAndRowStatusActive(resumeID.getAbsoluteID(), projectId);
        if (entity.isEmpty()) return Optional.empty();
        return this.projectDataAccessMapper.toRoot(entity.get());
    }

    @Override
    public Optional findOwnByID(Object parentID, Object rootId) {
        return AbstractProjectQueryRepositoryAdapter.super.findOwnByID(parentID, rootId);
    }

    @Override
    public Optional findById(Object rootId) {
        return Optional.empty();
    }

    @Override
    public Optional findByPID(Object parentID) {
        return AbstractProjectQueryRepositoryAdapter.super.findByPID(parentID);
    }

    @Override
    public List findAllByPID(Object parentID) {
        return AbstractProjectQueryRepositoryAdapter.super.findAllByPID(parentID);
    }
}
