package az.rock.flyjob.js.domain.core.exception.education;

import az.rock.flyjob.js.domain.core.exception.ResumeDomainException;


public class EducationDomainException extends ResumeDomainException {
    public EducationDomainException() {
        super("F0000000001");
    }

    public EducationDomainException(String message) {
        super(message);
    }
}
