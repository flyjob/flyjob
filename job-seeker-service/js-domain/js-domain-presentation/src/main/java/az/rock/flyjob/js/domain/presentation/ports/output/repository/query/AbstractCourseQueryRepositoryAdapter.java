package az.rock.flyjob.js.domain.presentation.ports.output.repository.query;


import az.rock.flyjob.js.domain.core.root.detail.CourseRoot;
import az.rock.flyjob.js.domain.presentation.dto.criteria.CourseCriteria;
import az.rock.flyjob.js.domain.presentation.dto.response.resume.course.MyCourseResponseModel;
import az.rock.flyjob.js.domain.presentation.dto.response.resume.course.simple.SimpleAnyCourseResponseModel;
import az.rock.lib.annotation.DomainOutputPort;
import az.rock.lib.domain.id.js.CourseID;
import az.rock.lib.domain.id.js.ResumeID;
import az.rock.lib.valueObject.AccessModifier;
import az.rock.lib.valueObject.SimplePageableRequest;
import az.rock.lib.valueObject.SimplePageableResponse;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@DomainOutputPort
public interface AbstractCourseQueryRepositoryAdapter{

    Boolean existsByEquality(CourseRoot root);

    Optional<CourseRoot> findById(CourseID courseID,ResumeID resumeID,List<AccessModifier> accessModifiers);

    List<CourseRoot> findAllByResume(ResumeID resumeID,List<AccessModifier> accessModifiers);

    Boolean isInLimit(Long limit,ResumeID resumeId);

    List<CourseRoot> fetchAllCourses(CourseCriteria criteria,SimplePageableRequest pageableRequest);

    Optional<CourseRoot> fetchCourseById(CourseCriteria criteria);


}
