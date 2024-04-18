package az.rock.flyjob.js.domain.core.exception.course;


import az.rock.flyjob.js.domain.core.exception.ResumeDomainException;


public class CourseDomainException extends ResumeDomainException {
    public CourseDomainException() {
        super("F0000000001");
    }

    public CourseDomainException(String message) {
        super(message);
    }
}
