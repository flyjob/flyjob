package az.rock.flyjob.js.domain.presentation.handler.abstracts;

import az.rock.flyjob.js.domain.core.exception.summary.SummaryNotFound;
import az.rock.lib.valueObject.SimpleContext;
import com.intellibucket.lib.payload.event.command.update.PersonalSummaryChangedEvent;

public interface AbstractPersonalSummaryCommandHandler {
    PersonalSummaryChangedEvent changeSummary(SimpleContext context) throws SummaryNotFound;


}
