package az.rock.flyjob.js.spec.privates.query.resume.detail;

import az.rock.flyjob.js.domain.presentation.dto.response.resume.course.AnyCourseResponseModel;
import az.rock.flyjob.js.domain.presentation.dto.response.resume.course.MyCourseResponseModel;
import az.rock.flyjob.js.domain.presentation.dto.response.resume.course.simple.SimpleAnyCourseResponseModel;
import az.rock.flyjob.js.domain.presentation.dto.response.resume.course.simple.SimpleMyCourseResponseModel;
import az.rock.lib.jresponse.response.success.JSuccessDataResponse;
import az.rock.lib.valueObject.SimplePageableRequest;
import az.rock.lib.valueObject.SimplePageableResponse;
import org.springframework.http.ResponseEntity;

import java.util.UUID;

public interface CourseQueryPrivateSpec {
    ResponseEntity<JSuccessDataResponse<SimplePageableResponse<MyCourseResponseModel>>> queryAllMyCourses(SimplePageableRequest pageableRequest);

    ResponseEntity<JSuccessDataResponse<SimplePageableResponse<AnyCourseResponseModel>>> queryAllAnyCourses(UUID targetResumeId, SimplePageableRequest pageableRequest);

    ResponseEntity<JSuccessDataResponse<MyCourseResponseModel>> findMyCourseById(UUID id);

    ResponseEntity<JSuccessDataResponse<SimplePageableResponse<SimpleMyCourseResponseModel>>> queryAllMySimpleCourses(SimplePageableRequest pageableRequest);

    ResponseEntity<JSuccessDataResponse<SimplePageableResponse<SimpleAnyCourseResponseModel>>> queryAllAnySimpleCourses(UUID targetResumeId, SimplePageableRequest pageableRequest);

    ResponseEntity<JSuccessDataResponse<AnyCourseResponseModel>> findAnyCourseById(UUID id);
}
