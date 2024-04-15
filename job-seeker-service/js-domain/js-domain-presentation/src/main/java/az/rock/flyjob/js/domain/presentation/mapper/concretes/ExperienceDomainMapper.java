package az.rock.flyjob.js.domain.presentation.mapper.concretes;

import az.rock.flyjob.js.domain.core.root.detail.ExperienceRoot;
import az.rock.flyjob.js.domain.presentation.dto.request.item.ExperienceCommandModel;
import az.rock.flyjob.js.domain.presentation.mapper.abstracts.AbstractExperienceDomainMapper;
import az.rock.lib.domain.id.js.ExperienceID;
import az.rock.lib.domain.id.js.ResumeID;
import az.rock.lib.valueObject.AccessModifier;
import az.rock.lib.valueObject.ProcessStatus;
import az.rock.lib.valueObject.RowStatus;
import az.rock.lib.valueObject.Version;
import com.intellibucket.lib.payload.payload.command.EducationPayload;
import com.intellibucket.lib.payload.payload.command.ExperiencePayload;

import java.util.UUID;

public class ExperienceDomainMapper implements AbstractExperienceDomainMapper {
    @Override
    public ExperienceRoot toNewRoot(ResumeID resumeID, ExperienceCommandModel commandModel) {
        return ExperienceRoot.Builder
                .builder()
                .id(ExperienceID.of(UUID.randomUUID()))
                .version(Version.ONE)
                .accessModifier(AccessModifier.PUBLIC)
                .processStatus(ProcessStatus.COMPLETED)
                .rowStatus(RowStatus.ACTIVE)
                .cityId(commandModel.getCityId())
                .employer(commandModel.getEmployer())
                .jobTitle(commandModel.getEmployer())
                .description(commandModel.getDescription())
                .link(commandModel.getLink())
                .workingTimeType(commandModel.getWorkingTimeLine())
                .workingType(commandModel.getWorkingType())
                .orderNumber(-1)
                .startDate(commandModel.getStartDate())
                .endDate(commandModel.getEndDate())
                .resume(resumeID)
                .build();
    }

    @Override
    public ExperienceRoot toExistRoot(ExperienceRoot experienceRoot, ExperienceCommandModel commandModel) {
        return null;
    }


}
