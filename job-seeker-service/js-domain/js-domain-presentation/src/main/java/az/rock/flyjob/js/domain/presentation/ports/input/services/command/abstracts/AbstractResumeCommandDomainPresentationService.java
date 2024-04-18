package az.rock.flyjob.js.domain.presentation.ports.input.services.command.abstracts;

import az.rock.lib.annotation.InputPort;
import com.intellibucket.lib.payload.event.abstracts.AbstractSuccessDomainEvent;
import com.intellibucket.lib.payload.payload.command.ResumeCreatedPayload;
import com.intellibucket.lib.payload.payload.reg.JobSeekerRegistrationPayload;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@InputPort
public interface AbstractResumeCommandDomainPresentationService {
    AbstractSuccessDomainEvent<ResumeCreatedPayload> create(JobSeekerRegistrationPayload payload);
}
