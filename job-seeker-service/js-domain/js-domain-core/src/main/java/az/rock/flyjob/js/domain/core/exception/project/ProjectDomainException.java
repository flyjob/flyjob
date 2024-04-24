package az.rock.flyjob.js.domain.core.exception.project;

import az.rock.flyjob.js.domain.core.exception.ResumeDomainException;

public class ProjectDomainException extends ResumeDomainException {
    public ProjectDomainException() {
        super("F0000000001");
    }

    public ProjectDomainException(String message) {
        super(message);
    }
}
