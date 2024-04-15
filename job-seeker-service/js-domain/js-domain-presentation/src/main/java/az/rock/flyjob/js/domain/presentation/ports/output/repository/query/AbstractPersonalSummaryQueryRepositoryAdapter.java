package az.rock.flyjob.js.domain.presentation.ports.output.repository.query;

import az.rock.flyjob.js.domain.core.root.detail.InterestRoot;
import az.rock.flyjob.js.domain.core.root.detail.PersonalSummaryRoot;
import az.rock.lib.adapter.repository.AbstractQueryRepositoryAdapter;
import az.rock.lib.domain.id.js.InterestID;
import az.rock.lib.domain.id.js.PersonalSummaryID;
import az.rock.lib.domain.id.js.ResumeID;
import az.rock.lib.valueObject.AccessModifier;

import java.util.List;
import java.util.Optional;

public interface AbstractPersonalSummaryQueryRepositoryAdapter  extends AbstractQueryRepositoryAdapter<PersonalSummaryRoot, PersonalSummaryID, ResumeID> {
    Optional<PersonalSummaryRoot> findByPID(ResumeID parentID,PersonalSummaryID rootId, List<AccessModifier> accessModifiers);
}
