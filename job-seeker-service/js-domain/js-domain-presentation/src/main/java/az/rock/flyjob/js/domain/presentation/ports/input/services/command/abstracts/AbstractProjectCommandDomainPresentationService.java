package az.rock.flyjob.js.domain.presentation.ports.input.services.command.abstracts;

import az.rock.flyjob.js.domain.presentation.dto.request.abstracts.CreateRequest;
import az.rock.flyjob.js.domain.presentation.dto.request.abstracts.UpdateRequest;
import az.rock.flyjob.js.domain.presentation.dto.request.item.ProjectCommandModel;
import az.rock.flyjob.js.domain.presentation.dto.request.item.ReorderCommandModel;

import java.util.UUID;

public interface AbstractProjectCommandDomainPresentationService {
    void create(CreateRequest<ProjectCommandModel> request);

    void update(UpdateRequest<ProjectCommandModel> request);

    void delete(UUID projectId);

    void reorder(ReorderCommandModel request);
}
