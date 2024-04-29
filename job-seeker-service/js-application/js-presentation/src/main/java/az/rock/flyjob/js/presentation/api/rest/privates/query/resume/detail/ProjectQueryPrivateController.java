package az.rock.flyjob.js.presentation.api.rest.privates.query.resume.detail;

import az.rock.flyjob.js.domain.presentation.dto.response.resume.project.AnyProjectResponseModel;
import az.rock.flyjob.js.domain.presentation.dto.response.resume.project.MyProjectResponseModel;
import az.rock.flyjob.js.domain.presentation.dto.response.resume.project.simple.SimpleAnyProjectResponseModel;
import az.rock.flyjob.js.domain.presentation.dto.response.resume.project.simple.SimpleMyProjectResponseModel;
import az.rock.flyjob.js.domain.presentation.ports.input.services.query.abstracts.AbstractProjectQueryDomainPresentationService;
import az.rock.flyjob.js.spec.privates.query.resume.detail.ProjectQueryPrivateSpec;
import az.rock.lib.jresponse.response.success.JSuccessDataResponse;
import az.rock.lib.valueObject.SimplePageableRequest;
import az.rock.lib.valueObject.SimplePageableResponse;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@CrossOrigin
@RestController
@RequestMapping(value = "/js/1.0/private/query/project", produces = MediaType.APPLICATION_JSON_VALUE)
public class ProjectQueryPrivateController implements ProjectQueryPrivateSpec {
    private final AbstractProjectQueryDomainPresentationService projectQueryDomainPresentationService;

    public ProjectQueryPrivateController(@Qualifier("projectQueryDomainPresentationService") AbstractProjectQueryDomainPresentationService projectQueryDomainPresentationService) {
        this.projectQueryDomainPresentationService = projectQueryDomainPresentationService;
    }

    @Override
    @GetMapping(value = "/get-my/all")
    public ResponseEntity<JSuccessDataResponse<SimplePageableResponse<MyProjectResponseModel>>> queryAllMyProjects(SimplePageableRequest pageableRequest) {
        var allMyProjects = this.projectQueryDomainPresentationService.queryAllMyProjects(pageableRequest);
        return ResponseEntity.ok(new JSuccessDataResponse<>(allMyProjects));
    }

    @Override
    @GetMapping("/get-any/all/{resumeId}")
    public ResponseEntity<JSuccessDataResponse<SimplePageableResponse<AnyProjectResponseModel>>> queryAllAnyProjects(@PathVariable("resumeId") UUID targetResumeId, @ModelAttribute SimplePageableRequest pageableRequest) {
        var allAnyProjects = this.projectQueryDomainPresentationService.queryAllAnyProjects(targetResumeId, pageableRequest);
        return ResponseEntity.ok(new JSuccessDataResponse<>(allAnyProjects));
    }

    @Override
    public ResponseEntity<JSuccessDataResponse<SimplePageableResponse<SimpleMyProjectResponseModel>>> queryAllMySimpleProjects(SimplePageableRequest pageableRequest) {
        var allMySimpleProjects = this.projectQueryDomainPresentationService.queryAllMySimpleProjects(pageableRequest);
        return ResponseEntity.ok(new JSuccessDataResponse<>(allMySimpleProjects));
    }

    @Override
    public ResponseEntity<JSuccessDataResponse<SimplePageableResponse<SimpleAnyProjectResponseModel>>> queryAllAnySimpleProjects(UUID targetResumeId, SimplePageableRequest pageableRequest) {
        var allAnySimpleProjects = this.projectQueryDomainPresentationService.queryAllAnySimpleProjects(targetResumeId, pageableRequest);
        return ResponseEntity.ok(new JSuccessDataResponse<>(allAnySimpleProjects));
    }

    @Override
    public ResponseEntity<JSuccessDataResponse<MyProjectResponseModel>> findMyProjectById(UUID id) {
        var myProjectById = this.projectQueryDomainPresentationService.findMyProjectById(id);
        return ResponseEntity.ok(new JSuccessDataResponse<>(myProjectById));
    }

    @Override
    public ResponseEntity<JSuccessDataResponse<AnyProjectResponseModel>> findAnyProjectById(UUID id) {
        var anyProjectById = this.projectQueryDomainPresentationService.findAnyProjectById(id);
        return ResponseEntity.ok(new JSuccessDataResponse<>(anyProjectById));
    }
}
