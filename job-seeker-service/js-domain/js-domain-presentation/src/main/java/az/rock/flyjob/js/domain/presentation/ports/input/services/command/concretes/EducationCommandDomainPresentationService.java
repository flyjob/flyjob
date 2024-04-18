package az.rock.flyjob.js.domain.presentation.ports.input.services.command.concretes;

import az.rock.flyjob.js.domain.presentation.dto.request.abstracts.CreateRequest;
import az.rock.flyjob.js.domain.presentation.dto.request.abstracts.UpdateRequest;
import az.rock.flyjob.js.domain.presentation.dto.request.item.EducationCommandModel;
import az.rock.flyjob.js.domain.presentation.dto.request.item.ReorderCommandModel;
import az.rock.flyjob.js.domain.presentation.handler.abstracts.AbstractEducationCommandHandler;
import az.rock.flyjob.js.domain.presentation.ports.input.services.command.abstracts.AbstractEducationCommandDomainPresentationService;
import az.rock.lib.annotation.InputPort;
import az.rock.lib.jexception.JRuntimeException;
import com.intellibucket.lib.payload.event.abstracts.AbstractDomainEvent;
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
    public void create(CreateRequest<EducationCommandModel> request) {
        try {
            this.abstractEducationCommandHandler.create(request);
        } catch (Exception e) {
            throw new JRuntimeException(e.getMessage(),e);
        }
    }

    @Override
    public void update(UpdateRequest<EducationCommandModel> request) {
        try {
            this.abstractEducationCommandHandler.update(request);
        } catch (Exception e) {
            throw new JRuntimeException(e.getMessage(),e);
        }
    }

    @Override
    public void delete(UUID educationId) {
        try {
            this.abstractEducationCommandHandler.delete(educationId);
        } catch (Exception e) {
            throw new JRuntimeException(e.getMessage(),e);
        }
    }

    @Override
    public void reorder(ReorderCommandModel request) {
        try {
            this.abstractEducationCommandHandler.reorder(request);
        } catch (Exception e) {
            throw new JRuntimeException(e.getMessage(),e);
        }
    }
}
