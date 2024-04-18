package az.rock.flyjob.js.dataaccess.adapter.command;

import az.rock.flyjob.js.dataaccess.mapper.abstracts.AbstractResumeDataAccessMapper;
import az.rock.flyjob.js.dataaccess.repository.abstracts.command.AbstractResumeCommandJPARepository;
import az.rock.flyjob.js.domain.core.root.ResumeRoot;
import az.rock.flyjob.js.domain.presentation.ports.output.repository.command.AbstractResumeCommandRepositoryAdapter;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class ResumeCommandRepositoryAdapter implements AbstractResumeCommandRepositoryAdapter {
    private final AbstractResumeDataAccessMapper resumeDataAccessMapper;
    private final AbstractResumeCommandJPARepository resumeCustomCommandJPARepository;

    public ResumeCommandRepositoryAdapter(AbstractResumeDataAccessMapper resumeDataAccessMapper,
                                          AbstractResumeCommandJPARepository resumeCustomCommandJPARepository) {
        this.resumeDataAccessMapper = resumeDataAccessMapper;
        this.resumeCustomCommandJPARepository = resumeCustomCommandJPARepository;
    }

    @Override
    public Optional<ResumeRoot> create(ResumeRoot root) {
        var optionalEntity = this.resumeDataAccessMapper.toEntity(root);
        if (optionalEntity.isPresent()) {
            var savedEntity = this.resumeCustomCommandJPARepository.save(optionalEntity.get());
            return this.resumeDataAccessMapper.toRoot(savedEntity);
        } else return Optional.empty();
    }

}
