package az.rock.flyjob.js.domain.presentation.ports.input.services.command.abstracts;

import az.rock.flyjob.js.domain.presentation.dto.response.resume.course.AnyCourseResponseModel;
import az.rock.flyjob.js.domain.presentation.dto.response.resume.course.MyCourseResponseModel;
import az.rock.flyjob.js.domain.presentation.dto.response.resume.course.simple.SimpleAnyCourseResponseModel;
import az.rock.flyjob.js.domain.presentation.dto.response.resume.course.simple.SimpleMyCourseResponseModel;
import az.rock.lib.annotation.InputPort;
import az.rock.lib.valueObject.SimplePageableRequest;
import az.rock.lib.valueObject.SimplePageableResponse;
import java.util.UUID;


@InputPort
public interface AbstractCourseQueryDomainPresentationService {

    SimplePageableResponse <SimpleAnyCourseResponseModel> allAnySimpleCourses(UUID targetResumeId, SimplePageableRequest pageableRequest);

    SimplePageableResponse<SimpleMyCourseResponseModel>  allMySimpleCourses(SimplePageableRequest simplePageableRequest);

    AnyCourseResponseModel findAnyCourse(UUID uuid);

    SimplePageableResponse <MyCourseResponseModel> allMyCourses(SimplePageableRequest pageableRequest);

    SimplePageableResponse<AnyCourseResponseModel> allAnyCourses(UUID targetResumeId, SimplePageableRequest pageableRequest);

    MyCourseResponseModel myCourseById(UUID id);

}