package az.rock.flyjob.js.domain.presentation.handler.concretes;

import az.rock.flyjob.js.domain.presentation.handler.abstracts.AbstractResumeCreateCommandHandler;
import az.rock.flyjob.js.domain.presentation.mapper.abstracts.AbstractResumeDomainMapper;
import az.rock.flyjob.js.domain.presentation.ports.output.repository.command.AbstractResumeCommandRepositoryAdapter;
import az.rock.lib.jexception.JRuntimeException;
import com.intellibucket.lib.payload.event.abstracts.AbstractSuccessDomainEvent;
import com.intellibucket.lib.payload.event.command.create.ResumeCreatedEvent;
import com.intellibucket.lib.payload.payload.command.ResumeCreatedPayload;
import com.intellibucket.lib.payload.payload.reg.JobSeekerRegistrationPayload;
import org.springframework.stereotype.Component;

@Component
public class ResumeCreateCommandHandler implements AbstractResumeCreateCommandHandler {
    private final AbstractResumeDomainMapper resumeDomainMapper;
    private final AbstractResumeCommandRepositoryAdapter resumeCommandRepositoryAdapter;


    public ResumeCreateCommandHandler(AbstractResumeDomainMapper resumeDomainMapper,
                                      AbstractResumeCommandRepositoryAdapter resumeCommandRepositoryAdapter) {
        this.resumeDomainMapper = resumeDomainMapper;
        this.resumeCommandRepositoryAdapter = resumeCommandRepositoryAdapter;
    }

    @Override
    @SuppressWarnings("all")
    public AbstractSuccessDomainEvent<ResumeCreatedPayload> createResume(JobSeekerRegistrationPayload payload) {
        var newResumeRoot = this.resumeDomainMapper.createNewResume(payload);
        var optionalResumeRoot = this.resumeCommandRepositoryAdapter.create(newResumeRoot);
        if (optionalResumeRoot.isPresent()) {
            return ResumeCreatedEvent.of(
                    ResumeCreatedPayload.of(
                            optionalResumeRoot
                                    .get()
                                    .getRootID()
                                    .getAbsoluteID()
                    )
            );
        } else throw new JRuntimeException("Resume cannot created");
    }
}
