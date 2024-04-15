package az.rock.flyjob.js.domain.presentation.mapper.abstracts;

import az.rock.flyjob.js.domain.core.root.detail.PersonalSummaryRoot;
import az.rock.flyjob.js.domain.presentation.dto.request.item.PersonalSummaryCommandModel;
import az.rock.lib.domain.id.js.ResumeID;
import az.rock.lib.valueObject.SimpleContext;

public interface AbstractPersonalSummaryDomainMapper {
    PersonalSummaryRoot toRoot(PersonalSummaryRoot root, SimpleContext personalContext);

    PersonalSummaryRoot toNewRoot(ResumeID resumeID, PersonalSummaryCommandModel context);
}
