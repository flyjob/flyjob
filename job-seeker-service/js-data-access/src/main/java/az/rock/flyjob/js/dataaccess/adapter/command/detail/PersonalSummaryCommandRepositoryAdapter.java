package az.rock.flyjob.js.dataaccess.adapter.command.detail;

import az.rock.flyjob.js.dataaccess.mapper.abstracts.AbstractPersonalSummaryDataAccessMapper;
import az.rock.flyjob.js.dataaccess.model.entity.resume.details.PersonalSummaryEntity;
import az.rock.flyjob.js.dataaccess.repository.abstracts.command.custom.detail.AbstractPersonalSummaryCustomCommandJPARepository;
import az.rock.flyjob.js.domain.core.root.detail.PersonalSummaryRoot;
import az.rock.flyjob.js.domain.presentation.ports.output.repository.command.AbstractPersonalSummaryCommandRepositoryAdapter;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class PersonalSummaryCommandRepositoryAdapter implements AbstractPersonalSummaryCommandRepositoryAdapter {
    private final AbstractPersonalSummaryCustomCommandJPARepository interestCustomCommandJPARepository;
    private final AbstractPersonalSummaryDataAccessMapper interestDataAccessMapper;

    public PersonalSummaryCommandRepositoryAdapter(@Qualifier(value = "personalSummaryCustomCommandJPARepository") AbstractPersonalSummaryCustomCommandJPARepository interestCustomCommandJPARepository,
                                                   @Qualifier(value = "personalSummaryDataAccessMapper") AbstractPersonalSummaryDataAccessMapper interestDataAccessMapper) {
        this.interestCustomCommandJPARepository = interestCustomCommandJPARepository;
        this.interestDataAccessMapper = interestDataAccessMapper;
    }

    @Override
    public void changeSummary(PersonalSummaryRoot root) {
       var entity = this.interestDataAccessMapper.toEntity(root);
       entity.ifPresent(this.interestCustomCommandJPARepository::merge);

    }

    @Override
    public void createSummary(PersonalSummaryRoot root) {
        final Optional<PersonalSummaryEntity> entity = this.interestDataAccessMapper.toEntity(root);
        entity.ifPresent(this.interestCustomCommandJPARepository::persist);
    }

    @Override
    public void deleteSummary(PersonalSummaryRoot root) {
        final Optional<PersonalSummaryEntity> entity = this.interestDataAccessMapper.toEntity(root);
        entity.ifPresent(this.interestCustomCommandJPARepository::delete);


    }


}
