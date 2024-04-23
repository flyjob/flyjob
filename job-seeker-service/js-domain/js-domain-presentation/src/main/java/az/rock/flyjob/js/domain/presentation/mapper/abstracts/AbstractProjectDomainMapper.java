package az.rock.flyjob.js.domain.presentation.mapper.abstracts;

import az.rock.flyjob.js.domain.core.root.detail.ProjectRoot;
import az.rock.flyjob.js.domain.presentation.dto.request.item.ProjectCommandModel;
import az.rock.lib.domain.id.js.ResumeID;
import com.intellibucket.lib.payload.payload.command.EducationPayload;
import com.intellibucket.lib.payload.payload.command.ProjectPayload;

public interface AbstractProjectDomainMapper {
    ProjectRoot toNewRoot(ResumeID resumeID, ProjectCommandModel projectCommandModel);

    ProjectPayload toPayload(ProjectRoot projectRoot);

    ProjectRoot toExistRoot(ProjectRoot projectRoot, ProjectCommandModel projectCommandModel);
}
