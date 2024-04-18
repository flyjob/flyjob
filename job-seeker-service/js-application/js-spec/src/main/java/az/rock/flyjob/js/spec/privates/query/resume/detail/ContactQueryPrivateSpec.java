package az.rock.flyjob.js.spec.privates.query.resume.detail;

import az.rock.flyjob.js.domain.presentation.dto.response.resume.contact.AnyContactResponseModel;
import az.rock.flyjob.js.domain.presentation.dto.response.resume.contact.MyContactResponseModel;
import az.rock.flyjob.js.domain.presentation.dto.response.resume.contact.simple.SimpleAnyContactResponseModel;
import az.rock.flyjob.js.domain.presentation.dto.response.resume.contact.simple.SimpleMyContactResponseModel;
import az.rock.lib.jresponse.response.success.JSuccessDataResponse;
import az.rock.lib.valueObject.SimplePageableRequest;
import az.rock.lib.valueObject.SimplePageableResponse;
import org.springframework.http.ResponseEntity;

import java.util.UUID;

public interface ContactQueryPrivateSpec {
    ResponseEntity<JSuccessDataResponse<SimplePageableResponse<MyContactResponseModel>>> queryAllMyContacts(SimplePageableRequest pageableRequest);

    ResponseEntity<JSuccessDataResponse<SimplePageableResponse<AnyContactResponseModel>>> queryAllAnyContacts(UUID targetResumeId, SimplePageableRequest pageableRequest);

    ResponseEntity<JSuccessDataResponse<SimplePageableResponse<SimpleMyContactResponseModel>>> queryAllMySimpleContacts(SimplePageableRequest pageableRequest);

    ResponseEntity<JSuccessDataResponse<SimplePageableResponse<SimpleAnyContactResponseModel>>> queryAllAnySimpleContacts(UUID targetResumeId, SimplePageableRequest pageableRequest);

    ResponseEntity<JSuccessDataResponse<MyContactResponseModel>> findMyContactById(UUID id);

    ResponseEntity<JSuccessDataResponse<AnyContactResponseModel>> findAnyContactById(UUID id);

}
