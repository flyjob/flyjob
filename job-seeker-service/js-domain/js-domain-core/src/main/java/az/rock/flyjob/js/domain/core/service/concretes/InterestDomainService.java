package az.rock.flyjob.js.domain.core.service.concretes;

import az.rock.flyjob.js.domain.core.exception.interest.InterestAlreadyExistException;
import az.rock.flyjob.js.domain.core.root.detail.InterestRoot;
import az.rock.flyjob.js.domain.core.service.abstracts.AbstractInterestDomainService;

import java.util.List;

public class InterestDomainService implements AbstractInterestDomainService {


    @Override
    public InterestRoot validateNewInterest(List<InterestRoot> savedInterests, InterestRoot changedInterest) throws InterestAlreadyExistException {
        if (savedInterests.contains(changedInterest))
            throw new InterestAlreadyExistException();
        return changedInterest;
    }
}
