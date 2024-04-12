package az.rock.flyjob.js.dataaccess.adapter.query.detail;

import az.rock.flyjob.js.dataaccess.mapper.abstracts.AbstractPersonalSummaryDataAccessMapper;

import az.rock.flyjob.js.dataaccess.model.entity.resume.details.PersonalSummaryEntity;
import az.rock.flyjob.js.dataaccess.repository.abstracts.query.jpa.AbstractPersonalSummaryQueryJPARepository;
import az.rock.flyjob.js.domain.core.root.detail.InterestRoot;
import az.rock.flyjob.js.domain.core.root.detail.PersonalSummaryRoot;
import az.rock.flyjob.js.domain.presentation.ports.output.repository.query.AbstractPersonalSummaryQueryRepositoryAdapter;
import az.rock.lib.domain.id.js.PersonalSummaryID;
import az.rock.lib.domain.id.js.ResumeID;
import az.rock.lib.valueObject.AccessModifier;
import org.springframework.stereotype.Component;

import java.util.List;

import java.util.Optional;

@Component
public class PersonalSummaryQueryRepositoryAdapter implements AbstractPersonalSummaryQueryRepositoryAdapter {
    private final AbstractPersonalSummaryQueryJPARepository abstractPersonalSummaryQueryJPARepository;

    private final AbstractPersonalSummaryDataAccessMapper personalSummaryDataAccessMapper;

    public PersonalSummaryQueryRepositoryAdapter(AbstractPersonalSummaryQueryJPARepository abstractPersonalSummaryQueryJPARepository, AbstractPersonalSummaryDataAccessMapper personalSummaryDataAccessMapper) {
        this.abstractPersonalSummaryQueryJPARepository = abstractPersonalSummaryQueryJPARepository;
        this.personalSummaryDataAccessMapper = personalSummaryDataAccessMapper;
    }


    @Override
    public Optional<PersonalSummaryRoot> findById(PersonalSummaryID rootId) {
        var summaryEntity = abstractPersonalSummaryQueryJPARepository.findById(rootId.getAbsoluteID());
        if (summaryEntity.isPresent()) return this.personalSummaryDataAccessMapper.toRoot(summaryEntity.get());
        return Optional.empty();
    }

    @Override
    public Optional<PersonalSummaryRoot> findOwnByID(ResumeID parentID, PersonalSummaryID rootId, List<AccessModifier> accessModifiers) {
        this.
        return Optional.empty();
    }

    @Override
    public Optional<PersonalSummaryRoot> findByPID(ResumeID parentID, PersonalSummaryID rootId,List<AccessModifier> modifierList) {
        var summaryEntity = abstractPersonalSummaryQueryJPARepository.findSummaryByResumeID(parentID.getAbsoluteID(), rootId.getAbsoluteID(),modifierList);
        if (summaryEntity.isPresent()) return this.personalSummaryDataAccessMapper.toRoot(summaryEntity.get());
        return Optional.empty();

    }


}
