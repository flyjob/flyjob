package az.rock.flyjob.js.spec.privates.query.resume.detail;

import az.rock.flyjob.js.domain.presentation.dto.response.resume.interest.AnyInterestResponseModel;
import az.rock.flyjob.js.domain.presentation.dto.response.resume.interest.MyInterestResponseModel;
import az.rock.flyjob.js.domain.presentation.dto.response.resume.interest.simple.SimpleAnyInterestResponseModel;
import az.rock.flyjob.js.domain.presentation.dto.response.resume.interest.simple.SimpleMyInterestResponseModel;
import az.rock.lib.jresponse.response.success.JSuccessDataResponse;
import az.rock.lib.valueObject.SimplePageableRequest;
import az.rock.lib.valueObject.SimplePageableResponse;
import org.springframework.http.ResponseEntity;

import java.util.UUID;

public interface InterestQueryPrivateSpec {

    ResponseEntity<JSuccessDataResponse<SimplePageableResponse<MyInterestResponseModel>>> queryAllMyInterests(SimplePageableRequest pageableRequest);

    ResponseEntity<JSuccessDataResponse<SimplePageableResponse<AnyInterestResponseModel>>> queryAllAnyInterests(UUID targetResumeId, SimplePageableRequest pageableRequest);

    ResponseEntity<JSuccessDataResponse<SimplePageableResponse<SimpleMyInterestResponseModel>>> queryAllMySimpleInterests(SimplePageableRequest pageableRequest);


    ResponseEntity<JSuccessDataResponse<SimplePageableResponse<SimpleAnyInterestResponseModel>>> queryAllAnySimpleInterests(UUID targetResumeId, SimplePageableRequest pageableRequest);

    ResponseEntity<JSuccessDataResponse<MyInterestResponseModel>> findMyInterestById(UUID id);

    ResponseEntity<JSuccessDataResponse<AnyInterestResponseModel>> findAnyInterestById(UUID id);

}
