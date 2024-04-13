package az.rock.flyjob.js.dataaccess.adapter.query.detail;

import az.rock.flyjob.js.dataaccess.mapper.concretes.PageableDataAccessMapper;
import az.rock.flyjob.js.dataaccess.model.batis.model.ExperienceComposeExample;
import az.rock.flyjob.js.dataaccess.repository.abstracts.query.batis.ExperienceBatisRepository;
import az.rock.flyjob.js.domain.core.root.detail.ExperienceRoot;
import az.rock.flyjob.js.domain.presentation.dto.criteria.ExperienceCriteria;
import az.rock.flyjob.js.domain.presentation.ports.output.repository.query.AbstractExperienceQueryRepositoryAdapter;
import az.rock.lib.valueObject.SimplePageableRequest;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class ExperienceQueryRepositoryAdapter implements AbstractExperienceQueryRepositoryAdapter {

    private final ExperienceBatisRepository experienceBatisRepository;

    private final PageableDataAccessMapper pageableDataAccessMapper;

    public ExperienceQueryRepositoryAdapter(ExperienceBatisRepository experienceBatisRepository, PageableDataAccessMapper pageableDataAccessMapper) {
        this.experienceBatisRepository = experienceBatisRepository;
        this.pageableDataAccessMapper = pageableDataAccessMapper;
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
}
