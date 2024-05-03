package az.rock.flyjob.js.domain.presentation.dto.criteria;

import az.rock.lib.domain.id.js.ResumeID;
import az.rock.lib.valueObject.AccessModifier;

import java.util.List;
import java.util.UUID;

public class ProjectCriteria {
    private UUID id;
    private ResumeID resume;
    private List<AccessModifier> accessModifier;
}
