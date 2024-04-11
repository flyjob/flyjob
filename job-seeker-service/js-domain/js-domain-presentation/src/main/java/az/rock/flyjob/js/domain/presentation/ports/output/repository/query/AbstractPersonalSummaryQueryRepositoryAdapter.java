package az.rock.flyjob.js.domain.presentation.ports.output.repository.query;

import az.rock.flyjob.js.domain.core.root.detail.InterestRoot;
import az.rock.flyjob.js.domain.core.root.detail.PersonalSummaryRoot;
import az.rock.lib.adapter.repository.AbstractQueryRepositoryAdapter;
import az.rock.lib.domain.id.js.InterestID;
import az.rock.lib.domain.id.js.PersonalSummaryID;
import az.rock.lib.domain.id.js.ResumeID;

public interface AbstractPersonalSummaryQueryRepositoryAdapter  extends AbstractQueryRepositoryAdapter<PersonalSummaryRoot, PersonalSummaryID, ResumeID> {
}
