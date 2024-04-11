package az.rock.flyjob.js.domain.presentation.mapper.abstracts;

import az.rock.flyjob.js.domain.core.root.detail.PersonalSummaryRoot;
import az.rock.lib.valueObject.SimpleContext;

public interface AbstractPersonalSummaryDomainMapper {
    PersonalSummaryRoot toRoot(PersonalSummaryRoot root, SimpleContext personalContext);
}
