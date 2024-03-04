package az.rock.flyjob.js.domain.presentation.ports.input.services.command.abstracts;

import az.rock.flyjob.js.domain.presentation.dto.request.abstracts.CreateRequest;
import az.rock.flyjob.js.domain.presentation.dto.request.abstracts.UpdateRequest;
import az.rock.flyjob.js.domain.presentation.dto.request.item.ContactCommandModel;
import az.rock.flyjob.js.domain.presentation.dto.request.item.ReorderCommandModel;

import java.rmi.server.UID;

public interface AbstractContactCommmandDomainPresentationService {
    void create(CreateRequest<ContactCommandModel> request);
    void update(UpdateRequest<ContactCommandModel> request);
    void delete(UID contactId);
    void reorder(ReorderCommandModel request);
}
