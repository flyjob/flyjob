package az.rock.flyjob.js.domain.core.service.abstracts;

import az.rock.flyjob.js.domain.core.exception.interest.InterestAlreadyExistException;
import az.rock.flyjob.js.domain.core.root.detail.InterestRoot;

import java.util.List;

public interface AbstractInterestDomainService {
    InterestRoot validateNewInterest(List<InterestRoot> savedPhoneNumbers, InterestRoot changedInterest) throws InterestAlreadyExistException;



}
