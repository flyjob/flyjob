package az.rock.flyjob.js.domain.presentation.ports.input.services.command.abstracts;

import az.rock.flyjob.js.domain.presentation.dto.request.item.PersonalSummaryCommandModel;
import az.rock.lib.valueObject.SimpleContext;

import java.util.UUID;

public interface AbstractPersonalSummaryCommandDomainPresentationService {
    void createSummary(PersonalSummaryCommandModel context);
    void changeSummary(SimpleContext context );

    void deleteSummary(UUID summaryId);


}
