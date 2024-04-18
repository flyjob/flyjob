package az.rock.flyjob.js.domain.presentation.mapper.abstracts;

import az.rock.flyjob.js.domain.core.root.detail.InterestRoot;
import az.rock.flyjob.js.domain.presentation.dto.request.item.InterestCommandModel;
import az.rock.lib.domain.id.js.ResumeID;

public interface AbstractInterestDomainMapper {
    InterestRoot toNewRoot(ResumeID resumeID, InterestCommandModel interestCommandModel);
}
