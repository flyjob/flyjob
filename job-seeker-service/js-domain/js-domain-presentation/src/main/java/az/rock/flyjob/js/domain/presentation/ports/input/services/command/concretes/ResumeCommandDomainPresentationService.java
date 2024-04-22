package az.rock.flyjob.js.domain.presentation.ports.input.services.command.concretes;

import az.rock.flyjob.js.domain.presentation.handler.abstracts.AbstractResumeCreateCommandHandler;
import az.rock.flyjob.js.domain.presentation.ports.input.services.command.abstracts.AbstractResumeCommandDomainPresentationService;
import com.intellibucket.lib.payload.event.abstracts.AbstractSuccessDomainEvent;
import com.intellibucket.lib.payload.payload.command.ResumeCreatedPayload;
import com.intellibucket.lib.payload.payload.reg.JobSeekerRegistrationPayload;
import org.springframework.stereotype.Component;

@Component
public class ResumeCommandDomainPresentationService implements AbstractResumeCommandDomainPresentationService {

    private final AbstractResumeCreateCommandHandler resumeCreateCommandHandler;

    public ResumeCommandDomainPresentationService(AbstractResumeCreateCommandHandler resumeCreateCommandHandler) {
        this.resumeCreateCommandHandler = resumeCreateCommandHandler;
    }

    @Override
    public AbstractSuccessDomainEvent<ResumeCreatedPayload> create(JobSeekerRegistrationPayload payload) {
        return this.resumeCreateCommandHandler.createResume(payload);
    }
}
