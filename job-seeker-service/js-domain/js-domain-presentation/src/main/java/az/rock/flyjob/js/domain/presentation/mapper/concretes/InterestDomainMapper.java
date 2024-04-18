package az.rock.flyjob.js.domain.presentation.mapper.concretes;

import az.rock.flyjob.js.domain.core.root.detail.InterestRoot;
import az.rock.flyjob.js.domain.presentation.dto.request.item.InterestCommandModel;
import az.rock.flyjob.js.domain.presentation.mapper.abstracts.AbstractInterestDomainMapper;
import az.rock.lib.domain.id.js.InterestID;
import az.rock.lib.domain.id.js.ResumeID;
import az.rock.lib.valueObject.AccessModifier;
import az.rock.lib.valueObject.ProcessStatus;
import az.rock.lib.valueObject.RowStatus;
import az.rock.lib.valueObject.Version;
import org.springframework.stereotype.Component;


import java.time.ZonedDateTime;
import java.util.UUID;

@Component
public class InterestDomainMapper implements AbstractInterestDomainMapper {
    @Override
    public InterestRoot toNewRoot(ResumeID resumeID, InterestCommandModel interestCommandModel) {
        return InterestRoot.Builder
                .builder()
                .id(InterestID.of(UUID.randomUUID()))
                .version(Version.ONE)
                .accessModifier(AccessModifier.PUBLIC)
                .processStatus(ProcessStatus.COMPLETED)
                .rowStatus(RowStatus.ACTIVE)
                .isHobby(interestCommandModel.getHobby())
                .orderNumber(0)
                .createdDate(ZonedDateTime.now())
                .resume(resumeID)
                .name(interestCommandModel.getName())
                .description(interestCommandModel.getDescription())
                .build();
    }
}
