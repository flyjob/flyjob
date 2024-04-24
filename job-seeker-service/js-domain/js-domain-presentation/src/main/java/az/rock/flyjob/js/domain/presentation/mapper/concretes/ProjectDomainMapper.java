package az.rock.flyjob.js.domain.presentation.mapper.concretes;

import az.rock.flyjob.js.domain.core.root.detail.ProjectRoot;
import az.rock.flyjob.js.domain.presentation.dto.request.item.ProjectCommandModel;
import az.rock.flyjob.js.domain.presentation.mapper.abstracts.AbstractProjectDomainMapper;
import az.rock.lib.domain.id.js.ProjectID;
import az.rock.lib.domain.id.js.ResumeID;
import az.rock.lib.valueObject.AccessModifier;
import az.rock.lib.valueObject.ProcessStatus;
import az.rock.lib.valueObject.RowStatus;
import az.rock.lib.valueObject.Version;
import com.intellibucket.lib.payload.payload.command.ProjectPayload;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class ProjectDomainMapper implements AbstractProjectDomainMapper {
    @Override
    public ProjectRoot toNewRoot(ResumeID resumeID, ProjectCommandModel projectCommandModel) {
        return ProjectRoot.Builder
                .builder()
                .id(ProjectID.of(UUID.randomUUID()))
                .accessModifier(AccessModifier.PUBLIC)
                .processStatus(ProcessStatus.COMPLETED)
                .rowStatus(RowStatus.ACTIVE)
                .resume(resumeID)
                .orderNumber(-1)
                .description(projectCommandModel.getDescription())
                .link(projectCommandModel.getLink())
                .subtitle(projectCommandModel.getSubtitle())
                .endDate(projectCommandModel.getEndDate())
                .startDate(projectCommandModel.getStartDate())
                .version(Version.ONE)
                .title(projectCommandModel.getTitle())
                .build();
    }

    @Override
    public ProjectPayload toPayload(ProjectRoot projectRoot) {
        return ProjectPayload.Builder
                .builder()
                .id(projectRoot.getRootID().getAbsoluteID())
                .resume(projectRoot.getResume().getRootID())
                .accessModifier(projectRoot.getAccessModifier())
                .build();

    }

    @Override
    public ProjectRoot toExistRoot(ProjectRoot projectRoot, ProjectCommandModel projectCommandModel) {
        return projectRoot
                .changeTitle(projectCommandModel.getTitle())
                .changeStartDate(projectCommandModel.getStartDate())
                .changeEndDate(projectCommandModel.getEndDate())
                .changeDescription(projectCommandModel.getDescription())
                .changeSubTitle(projectCommandModel.getSubtitle())
                .changeLink(projectCommandModel.getLink());
    }
}