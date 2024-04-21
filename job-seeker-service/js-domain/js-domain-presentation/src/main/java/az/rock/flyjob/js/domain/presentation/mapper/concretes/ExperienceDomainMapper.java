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
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class ExperienceDomainMapper implements AbstractExperienceDomainMapper {
    @Override
    public ExperiencePayload toPayload(ExperienceRoot experienceRoot) {
        return ExperiencePayload
                .Builder.builder().id(experienceRoot.getRootID().getAbsoluteID())
                .resume(experienceRoot.getResume())
                .accessModifier(experienceRoot.getAccessModifier())
                .build();
    }

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
        experienceRoot
                .changeStartDate(commandModel.getStartDate())
                .changeCityId(commandModel.getCityId())
                .changeEmployer(commandModel.getEmployer())
                .changeEndDate(commandModel.getEndDate())
                .changeLink(commandModel.getLink())
                .changeOrderNumber(commandModel.getOrderNumber())
                .changeJobTitle(commandModel.getJobTitle())
                .changeWorkingTimeLineType(commandModel.getWorkingTimeLine())
                .changeWorkingType(commandModel.getWorkingType())
                .changeDescription(commandModel.getDescription());
                return experienceRoot;
    }


}
