package az.rock.flyjob.js.domain.presentation.ports.input.services.command.concretes;

import az.rock.flyjob.js.domain.presentation.dto.request.abstracts.CreateRequest;
import az.rock.flyjob.js.domain.presentation.dto.request.abstracts.UpdateRequest;
import az.rock.flyjob.js.domain.presentation.dto.request.item.ExperienceCommandModel;
import az.rock.flyjob.js.domain.presentation.dto.request.item.ReorderCommandModel;
import az.rock.flyjob.js.domain.presentation.handler.abstracts.AbstractEducationCommandHandler;
import az.rock.flyjob.js.domain.presentation.handler.abstracts.AbstractExperienceCommandHandler;
import az.rock.flyjob.js.domain.presentation.ports.input.services.command.abstracts.AbstractExperienceCommandDomainPresentationService;
import az.rock.lib.annotation.InputPort;
import az.rock.lib.jexception.JRuntimeException;
import com.intellibucket.lib.payload.event.abstracts.AbstractDomainEvent;
import org.springframework.stereotype.Service;

import java.util.UUID;

@InputPort
@Service
public class ExperienceCommandDomainPresentationService implements AbstractExperienceCommandDomainPresentationService {
    private final AbstractExperienceCommandHandler experienceCommandHandler;

    public ExperienceCommandDomainPresentationService(AbstractExperienceCommandHandler experienceCommandHandler) {
        this.experienceCommandHandler = experienceCommandHandler;
    }

    @Override
    public void create(CreateRequest<ExperienceCommandModel> request) {
        try {
            this.experienceCommandHandler.create(request);
        } catch (Exception e) {
            throw new JRuntimeException(e.getMessage(), e);
        }
    }

    @Override
    public void update(UpdateRequest<ExperienceCommandModel> request) {
        try {
            this.experienceCommandHandler.update(request);
        } catch (Exception e) {
            throw new JRuntimeException(e.getMessage(), e);
        }
    }

    @Override
    public void delete(UUID uuid) {
        try {
            this.experienceCommandHandler.delete(uuid);
        } catch (Exception e) {
            throw new JRuntimeException(e.getMessage(), e);
        }
    }

    @Override
    public void deleteAll() {
        try {
            this.experienceCommandHandler.deleteAll();
        } catch (Exception e) {
            throw new JRuntimeException(e.getMessage(), e);
        }
    }

    @Override
    public void reorder(ReorderCommandModel request) {
        try {
            this.experienceCommandHandler.reorder(request);
        } catch (Exception e) {
            throw new JRuntimeException(e.getMessage(), e);
        }
    }
}
