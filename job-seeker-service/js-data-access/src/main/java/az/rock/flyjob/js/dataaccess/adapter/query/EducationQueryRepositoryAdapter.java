package az.rock.flyjob.js.dataaccess.adapter.query;

import az.rock.flyjob.js.dataaccess.mapper.abstracts.AbstractEducationDataAccessMapper;
import az.rock.flyjob.js.dataaccess.repository.abstracts.query.batis.AbstractEducationQueryBatisRepository;
import az.rock.flyjob.js.dataaccess.repository.abstracts.query.jpa.EducationQueryJpaRepository;
import az.rock.flyjob.js.domain.core.root.detail.EducationRoot;
import az.rock.flyjob.js.domain.presentation.ports.output.repository.query.AbstractEducationQueryRepositoryAdapter;
import az.rock.lib.domain.id.js.EducationID;
import az.rock.lib.domain.id.js.ResumeID;
import az.rock.lib.valueObject.SimplePageableRequest;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Component
public class EducationQueryRepositoryAdapter implements AbstractEducationQueryRepositoryAdapter {

    private final EducationQueryJpaRepository educationQueryJpaRepository;
    private final AbstractEducationDataAccessMapper educationDataAccessMapper;
    private final AbstractEducationQueryBatisRepository educationQueryBatisRepository;


    public EducationQueryRepositoryAdapter(EducationQueryJpaRepository educationQueryJpaRepository, AbstractEducationDataAccessMapper educationDataAccessMapper, AbstractEducationQueryBatisRepository educationQueryBatisRepository) {
        this.educationQueryJpaRepository = educationQueryJpaRepository;
        this.educationDataAccessMapper = educationDataAccessMapper;
        this.educationQueryBatisRepository = educationQueryBatisRepository;
    }

    @Override
    public Optional<EducationRoot> findByResumeAndUuidAndRowStatusTrue(ResumeID resumeID, UUID educationId) {
        var entity = educationQueryJpaRepository.findByIdAndResumeIdAndRowStatusActive(resumeID.getRootID(), educationId);
        if (entity.isEmpty()) return Optional.empty();
        return educationDataAccessMapper.toRoot(entity.get());
    }

    @Override
    public List<EducationRoot> findAllMyEducations(ResumeID resumeID, SimplePageableRequest simplePageableRequest) {
        var entity = educationQueryBatisRepository.findAllMyEducations(resumeID.getRootID(),simplePageableRequest);
        return null;
    }

    @Override
    public List<EducationRoot> findAllMySimpleEducations(ResumeID resumeID, SimplePageableRequest simplePageableRequest) {
        var entity = educationQueryBatisRepository.findAllMySimpleEducations(resumeID.getRootID(),simplePageableRequest);
        return null;
    }

    @Override
    public List<EducationRoot> findAllAnyEducations(UUID resumeID, SimplePageableRequest simplePageableRequest) {
        var entity = educationQueryBatisRepository.findAllAnyEducations(resumeID,simplePageableRequest);
        return null;
    }

    @Override
    public Optional<EducationRoot> findById(EducationID rootId) {
        var entity = educationQueryJpaRepository.findById(rootId.getAbsoluteID());
        if (entity.isEmpty()) return Optional.empty();
        return this.educationDataAccessMapper.toRoot(entity.get());
    }

    @Override
    public List<EducationRoot> findAllByPID(ResumeID parentID) {
        var educationEntityList = educationQueryJpaRepository.findAll(parentID.getAbsoluteID());
        return educationEntityList
                .stream()
                .map(this.educationDataAccessMapper::toRoot)
                .filter(Optional::isPresent)
                .map(Optional::get)
                .toList();
    }

}
