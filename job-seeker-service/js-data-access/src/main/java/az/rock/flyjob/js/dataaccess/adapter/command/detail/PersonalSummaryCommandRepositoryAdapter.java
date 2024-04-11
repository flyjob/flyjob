package az.rock.flyjob.js.dataaccess.adapter.command.detail;

import az.rock.flyjob.js.dataaccess.mapper.abstracts.AbstractPersonalSummaryDataAccessMapper;
import az.rock.flyjob.js.dataaccess.repository.abstracts.command.custom.detail.AbstractPersonalSummaryCustomCommandJPARepository;
import az.rock.flyjob.js.domain.core.root.detail.InterestRoot;
import az.rock.flyjob.js.domain.core.root.detail.PersonalSummaryRoot;
import az.rock.flyjob.js.domain.presentation.ports.output.repository.command.AbstractPersonalSummaryCommandRepositoryAdapter;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class PersonalSummaryCommandRepositoryAdapter implements AbstractPersonalSummaryCommandRepositoryAdapter {
    private final AbstractPersonalSummaryCustomCommandJPARepository interestCustomCommandJPARepository;
    private final AbstractPersonalSummaryDataAccessMapper interestDataAccessMapper;

    public PersonalSummaryCommandRepositoryAdapter(AbstractPersonalSummaryCustomCommandJPARepository interestCustomCommandJPARepository,
                                                   AbstractPersonalSummaryDataAccessMapper interestDataAccessMapper) {
        this.interestCustomCommandJPARepository = interestCustomCommandJPARepository;
        this.interestDataAccessMapper = interestDataAccessMapper;
    }

    @Override
    public Optional<InterestRoot> changeSummary(PersonalSummaryRoot root) {
        return Optional.empty();
    }


}
