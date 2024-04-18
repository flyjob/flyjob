package az.rock.flyjob.js.domain.presentation.ports.input.services.command.abstracts;

import java.util.UUID;

public interface AbstractTestCommandDomainPresentationService {
    String testAuthorizationApiForRelation(UUID sourceUserId, UUID targetUserId);
}
