package az.rock.flyjob.js.domain.presentation.ports.output.repository.query;

import az.rock.flyjob.js.domain.core.root.detail.CourseRoot;
import az.rock.flyjob.js.domain.core.root.detail.ExperienceRoot;
import az.rock.flyjob.js.domain.presentation.dto.criteria.CourseCriteria;
import az.rock.flyjob.js.domain.presentation.dto.criteria.ExperienceCriteria;
import az.rock.lib.annotation.DomainOutputPort;
import az.rock.lib.valueObject.SimplePageableRequest;

import java.util.List;
import java.util.Optional;

@DomainOutputPort
public interface AbstractExperienceQueryRepositoryAdapter {

    List<ExperienceRoot> fetchAllExperiences(ExperienceCriteria criteria, SimplePageableRequest pageableRequest);

    Optional<ExperienceRoot> fetchExperienceById(ExperienceCriteria criteria);
}
