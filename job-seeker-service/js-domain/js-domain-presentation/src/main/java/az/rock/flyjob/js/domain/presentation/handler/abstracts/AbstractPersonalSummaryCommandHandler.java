package az.rock.flyjob.js.domain.presentation.handler.abstracts;

import az.rock.flyjob.js.domain.core.exception.summary.SummaryAlreadyExist;
import az.rock.flyjob.js.domain.core.exception.summary.SummaryNotFound;
import az.rock.flyjob.js.domain.presentation.dto.request.item.PersonalSummaryCommandModel;
import az.rock.lib.valueObject.SimpleContext;
import com.intellibucket.lib.payload.event.command.create.PersonalSummaryCreatedEvent;
import com.intellibucket.lib.payload.event.command.delete.PersonalSummaryDeletedEvent;
import com.intellibucket.lib.payload.event.command.update.PersonalSummaryChangedEvent;

import java.util.UUID;

public interface AbstractPersonalSummaryCommandHandler {

    PersonalSummaryCreatedEvent createSummary(PersonalSummaryCommandModel context) throws SummaryNotFound, SummaryAlreadyExist;

    PersonalSummaryChangedEvent changeSummary(SimpleContext context) throws SummaryNotFound;

    PersonalSummaryDeletedEvent deleteSummary(UUID summaryId) throws SummaryNotFound;


}
