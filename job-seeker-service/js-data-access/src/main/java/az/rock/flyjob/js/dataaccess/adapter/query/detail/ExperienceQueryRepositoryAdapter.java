package az.rock.flyjob.js.dataaccess.adapter.query.detail;

import az.rock.flyjob.js.dataaccess.mapper.concretes.ExperienceDataAccessMapper;
import az.rock.flyjob.js.dataaccess.mapper.concretes.PageableDataAccessMapper;
import az.rock.flyjob.js.dataaccess.model.batis.model.ExperienceComposeExample;
import az.rock.flyjob.js.dataaccess.model.entity.resume.details.ExperienceEntity;
import az.rock.flyjob.js.dataaccess.repository.abstracts.query.batis.ExperienceBatisRepository;
import az.rock.flyjob.js.domain.core.root.detail.ExperienceRoot;
import az.rock.flyjob.js.domain.presentation.dto.criteria.ExperienceCriteria;
import az.rock.flyjob.js.domain.presentation.ports.output.repository.query.AbstractExperienceQueryRepositoryAdapter;
import az.rock.lib.domain.id.js.ExperienceID;
import az.rock.lib.domain.id.js.ResumeID;
import az.rock.lib.valueObject.SimplePageableRequest;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Component
public class ExperienceQueryRepositoryAdapter implements AbstractExperienceQueryRepositoryAdapter {

    private final ExperienceBatisRepository experienceBatisRepository;

    private final PageableDataAccessMapper pageableDataAccessMapper;

    private final ExperienceDataAccessMapper experienceDataAccessMapper;
    private final AbstractExperienceQueryRepositoryAdapter experienceQueryRepositoryAdapter;


    public ExperienceQueryRepositoryAdapter(ExperienceBatisRepository experienceBatisRepository, PageableDataAccessMapper pageableDataAccessMapper, ExperienceDataAccessMapper experienceDataAccessMapper, AbstractExperienceQueryRepositoryAdapter experienceQueryRepositoryAdapter) {
        this.experienceBatisRepository = experienceBatisRepository;
        this.pageableDataAccessMapper = pageableDataAccessMapper;
        this.experienceDataAccessMapper = experienceDataAccessMapper;
        this.experienceQueryRepositoryAdapter = experienceQueryRepositoryAdapter;
    }

    @Override
    public List<ExperienceRoot> fetchAllExperiences(ExperienceCriteria criteria, SimplePageableRequest pageableRequest) {
        var pageable = pageableDataAccessMapper.toBatisPageable(pageableRequest).changeLimit(pageableRequest.getSize()+1);
        var experienceComposeExample = ExperienceComposeExample.of(criteria,"order_number",pageable);
        return experienceBatisRepository.selectByExample(experienceComposeExample)
                .stream()
                .map(experienceDataAccessMapper::toRoot)
                .filter(Optional::isPresent)
                .map(Optional::get)
                .toList();
    }

    @Override
    public Optional<ExperienceRoot> fetchExperienceById(ExperienceCriteria criteria) {
        var experienceComposeExample = ExperienceComposeExample.of(criteria);
        return Optional.ofNullable(experienceBatisRepository.selectFirstByExample(experienceComposeExample))
                .map(experienceDataAccessMapper::toRoot)
                .filter(Optional::isPresent)
                .map(Optional::get);
    }

    @Override
    public Optional<ExperienceRoot> findByResumeAndUuidAndRowStatusTrue(ResumeID resumeID, UUID experienceId) {
        var entity = this.experienceQueryRepositoryAdapter.findByResumeAndUuidAndRowStatusTrue(resumeID, experienceId);
        if (entity.isEmpty()) return Optional.empty();
        return this.experienceDataAccessMapper.toRoot(entity);
    }

    @Override
    public Optional<ExperienceRoot> findOwnByID(ResumeID parentID, ExperienceID rootId) {
        return AbstractExperienceQueryRepositoryAdapter.super.findOwnByID(parentID, rootId);
    }

    @Override
    public Optional<ExperienceRoot> findById(ExperienceID rootId) {
        return Optional.empty();
    }

    @Override
    public Optional<ExperienceRoot> findByPID(ResumeID parentID) {
        return AbstractExperienceQueryRepositoryAdapter.super.findByPID(parentID);
    }

    @Override
    public List<ExperienceRoot> findAllByPID(ResumeID parentID) {
        return AbstractExperienceQueryRepositoryAdapter.super.findAllByPID(parentID);
    }
}
