package az.rock.flyjob.js.domain.presentation.ports.input.services.command.concretes;

import az.rock.flyjob.js.domain.presentation.dto.request.abstracts.CreateRequest;
import az.rock.flyjob.js.domain.presentation.dto.request.abstracts.UpdateRequest;
import az.rock.flyjob.js.domain.presentation.dto.request.item.ProjectCommandModel;
import az.rock.flyjob.js.domain.presentation.dto.request.item.ReorderCommandModel;
import az.rock.flyjob.js.domain.presentation.handler.abstracts.AbstractProjectCommandHandler;
import az.rock.flyjob.js.domain.presentation.ports.input.services.command.abstracts.AbstractProjectCommandDomainPresentationService;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class ProjectCommandDomainPresentationService implements AbstractProjectCommandDomainPresentationService {
   private   final AbstractProjectCommandHandler projectCommandHandler;

    public ProjectCommandDomainPresentationService(AbstractProjectCommandHandler projectCommandHandler) {
        this.projectCommandHandler = projectCommandHandler;
    }

    @Override
    public void create(CreateRequest<ProjectCommandModel> request) {
     projectCommandHandler.create(request);
    }

    @Override
    public void update(UpdateRequest<ProjectCommandModel> request) {
     projectCommandHandler.update(request);
    }

    @Override
    public void delete(UUID projectId) {
     projectCommandHandler.delete(projectId);
    }

    @Override
    public void reorder(ReorderCommandModel request) {
     projectCommandHandler.reorder(request);
    }
}
