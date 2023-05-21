package az.rock.auth.domain.presentation.ports.input.handler.abstracts;

import az.rock.auth.domain.presentation.dto.request.CreateUserCommand;
import az.rock.flyjob.auth.event.UserCreatedEvent;

public interface AbstractUserCreateCommandHandler {
    UserCreatedEvent handle(CreateUserCommand createUserCommand);
}
