package az.rock.flyjob.js.domain.presentation.handler.abstracts;

import az.rock.flyjob.js.domain.core.exception.interest.InterestDomainException;
import az.rock.flyjob.js.domain.core.exception.interest.InterestNotFound;
import az.rock.flyjob.js.domain.presentation.dto.request.abstracts.UpdateRequest;
import az.rock.flyjob.js.domain.presentation.dto.request.item.InterestCommandModel;
import az.rock.flyjob.js.domain.presentation.dto.request.item.ReorderCommandModel;
import com.intellibucket.lib.payload.event.command.create.InterestCreateEvent;
import com.intellibucket.lib.payload.event.command.update.InterestDeleteEvent;
import com.intellibucket.lib.payload.event.command.update.InterestReorderEvent;
import com.intellibucket.lib.payload.event.command.update.InterestUpdateEvent;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Transactional(propagation = Propagation.REQUIRES_NEW)
public interface AbstractInterestCreateCommandHandler {
    InterestCreateEvent add(InterestCommandModel interestCommandModel) throws InterestDomainException;

    InterestUpdateEvent update(UpdateRequest<InterestCommandModel> interestCommandModelUpdateRequest) throws InterestDomainException;

    InterestDeleteEvent delete(UUID interestId) throws InterestNotFound;

   InterestReorderEvent reorder(ReorderCommandModel request) throws InterestNotFound;



}
