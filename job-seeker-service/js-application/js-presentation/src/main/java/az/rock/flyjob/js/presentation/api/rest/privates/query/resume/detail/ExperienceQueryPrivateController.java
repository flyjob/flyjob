package az.rock.flyjob.js.presentation.api.rest.privates.query.resume.detail;

import az.rock.flyjob.js.domain.presentation.dto.response.resume.experience.AnyExperienceResponseModel;
import az.rock.flyjob.js.domain.presentation.dto.response.resume.experience.MyExperienceResponseModel;
import az.rock.flyjob.js.domain.presentation.dto.response.resume.experience.simple.SimpleAnyExperienceResponseModel;
import az.rock.flyjob.js.domain.presentation.dto.response.resume.experience.simple.SimpleMyExperienceResponseModel;
import az.rock.flyjob.js.domain.presentation.ports.input.services.query.abstracts.AbstractExperienceQueryDomainPresentationService;
import az.rock.flyjob.js.spec.privates.query.resume.detail.ExperienceQueryPrivateSpec;
import az.rock.lib.jresponse.response.success.JSuccessDataResponse;
import az.rock.lib.valueObject.SimplePageableRequest;
import az.rock.lib.valueObject.SimplePageableResponse;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@CrossOrigin
@RestController
@RequestMapping(value = "/js/1.0/private/query/experience", produces = MediaType.APPLICATION_JSON_VALUE)
public class ExperienceQueryPrivateController implements ExperienceQueryPrivateSpec {

    private final AbstractExperienceQueryDomainPresentationService abstractExperienceQueryDomainPresentationService;

    public ExperienceQueryPrivateController(AbstractExperienceQueryDomainPresentationService abstractExperienceQueryDomainPresentationService) {
        this.abstractExperienceQueryDomainPresentationService = abstractExperienceQueryDomainPresentationService;
    }
    @Override
    @GetMapping("/get-my-all")
    public ResponseEntity<JSuccessDataResponse<SimplePageableResponse<MyExperienceResponseModel>>> queryAllMyExperiences(@ModelAttribute SimplePageableRequest pageableRequest) {
        var allMyExperiences = abstractExperienceQueryDomainPresentationService.allMyExperiences(pageableRequest);
        return ResponseEntity.ok(new JSuccessDataResponse<>(allMyExperiences));
    }

    @Override
    @GetMapping("/get-any-all/{resumeId}")
    public ResponseEntity<JSuccessDataResponse<SimplePageableResponse<AnyExperienceResponseModel>>> queryAllAnyExperiences(@PathVariable("resumeId") UUID targetResumeId,@ModelAttribute SimplePageableRequest pageableRequest) {
        var allAnyExperiences = abstractExperienceQueryDomainPresentationService.allAnyExperiences(targetResumeId,pageableRequest);
        return ResponseEntity.ok(new JSuccessDataResponse<>(allAnyExperiences));
    }

    @Override
    @GetMapping("/get-my/{experienceUUID}")
    public ResponseEntity<JSuccessDataResponse<MyExperienceResponseModel>> findMyExperienceById(@PathVariable("experienceUUID") UUID id) {
        var myExperience = abstractExperienceQueryDomainPresentationService.myExperienceById(id);
        return ResponseEntity.ok(new JSuccessDataResponse<>(myExperience));
    }

    @Override
    @GetMapping("/get-my-simple/all")
    public ResponseEntity<JSuccessDataResponse<SimplePageableResponse<SimpleMyExperienceResponseModel>>> queryAllMySimpleExperiences(@ModelAttribute SimplePageableRequest pageableRequest) {
        var allMySimpleExperiences = abstractExperienceQueryDomainPresentationService.allMySimpleExperiences(pageableRequest);
        return ResponseEntity.ok(new JSuccessDataResponse<>(allMySimpleExperiences));
    }

    @Override
    @GetMapping("/get-any-simple/{resumeID}")
    public ResponseEntity<JSuccessDataResponse<SimplePageableResponse<SimpleAnyExperienceResponseModel>>> queryAllAnySimpleExperiences(@PathVariable("resumeID") UUID targetResumeId,@ModelAttribute SimplePageableRequest pageableRequest) {
        var allAnySimpleExperiences = abstractExperienceQueryDomainPresentationService.allAnySimpleExperiences(targetResumeId,pageableRequest);
        return ResponseEntity.ok(new JSuccessDataResponse<>(allAnySimpleExperiences));
    }

    @Override
    @GetMapping("/get-any/{id}")
    public ResponseEntity<JSuccessDataResponse<AnyExperienceResponseModel>> findAnyExperienceById(@PathVariable("id") UUID id) {
        var anyExperience = abstractExperienceQueryDomainPresentationService.anyExperienceById(id);
        return ResponseEntity.ok(new JSuccessDataResponse<>(anyExperience));
    }
}
