package az.rock.flyjob.js.presentation.api.rest.privates.query.resume.detail;

import az.rock.flyjob.js.domain.presentation.dto.response.resume.education.AnyEducationResponseModel;
import az.rock.flyjob.js.domain.presentation.dto.response.resume.education.MyEducationResponseModel;
import az.rock.flyjob.js.domain.presentation.dto.response.resume.education.simple.SimpleAnyEducationResponseModel;
import az.rock.flyjob.js.domain.presentation.dto.response.resume.education.simple.SimpleMyEducationResponseModel;
import az.rock.flyjob.js.spec.privates.query.resume.detail.EducationQueryPrivateSpec;
import az.rock.lib.jresponse.response.success.JSuccessDataResponse;
import az.rock.lib.valueObject.SimplePageableRequest;
import az.rock.lib.valueObject.SimplePageableResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
public class EducationQueryPrivateController implements EducationQueryPrivateSpec {


    @Override
    public ResponseEntity<JSuccessDataResponse<SimplePageableResponse<MyEducationResponseModel>>> queryAllMyEducations(SimplePageableRequest pageableRequest) {

        return null;
    }

    @Override
    public ResponseEntity<JSuccessDataResponse<SimplePageableResponse<AnyEducationResponseModel>>> queryAllAnyEducations(UUID targetResumeId, SimplePageableRequest pageableRequest) {

        return null;
    }

    @Override
    public ResponseEntity<JSuccessDataResponse<SimplePageableResponse<SimpleMyEducationResponseModel>>> queryAllMySimpleEducations(SimplePageableRequest pageableRequest) {

        return null;
    }

    @Override
    public ResponseEntity<JSuccessDataResponse<SimplePageableResponse<SimpleAnyEducationResponseModel>>> queryAllAnySimpleEducations(UUID targetResumeId, SimplePageableRequest pageableRequest) {
        return null;
    }

    @Override
    public ResponseEntity<JSuccessDataResponse<MyEducationResponseModel>> findMyEducationById(UUID id) {
        return null;
    }

    @Override
    public ResponseEntity<JSuccessDataResponse<AnyEducationResponseModel>> findAnyEducationById(UUID id) {
        return null;
    }
}