package az.rock.flyjob.js.domain.presentation.ports.output.repository.command;

import az.rock.flyjob.js.domain.core.root.detail.EducationRoot;
import az.rock.lib.adapter.repository.AbstractCommandRepositoryAdapter;
import az.rock.lib.annotation.DomainOutputPort;

@DomainOutputPort
public interface AbstractEducationCommandRepositoryAdapter extends AbstractCommandRepositoryAdapter<EducationRoot> {
}
