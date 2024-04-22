package az.rock.flyjob.js.domain.presentation.handler.abstracts;

import az.rock.flyjob.js.domain.presentation.dto.request.abstracts.CreateRequest;
import az.rock.flyjob.js.domain.presentation.dto.request.abstracts.ReorderRequest;
import az.rock.flyjob.js.domain.presentation.dto.request.abstracts.UpdateRequest;
import az.rock.flyjob.js.domain.presentation.dto.request.item.ContactCommandModel;
import az.rock.flyjob.js.domain.presentation.dto.request.item.ReorderCommandModel;
import az.rock.lib.domain.id.js.ResumeID;
import com.intellibucket.lib.payload.event.command.create.ContactCreatedEvent;
import com.intellibucket.lib.payload.event.delete.ContactDeleteEvent;
import com.intellibucket.lib.payload.event.reorder.ContactReorderEvent;
import com.intellibucket.lib.payload.event.update.ContactUpdateEvent;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Transactional(propagation = Propagation.REQUIRES_NEW)
public interface AbstractContactCommandHandler {

    ContactCreatedEvent createContact (CreateRequest<ContactCommandModel> commandModel);

    ContactUpdateEvent updateContact (UpdateRequest<ContactCommandModel> commandModel);

    ContactDeleteEvent deleteContact(UUID uid);
    ContactDeleteEvent deleteAllContact();

    ContactReorderEvent reOrderContact(ReorderCommandModel commandModel);

}