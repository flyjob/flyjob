package az.rock.flyjob.js.domain.presentation.ports.output.repository.query;

import az.rock.flyjob.js.domain.core.root.detail.ProjectRoot;
import az.rock.lib.adapter.repository.AbstractQueryRepositoryAdapter;
import az.rock.lib.domain.id.js.ResumeID;

import java.util.Optional;
import java.util.UUID;

public interface AbstractProjectQueryRepositoryAdapter extends AbstractQueryRepositoryAdapter {
    Optional<ProjectRoot> findByResumeAndUuidAndRowStatusTrue(ResumeID resumeID, UUID projectId);
}
