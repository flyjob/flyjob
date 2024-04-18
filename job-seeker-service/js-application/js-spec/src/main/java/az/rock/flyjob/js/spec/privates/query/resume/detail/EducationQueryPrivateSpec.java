package az.rock.flyjob.js.spec.privates.query.resume.detail;

import az.rock.flyjob.js.domain.presentation.dto.response.resume.education.AnyEducationResponseModel;
import az.rock.flyjob.js.domain.presentation.dto.response.resume.education.MyEducationResponseModel;
import az.rock.flyjob.js.domain.presentation.dto.response.resume.education.simple.SimpleAnyEducationResponseModel;
import az.rock.flyjob.js.domain.presentation.dto.response.resume.education.simple.SimpleMyEducationResponseModel;
import az.rock.lib.jresponse.response.success.JSuccessDataResponse;
import az.rock.lib.valueObject.SimplePageableRequest;
import az.rock.lib.valueObject.SimplePageableResponse;
import org.springframework.http.ResponseEntity;

import java.util.UUID;

public interface EducationQueryPrivateSpec {
    ResponseEntity<JSuccessDataResponse<SimplePageableResponse<MyEducationResponseModel>>> queryAllMyEducations(SimplePageableRequest pageableRequest);

    ResponseEntity<JSuccessDataResponse<SimplePageableResponse<AnyEducationResponseModel>>> queryAllAnyEducations(UUID targetResumeId, SimplePageableRequest pageableRequest);

    ResponseEntity<JSuccessDataResponse<SimplePageableResponse<SimpleMyEducationResponseModel>>> queryAllMySimpleEducations(SimplePageableRequest pageableRequest);

    ResponseEntity<JSuccessDataResponse<SimplePageableResponse<SimpleAnyEducationResponseModel>>> queryAllAnySimpleEducations(UUID targetResumeId, SimplePageableRequest pageableRequest);

    ResponseEntity<JSuccessDataResponse<MyEducationResponseModel>> findMyEducationById(UUID id);

    ResponseEntity<JSuccessDataResponse<AnyEducationResponseModel>> findAnyEducationById(UUID id);
}
