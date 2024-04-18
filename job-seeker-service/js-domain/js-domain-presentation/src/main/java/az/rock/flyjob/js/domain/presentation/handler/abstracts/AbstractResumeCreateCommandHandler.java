package az.rock.flyjob.js.domain.presentation.handler.abstracts;

import com.intellibucket.lib.payload.event.abstracts.AbstractSuccessDomainEvent;
import com.intellibucket.lib.payload.payload.command.ResumeCreatedPayload;
import com.intellibucket.lib.payload.payload.reg.JobSeekerRegistrationPayload;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Transactional(propagation = Propagation.REQUIRES_NEW)
public interface AbstractResumeCreateCommandHandler {
    AbstractSuccessDomainEvent<ResumeCreatedPayload> createResume(JobSeekerRegistrationPayload payload);
}
