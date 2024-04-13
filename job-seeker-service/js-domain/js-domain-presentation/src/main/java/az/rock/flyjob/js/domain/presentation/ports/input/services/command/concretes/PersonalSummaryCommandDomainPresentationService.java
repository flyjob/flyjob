package az.rock.flyjob.js.domain.presentation.ports.input.services.command.concretes;


import az.rock.flyjob.js.domain.presentation.handler.abstracts.AbstractPersonalSummaryCommandHandler;
import az.rock.flyjob.js.domain.presentation.ports.input.services.command.abstracts.AbstractPersonalSummaryCommandDomainPresentationService;
import az.rock.lib.valueObject.SimpleContext;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class PersonalSummaryCommandDomainPresentationService implements AbstractPersonalSummaryCommandDomainPresentationService {

    private final AbstractPersonalSummaryCommandHandler interestCreateCommandHandler;


    public PersonalSummaryCommandDomainPresentationService(@Qualifier("personalSummaryCommandHandler") AbstractPersonalSummaryCommandHandler interestCommandHandler) {
        this.interestCreateCommandHandler = interestCommandHandler;
    }

    @Override
    @SneakyThrows
    public void changeSummary(SimpleContext context) {
        interestCreateCommandHandler.changeSummary(context);
    }
}
