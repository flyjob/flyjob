package az.rock.flyjob.js.domain.presentation.ports.output.repository.command;

import az.rock.flyjob.js.domain.core.root.detail.InterestRoot;
import az.rock.flyjob.js.domain.core.root.detail.PersonalSummaryRoot;
import az.rock.lib.annotation.DomainOutputPort;

import java.util.Optional;

@DomainOutputPort
public interface AbstractPersonalSummaryCommandRepositoryAdapter  {
    Optional<InterestRoot> changeSummary(PersonalSummaryRoot root);

}
