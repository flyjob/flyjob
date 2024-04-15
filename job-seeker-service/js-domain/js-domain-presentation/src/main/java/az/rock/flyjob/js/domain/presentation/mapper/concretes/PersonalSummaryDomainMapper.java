package az.rock.flyjob.js.domain.presentation.mapper.concretes;


import az.rock.flyjob.js.domain.core.root.detail.PersonalSummaryRoot;
import az.rock.flyjob.js.domain.presentation.dto.request.item.PersonalSummaryCommandModel;
import az.rock.flyjob.js.domain.presentation.mapper.abstracts.AbstractPersonalSummaryDomainMapper;
import az.rock.lib.domain.id.js.PersonalSummaryID;
import az.rock.lib.domain.id.js.ResumeID;
import az.rock.lib.valueObject.*;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class PersonalSummaryDomainMapper implements AbstractPersonalSummaryDomainMapper {



    @Override
    public PersonalSummaryRoot toRoot(PersonalSummaryRoot root, SimpleContext personalContext) {
        return PersonalSummaryRoot.Builder.builder()
                .summary(personalContext.getContext())
                .id(root.getRootID())
                .accessModifier(root.getAccessModifier())
                .createdDate(root.getCreatedDate())
                .processStatus(root.getProcessStatus())
                .resume(ResumeID.of(root.getResume().getRootID()))
                .version(root.getVersion())
                .rowStatus(root.getRowStatus())
                .build();
    }

    @Override
    public PersonalSummaryRoot toNewRoot(ResumeID resumeID, PersonalSummaryCommandModel context) {
        var summaryId = UUID.randomUUID();
        return PersonalSummaryRoot.Builder.builder()
                .id(PersonalSummaryID.of(summaryId))
                .resume(resumeID)
                .summary(context.getContext())
                .version(Version.ONE)
                .processStatus(ProcessStatus.COMPLETED)
                .rowStatus(RowStatus.ACTIVE)
                .accessModifier(AccessModifier.PUBLIC)
                .build();


    }
}
