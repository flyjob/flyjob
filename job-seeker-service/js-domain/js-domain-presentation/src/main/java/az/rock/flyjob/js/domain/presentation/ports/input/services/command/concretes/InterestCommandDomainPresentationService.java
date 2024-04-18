package az.rock.flyjob.js.domain.presentation.ports.input.services.command.concretes;

import az.rock.flyjob.js.domain.presentation.dto.request.abstracts.UpdateRequest;
import az.rock.flyjob.js.domain.presentation.dto.request.item.InterestCommandModel;
import az.rock.flyjob.js.domain.presentation.dto.request.item.ReorderCommandModel;
import az.rock.flyjob.js.domain.presentation.handler.abstracts.AbstractInterestCreateCommandHandler;
import az.rock.flyjob.js.domain.presentation.ports.input.services.command.abstracts.AbstractInterestCommandDomainPresentationService;
import lombok.SneakyThrows;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class InterestCommandDomainPresentationService implements AbstractInterestCommandDomainPresentationService {

    private final AbstractInterestCreateCommandHandler interestCreateCommandHandler;

    public InterestCommandDomainPresentationService(AbstractInterestCreateCommandHandler interestCreateCommandHandler) {
        this.interestCreateCommandHandler = interestCreateCommandHandler;
    }

    @Override
    @SneakyThrows
    public void create(InterestCommandModel interestCommandModel) {
        var interestCreatedEvent = this.interestCreateCommandHandler.add(interestCommandModel);
    }

    @Override
    @SneakyThrows
    public void update(UpdateRequest<InterestCommandModel> updateRequest) {
        var interestUpdateEvent = this.interestCreateCommandHandler.update(updateRequest);
    }

    @Override
    @SneakyThrows
    public void delete(UUID interestId) {
        var delete = this.interestCreateCommandHandler.delete(interestId);
    }

    @Override
    @SneakyThrows
    public void reorder(ReorderCommandModel request) {
        var reorder = this.interestCreateCommandHandler.reorder(request);
    }
}
