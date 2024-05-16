package az.rock.flyjob.js.domain.presentation.ports.input.services.command.concretes;

import az.rock.flyjob.js.domain.presentation.dto.request.abstracts.CreateRequest;
import az.rock.flyjob.js.domain.presentation.dto.request.abstracts.UpdateRequest;
import az.rock.flyjob.js.domain.presentation.dto.request.item.EducationCommandModel;
import az.rock.flyjob.js.domain.presentation.dto.request.item.ReorderCommandModel;
import az.rock.flyjob.js.domain.presentation.handler.abstracts.AbstractEducationCommandHandler;
import az.rock.flyjob.js.domain.presentation.ports.input.services.command.abstracts.AbstractEducationCommandDomainPresentationService;
import az.rock.lib.annotation.InputPort;
import com.intellibucket.lib.payload.event.abstracts.AbstractDomainEvent;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;

import java.util.UUID;

@InputPort
@Service
public class EducationCommandDomainPresentationService implements AbstractEducationCommandDomainPresentationService {

    private final AbstractEducationCommandHandler<AbstractDomainEvent<?>> abstractEducationCommandHandler;

    public EducationCommandDomainPresentationService(AbstractEducationCommandHandler<AbstractDomainEvent<?>> abstractEducationCommandHandler) {
        this.abstractEducationCommandHandler = abstractEducationCommandHandler;
    }

    @Override
    @SneakyThrows
    public void create(CreateRequest<EducationCommandModel> request) {
        this.abstractEducationCommandHandler.create(request);
    }

    @Override
    @SneakyThrows
    public void update(UpdateRequest<EducationCommandModel> request) {
        this.abstractEducationCommandHandler.update(request);
    }

    @Override
    @SneakyThrows
    public void delete(UUID educationId) {
        this.abstractEducationCommandHandler.delete(educationId);
    }

    @Override
    @SneakyThrows
    public void reorder(ReorderCommandModel request) {
        this.abstractEducationCommandHandler.reorder(request);
    }
}
