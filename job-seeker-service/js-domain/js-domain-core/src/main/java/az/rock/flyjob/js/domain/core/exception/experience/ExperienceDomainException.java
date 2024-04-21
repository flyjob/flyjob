package az.rock.flyjob.js.domain.core.exception.experience;

import az.rock.flyjob.js.domain.core.exception.ResumeDomainException;

public class ExperienceDomainException extends ResumeDomainException {
    public ExperienceDomainException() {
        super("F0000000010");
    }

    public ExperienceDomainException(String message) {
        super(message);
    }
}
