package az.rock.flyjob.js.domain.presentation.handler.concretes;

import az.rock.flyjob.js.domain.presentation.handler.abstracts.AbstractPersonalSummaryCommandHandler;
import az.rock.flyjob.js.domain.presentation.mapper.abstracts.AbstractPersonalSummaryDomainMapper;
import az.rock.flyjob.js.domain.presentation.ports.output.repository.command.AbstractPersonalSummaryCommandRepositoryAdapter;
import az.rock.flyjob.js.domain.presentation.ports.output.repository.query.AbstractPersonalSummaryQueryRepositoryAdapter;
import az.rock.lib.valueObject.AccessModifier;
import az.rock.lib.valueObject.SimpleContext;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PersonalSummaryCommandHandler implements AbstractPersonalSummaryCommandHandler {
    private final AbstractPersonalSummaryQueryRepositoryAdapter interestQueryRepositoryAdapter;
    private final AbstractPersonalSummaryCommandRepositoryAdapter interestCommandRepositoryAdapter;
    private final AbstractPersonalSummaryDomainMapper interestDomainMapper;
    private final List<AccessModifier> modifierList= List.of(AccessModifier.values());


    public PersonalSummaryCommandHandler(AbstractPersonalSummaryQueryRepositoryAdapter interestQueryRepositoryAdapter,
                                         AbstractPersonalSummaryCommandRepositoryAdapter interestCommandRepositoryAdapter,
                                         AbstractPersonalSummaryDomainMapper interestDomainMapper) {
        this.interestQueryRepositoryAdapter = interestQueryRepositoryAdapter;
        this.interestCommandRepositoryAdapter = interestCommandRepositoryAdapter;
        this.interestDomainMapper = interestDomainMapper;
    }

    @Override
    public void changeSummary(SimpleContext context) {

    }
}
