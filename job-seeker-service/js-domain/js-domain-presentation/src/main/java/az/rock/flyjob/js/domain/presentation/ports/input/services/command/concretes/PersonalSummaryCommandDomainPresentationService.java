package az.rock.flyjob.js.domain.presentation.ports.input.services.command.concretes;


import az.rock.flyjob.js.domain.presentation.handler.abstracts.AbstractPersonalSummaryCommandHandler;
import az.rock.flyjob.js.domain.presentation.ports.input.services.command.abstracts.AbstractPersonalSummaryCommandDomainPresentationService;
import az.rock.lib.valueObject.SimpleContext;
import org.springframework.stereotype.Component;

@Component
public class PersonalSummaryCommandDomainPresentationService implements AbstractPersonalSummaryCommandDomainPresentationService {

    private final AbstractPersonalSummaryCommandHandler interestCreateCommandHandler;


    public PersonalSummaryCommandDomainPresentationService(AbstractPersonalSummaryCommandHandler interestCommandHandler) {
        this.interestCreateCommandHandler = interestCommandHandler;
    }

    @Override
    public void changeSummary(SimpleContext context) {

    }
}
