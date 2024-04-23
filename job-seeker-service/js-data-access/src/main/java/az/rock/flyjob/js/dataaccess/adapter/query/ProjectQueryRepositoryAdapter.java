package az.rock.flyjob.js.dataaccess.adapter.query;

import az.rock.flyjob.js.domain.core.root.detail.ProjectRoot;
import az.rock.flyjob.js.domain.presentation.ports.output.repository.query.AbstractProjectQueryRepositoryAdapter;
import az.rock.lib.domain.id.js.ResumeID;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
@Component
public class ProjectQueryRepositoryAdapter implements AbstractProjectQueryRepositoryAdapter {
    @Override
    public Optional<ProjectRoot> findByResumeAndUuidAndRowStatusTrue(ResumeID resumeID, UUID projectId) {
        return Optional.empty();
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
