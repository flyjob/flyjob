package az.rock.auth.domain.presentation.coordinator.concretes;

import az.rock.auth.domain.presentation.coordinator.abstracts.AbstractJobSeekerCreateEventCoordinator;
import az.rock.auth.domain.presentation.ports.output.publisher.AbstractUserMessagePublisher;
import az.rock.lib.event.impl.abstracts.AbstractFailDomainEvent;
import az.rock.lib.event.impl.abstracts.AbstractSuccessDomainEvent;
import az.rock.lib.event.impl.concretes.auth.create.JobSeekerCreatedEvent;
import az.rock.lib.event.payload.Payload;
import az.rock.lib.event.trx.Saga;
import org.springframework.stereotype.Component;

@Component
public class JobSeekerCreateEventCoordinator extends AbstractJobSeekerCreateEventCoordinator {
    private final AbstractUserMessagePublisher<JobSeekerCreatedEvent> userMessagePublisher;

    public JobSeekerCreateEventCoordinator(AbstractUserMessagePublisher<JobSeekerCreatedEvent> userMessagePublisher) {
        this.userMessagePublisher = userMessagePublisher;
    }

    @Override
    protected void proceed(Saga<JobSeekerCreatedEvent> saga) {
        this.userMessagePublisher.publish(saga);
    }

    @Override
    protected void onError(Exception exception, Saga<JobSeekerCreatedEvent> saga) {
        System.err.println(exception.getMessage());
    }

    @Override
    public <F extends AbstractFailDomainEvent<? extends Payload>> void onFail(Saga<F> saga) {

    }

    @Override
    public <S extends AbstractSuccessDomainEvent<? extends Payload>> void onSuccess(Saga<S> saga) {

    }


}
