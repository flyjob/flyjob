package az.rock.flyjob.js.presentation.api.rest.privates.query.resume.detail;

import az.rock.flyjob.js.domain.presentation.dto.response.resume.education.AnyEducationResponseModel;
import az.rock.flyjob.js.domain.presentation.dto.response.resume.education.MyEducationResponseModel;
import az.rock.flyjob.js.domain.presentation.dto.response.resume.education.simple.SimpleAnyEducationResponseModel;
import az.rock.flyjob.js.domain.presentation.dto.response.resume.education.simple.SimpleMyEducationResponseModel;
import az.rock.flyjob.js.domain.presentation.ports.input.services.query.abstracts.AbstractEducationQueryDomainPresentationService;
import az.rock.flyjob.js.spec.privates.query.resume.detail.EducationQueryPrivateSpec;
import az.rock.lib.jresponse.response.success.JSuccessDataResponse;
import az.rock.lib.valueObject.SimplePageableRequest;
import az.rock.lib.valueObject.SimplePageableResponse;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@CrossOrigin
@RequestMapping(value = "/js/1.0/private/query/education", produces = MediaType.APPLICATION_JSON_VALUE)
public class EducationQueryPrivateController implements EducationQueryPrivateSpec {
    private final AbstractEducationQueryDomainPresentationService educationQueryDomainPresentationService;

    public EducationQueryPrivateController(AbstractEducationQueryDomainPresentationService educationQueryDomainPresentationService) {
        this.educationQueryDomainPresentationService = educationQueryDomainPresentationService;
    }

    @Override
    @GetMapping("/get-my/educations")
    public ResponseEntity<JSuccessDataResponse<SimplePageableResponse<MyEducationResponseModel>>> queryAllMyEducations(@ModelAttribute("pageableRequest") SimplePageableRequest pageableRequest) {
        var response = educationQueryDomainPresentationService.queryAllMyEducations(pageableRequest);
        return ResponseEntity.ok(new JSuccessDataResponse<>(response));
    }

    @Override
    @GetMapping("/get-any/educations/{targetResumeId}")
    public ResponseEntity<JSuccessDataResponse<SimplePageableResponse<AnyEducationResponseModel>>> queryAllAnyEducations(@PathVariable UUID targetResumeId, @ModelAttribute("pageableRequest") SimplePageableRequest pageableRequest) {
        var response = educationQueryDomainPresentationService.queryAllAnyEducations(targetResumeId, pageableRequest);
        return ResponseEntity.ok(new JSuccessDataResponse<>(response));
    }

    @Override
    @GetMapping("/get-my/simple-educations")
    public ResponseEntity<JSuccessDataResponse<SimplePageableResponse<SimpleMyEducationResponseModel>>> queryAllMySimpleEducations(@ModelAttribute("pageableRequest") SimplePageableRequest pageableRequest) {
        var response = educationQueryDomainPresentationService.queryAllMySimpleEducations(pageableRequest);
        return ResponseEntity.ok(new JSuccessDataResponse<>(response));
    }

    @Override
    @GetMapping("/get-any/simple-educations/{targetResumeId}")
    public ResponseEntity<JSuccessDataResponse<SimplePageableResponse<SimpleAnyEducationResponseModel>>> queryAllAnySimpleEducations(@PathVariable UUID targetResumeId, @ModelAttribute("pageableRequest") SimplePageableRequest pageableRequest) {
        var response = educationQueryDomainPresentationService.queryAllAnySimpleEducations(targetResumeId, pageableRequest);
        return ResponseEntity.ok(new JSuccessDataResponse<>(response));
    }

    @Override
    @GetMapping("/get-my/education/{id}")
    public ResponseEntity<JSuccessDataResponse<MyEducationResponseModel>> findMyEducationById(@PathVariable UUID id) {
        var response = educationQueryDomainPresentationService.findMyEducationById(id);
        return ResponseEntity.ok(new JSuccessDataResponse<>(response));
    }

    @Override
    @GetMapping("/get-any/education/{id}")
    public ResponseEntity<JSuccessDataResponse<AnyEducationResponseModel>> findAnyEducationById(@PathVariable UUID id) {
        var response = educationQueryDomainPresentationService.findAnyEducationById(id);
        return ResponseEntity.ok(new JSuccessDataResponse<>(response));
    }
}