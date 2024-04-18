package az.rock.flyjob.js.domain.presentation.ports.output.repository.command;

import az.rock.flyjob.js.domain.core.root.detail.InterestRoot;
import az.rock.lib.adapter.repository.AbstractCommandRepositoryAdapter;
import az.rock.lib.annotation.DomainOutputPort;

import java.util.Optional;
@DomainOutputPort
public interface AbstractInterestCommandRepositoryAdapter extends AbstractCommandRepositoryAdapter<InterestRoot> {
    Optional<InterestRoot> create(InterestRoot root);
}
