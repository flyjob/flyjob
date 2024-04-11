package az.rock.flyjob.js.domain.presentation.mapper.concretes;


import az.rock.flyjob.js.domain.core.root.detail.PersonalSummaryRoot;
import az.rock.flyjob.js.domain.presentation.mapper.abstracts.AbstractPersonalSummaryDomainMapper;
import az.rock.lib.domain.id.js.ResumeID;
import az.rock.lib.valueObject.SimpleContext;
import org.springframework.stereotype.Component;

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
                .resume(ResumeID.of(personalContext.getTargetId()))
                .version(root.getVersion())
                .rowStatus(root.getRowStatus())
                .build();
    }
}
