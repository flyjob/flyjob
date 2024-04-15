package az.rock.flyjob.js.domain.presentation.mapper.abstracts;

import az.rock.flyjob.js.domain.core.root.detail.ExperienceRoot;
import az.rock.flyjob.js.domain.presentation.dto.request.item.ExperienceCommandModel;
import az.rock.lib.domain.id.js.ResumeID;
import com.intellibucket.lib.payload.payload.command.ExperiencePayload;

public interface AbstractExperienceDomainMapper {
    ExperienceRoot toNewRoot(ResumeID resumeID, ExperienceCommandModel commandModel);
    ExperienceRoot toExistRoot(ExperienceRoot experienceRoot, ExperienceCommandModel commandModel);


}
