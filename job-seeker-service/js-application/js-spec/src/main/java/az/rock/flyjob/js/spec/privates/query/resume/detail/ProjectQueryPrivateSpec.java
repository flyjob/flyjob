package az.rock.flyjob.js.spec.privates.query.resume.detail;

import az.rock.flyjob.js.domain.presentation.dto.response.resume.contact.AnyContactResponseModel;
import az.rock.flyjob.js.domain.presentation.dto.response.resume.contact.MyContactResponseModel;
import az.rock.flyjob.js.domain.presentation.dto.response.resume.project.AnyProjectResponseModel;
import az.rock.flyjob.js.domain.presentation.dto.response.resume.project.MyProjectResponseModel;
import az.rock.flyjob.js.domain.presentation.dto.response.resume.project.simple.SimpleAnyProjectResponseModel;
import az.rock.flyjob.js.domain.presentation.dto.response.resume.project.simple.SimpleMyProjectResponseModel;
import az.rock.lib.jresponse.response.success.JSuccessDataResponse;
import az.rock.lib.valueObject.SimplePageableRequest;
import az.rock.lib.valueObject.SimplePageableResponse;
import org.springframework.http.ResponseEntity;

import java.util.UUID;

public interface ProjectQueryPrivateSpec {
    ResponseEntity<JSuccessDataResponse<SimplePageableResponse<MyProjectResponseModel>>> queryAllMyProjects(SimplePageableRequest pageableRequest);
    ResponseEntity<JSuccessDataResponse<SimplePageableResponse<AnyProjectResponseModel>>> queryAllAnyProjects(UUID targetResumeId, SimplePageableRequest pageableRequest);
    ResponseEntity<JSuccessDataResponse<SimplePageableResponse<SimpleMyProjectResponseModel>>> queryAllMySimpleProjects(SimplePageableRequest pageableRequest);
    ResponseEntity<JSuccessDataResponse<SimplePageableResponse<SimpleAnyProjectResponseModel>>> queryAllAnySimpleProjects(UUID targetResumeId, SimplePageableRequest pageableRequest);
    ResponseEntity<JSuccessDataResponse<MyProjectResponseModel>> findMyProjectById(UUID id);

    ResponseEntity<JSuccessDataResponse<AnyProjectResponseModel>> findAnyProjectById(UUID id);

}
