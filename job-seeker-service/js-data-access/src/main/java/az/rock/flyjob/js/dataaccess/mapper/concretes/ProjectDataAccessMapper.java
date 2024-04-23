package az.rock.flyjob.js.dataaccess.mapper.concretes;

import az.rock.flyjob.js.dataaccess.mapper.abstracts.AbstractProjectDataAccessMapper;
import az.rock.flyjob.js.dataaccess.model.entity.resume.details.ProjectEntity;
import az.rock.flyjob.js.domain.core.root.detail.ProjectRoot;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class ProjectDataAccessMapper implements AbstractProjectDataAccessMapper {
    @Override
    public Optional<ProjectRoot> toRoot(ProjectEntity entity) {
        return Optional.empty();
    }

    @Override
    public Optional<ProjectEntity> toEntity(ProjectRoot root) {
        return Optional.empty();
    }
}
