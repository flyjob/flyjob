package az.rock.flyjob.js.dataaccess.adapter.query;

import az.rock.flyjob.js.dataaccess.mapper.abstracts.AbstractEducationDataAccessMapper;
import az.rock.flyjob.js.dataaccess.model.batis.model.EducationComposeExample;
import az.rock.flyjob.js.dataaccess.repository.abstracts.query.batis.EducationBatisRepository;
import az.rock.flyjob.js.dataaccess.repository.abstracts.query.jpa.EducationQueryJpaRepository;
import az.rock.flyjob.js.domain.core.root.detail.EducationRoot;
import az.rock.flyjob.js.domain.presentation.dto.criteria.EducationCriteria;
import az.rock.flyjob.js.domain.presentation.ports.output.repository.query.AbstractEducationQueryRepositoryAdapter;
import az.rock.lib.domain.id.js.EducationID;
import az.rock.lib.domain.id.js.ResumeID;
import az.rock.lib.valueObject.SimplePageableRequest;
import com.intellibucket.lib.fj.dataaccess.BatisPageable;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Component
public class EducationQueryRepositoryAdapter implements AbstractEducationQueryRepositoryAdapter {

    private final static String orderByOrderNumber = "order_number";
    private final EducationQueryJpaRepository educationQueryJpaRepository;
    private final AbstractEducationDataAccessMapper educationDataAccessMapper;
    private final EducationBatisRepository educationBatisRepository;

    public EducationQueryRepositoryAdapter(EducationQueryJpaRepository educationQueryJpaRepository, AbstractEducationDataAccessMapper educationDataAccessMapper, EducationBatisRepository educationBatisRepository) {
        this.educationQueryJpaRepository = educationQueryJpaRepository;
        this.educationDataAccessMapper = educationDataAccessMapper;
        this.educationBatisRepository = educationBatisRepository;
    }

    @Override
    public Optional<EducationRoot> findByResumeAndUuidAndRowStatusTrue(ResumeID resumeID, UUID educationId) {
        var entity = educationQueryJpaRepository.findByIdAndResumeIdAndRowStatusActive(resumeID.getRootID(), educationId);
        if (entity.isEmpty()) return Optional.empty();
        return educationDataAccessMapper.toRoot(entity.get());
    }

    @Override
    public List<EducationRoot> fetchAllEducations(EducationCriteria educationCriteria, SimplePageableRequest simplePageableRequest) {
        var educationComposeExample = EducationComposeExample.of(educationCriteria, orderByOrderNumber, BatisPageable.of(simplePageableRequest.getSize(), simplePageableRequest.getPage()).changeLimit(simplePageableRequest.getSize() + 1));
        var composes = educationBatisRepository.selectByExample(educationComposeExample);
        return composes
                .stream()
                .map(educationDataAccessMapper::composeToRoot)
                .filter(Optional::isPresent)
                .map(Optional::get)
                .toList();
    }

    @Override
    public Optional<EducationRoot> fetchEducation(EducationCriteria educationCriteria) {
        var educationComposeExample = EducationComposeExample.of(educationCriteria);
        var educationCompose = educationBatisRepository.selectFirstByExample(educationComposeExample);
        return educationDataAccessMapper.composeToRoot(educationCompose);
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
