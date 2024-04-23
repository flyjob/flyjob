package az.rock.flyjob.js.domain.presentation.ports.output.repository.command;

import az.rock.flyjob.js.domain.core.root.detail.ProjectRoot;
import az.rock.lib.adapter.repository.AbstractCommandRepositoryAdapter;
import az.rock.lib.annotation.DomainOutputPort;

@DomainOutputPort
public interface AbstractProjectCommandRepositoryAdapter extends AbstractCommandRepositoryAdapter<ProjectRoot> {

}
