package az.rock.flyjob.js.domain.presentation.ports.input.services.command.abstracts;

import az.rock.flyjob.js.domain.presentation.dto.request.abstracts.CreateRequest;
import az.rock.flyjob.js.domain.presentation.dto.request.abstracts.ReorderRequest;
import az.rock.flyjob.js.domain.presentation.dto.request.abstracts.UpdateRequest;
import az.rock.flyjob.js.domain.presentation.dto.request.item.ContactCommandModel;

import java.util.UUID;

public interface AbstractContactCommandDomainPresentationService {
    void create(CreateRequest<ContactCommandModel> request);
    void update(UpdateRequest<ContactCommandModel> request);
    void delete(UUID contactId);

    void reorder(ReorderRequest<ContactCommandModel> request);
}
