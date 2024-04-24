package az.rock.flyjob.js.dataaccess.mapper.concretes;

import az.rock.flyjob.js.dataaccess.mapper.abstracts.AbstractProjectDataAccessMapper;
import az.rock.flyjob.js.dataaccess.model.entity.resume.ResumeEntity;
import az.rock.flyjob.js.dataaccess.model.entity.resume.details.ProjectEntity;
import az.rock.flyjob.js.domain.core.root.detail.ProjectRoot;
import az.rock.lib.domain.id.js.ProjectID;
import az.rock.lib.domain.id.js.ResumeID;
import az.rock.lib.util.GDateTime;
import az.rock.lib.valueObject.Version;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class ProjectDataAccessMapper implements AbstractProjectDataAccessMapper {
    @Override
    public Optional<ProjectRoot> toRoot(ProjectEntity entity) {
        var optionalEntity = Optional.ofNullable(entity);
        if (optionalEntity.isEmpty()) return Optional.empty();
        return Optional.of(ProjectRoot.Builder
                .builder()
                .link(entity.getLink())
                .subtitle(entity.getSubtitle())
                .title(entity.getTitle())
                .createdDate(GDateTime.toZonedDateTime(entity.getCreatedDate()))
                .description(entity.getDescription())
                .resume(ResumeID.of(entity.getResume().getUuid()))
                .id(ProjectID.of(entity.getUuid()))
                .orderNumber(entity.getOrderNumber()).version(Version.of(entity.getVersion()))
                .startDate(entity.getStartDate())
                .endDate(entity.getEndDate())
                .rowStatus(entity.getRowStatus())
                .build());
    }

    @Override
    public Optional<ProjectEntity> toEntity(ProjectRoot root) {
        var optionalRoot = Optional.ofNullable(root);
        if (optionalRoot.isEmpty()) return Optional.empty();
        return Optional.of(ProjectEntity.Builder.builder()
                .uuid(root.getRootID().getAbsoluteID())
                .resume(ResumeEntity.referenceOf(root.getResume().getAbsoluteID()))
                .version(root.getVersionValue())
                .rowStatus(root.getRowStatus())
                .processStatus(root.getProcessStatus())
                .accessModifier(root.getAccessModifier())
                .link(root.getLink())
                .title(root.getTitle())
                .subtitle(root.getSubtitle())
                .startDate(root.getStartDate())
                .endDate(root.getEndDate())
                .orderNumber(root.getOrderNumber())
                .description(root.getDescription())
                .build());

    }
}
