package az.rock.flyjob.js.domain.presentation.mapper.concretes;

import az.rock.flyjob.js.domain.core.root.detail.EducationRoot;
import az.rock.flyjob.js.domain.presentation.dto.criteria.EducationCriteria;
import az.rock.flyjob.js.domain.presentation.dto.request.item.EducationCommandModel;
import az.rock.flyjob.js.domain.presentation.mapper.abstracts.AbstractEducationDomainMapper;
import az.rock.lib.domain.id.js.EducationID;
import az.rock.lib.domain.id.js.ResumeID;
import az.rock.lib.valueObject.AccessModifier;
import az.rock.lib.valueObject.ProcessStatus;
import az.rock.lib.valueObject.RowStatus;
import az.rock.lib.valueObject.Version;
import com.intellibucket.lib.payload.payload.command.EducationPayload;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class EducationDomainMapper implements AbstractEducationDomainMapper {
    @Override
    public EducationRoot toNewRoot(ResumeID resumeID, EducationCommandModel educationCommandModel) {
        return EducationRoot.Builder
                .builder()
                .uuid(EducationID.of(UUID.randomUUID()))
                .version(Version.ONE)
                .accessModifier(AccessModifier.PUBLIC)
                .processStatus(ProcessStatus.COMPLETED)
                .rowStatus(RowStatus.ACTIVE)
                .resume(resumeID)
                .orderNumber(-1)
                .degree(educationCommandModel.getDegree())
                .state(educationCommandModel.getState())
                .link(educationCommandModel.getLink())
                .establishmentUUID(educationCommandModel.getEstablishmentUUID())
                .establishmentName(educationCommandModel.getEstablishmentName())
                .cityId(educationCommandModel.getCityId())
                .startDate(educationCommandModel.getStartDate())
                .endDate(educationCommandModel.getEndDate())
                .description(educationCommandModel.getDescription())
                .build();
    }




    @Override
    public EducationRoot toExistRoot(EducationRoot educationRoot, EducationCommandModel educationCommandModel) {
        educationRoot
                .changeEducationDegree(educationCommandModel.getDegree())
                .changeEducationDescription(educationCommandModel.getDescription())
                .changeEducationState(educationCommandModel.getState())
                .changeEducationStartDate(educationCommandModel.getStartDate())
                .changeEducationEndDate(educationCommandModel.getEndDate())
                .changeLink(educationCommandModel.getLink())
                .changeEstablishmentName(educationCommandModel.getEstablishmentName());
        return educationRoot;
    }

    @Override
    public EducationPayload toPayload(EducationRoot educationRoot) {
        return EducationPayload
                .builder()
                .id(educationRoot.getRootID().getAbsoluteID())
                .resumeId(educationRoot.getResumeID().getRootID())
                .accessModifier(educationRoot.getAccessModifier())
                .build();
    }


}