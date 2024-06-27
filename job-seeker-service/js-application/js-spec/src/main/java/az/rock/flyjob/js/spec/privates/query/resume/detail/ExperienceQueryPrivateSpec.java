package az.rock.flyjob.js.spec.privates.query.resume.detail;

import az.rock.flyjob.js.domain.presentation.dto.response.resume.course.AnyCourseResponseModel;
import az.rock.flyjob.js.domain.presentation.dto.response.resume.course.MyCourseResponseModel;
import az.rock.flyjob.js.domain.presentation.dto.response.resume.course.simple.SimpleAnyCourseResponseModel;
import az.rock.flyjob.js.domain.presentation.dto.response.resume.course.simple.SimpleMyCourseResponseModel;
import az.rock.flyjob.js.domain.presentation.dto.response.resume.experience.AnyExperienceResponseModel;
import az.rock.flyjob.js.domain.presentation.dto.response.resume.experience.MyExperienceResponseModel;
import az.rock.flyjob.js.domain.presentation.dto.response.resume.experience.simple.SimpleAnyExperienceResponseModel;
import az.rock.flyjob.js.domain.presentation.dto.response.resume.experience.simple.SimpleMyExperienceResponseModel;
import az.rock.lib.jresponse.response.success.JSuccessDataResponse;
import az.rock.lib.valueObject.SimplePageableRequest;
import az.rock.lib.valueObject.SimplePageableResponse;
import org.springframework.http.ResponseEntity;

import java.util.UUID;

public interface ExperienceQueryPrivateSpec {
    ResponseEntity<JSuccessDataResponse<SimplePageableResponse<MyExperienceResponseModel>>> queryAllMyExperiences(SimplePageableRequest pageableRequest);

    ResponseEntity<JSuccessDataResponse<SimplePageableResponse<AnyExperienceResponseModel>>> queryAllAnyExperiences(UUID targetResumeId, SimplePageableRequest pageableRequest);

    ResponseEntity<JSuccessDataResponse<MyExperienceResponseModel>> findMyExperienceById(UUID id);

    ResponseEntity<JSuccessDataResponse<SimplePageableResponse<SimpleMyExperienceResponseModel>>> queryAllMySimpleExperiences(SimplePageableRequest pageableRequest);

    ResponseEntity<JSuccessDataResponse<SimplePageableResponse<SimpleAnyExperienceResponseModel>>> queryAllAnySimpleExperiences(UUID targetResumeId, SimplePageableRequest pageableRequest);

    ResponseEntity<JSuccessDataResponse<AnyExperienceResponseModel>> findAnyExperienceById(UUID id);
}
