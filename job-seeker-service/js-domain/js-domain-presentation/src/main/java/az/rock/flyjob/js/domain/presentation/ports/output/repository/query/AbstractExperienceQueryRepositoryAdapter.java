package az.rock.flyjob.js.domain.presentation.ports.output.repository.query;

import az.rock.flyjob.js.domain.core.root.detail.CourseRoot;
import az.rock.flyjob.js.domain.core.root.detail.EducationRoot;
import az.rock.flyjob.js.domain.core.root.detail.ExperienceRoot;
import az.rock.flyjob.js.domain.presentation.dto.criteria.CourseCriteria;
import az.rock.flyjob.js.domain.presentation.dto.criteria.ExperienceCriteria;
import az.rock.lib.adapter.repository.AbstractCommandRepositoryAdapter;
import az.rock.lib.adapter.repository.AbstractQueryRepositoryAdapter;
import az.rock.lib.annotation.DomainOutputPort;
import az.rock.lib.domain.id.js.ExperienceID;
import az.rock.lib.domain.id.js.ResumeID;
import az.rock.lib.valueObject.SimplePageableRequest;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@DomainOutputPort
public interface AbstractExperienceQueryRepositoryAdapter extends AbstractQueryRepositoryAdapter<ExperienceRoot, ExperienceID, ResumeID> {

    List<ExperienceRoot> fetchAllExperiences(ExperienceCriteria criteria, SimplePageableRequest pageableRequest);

    Optional<ExperienceRoot> fetchExperienceById(ExperienceCriteria criteria);
    Optional<ExperienceRoot> findByResumeAndUuidAndRowStatusTrue(ResumeID resumeID, UUID experienceId);

}
