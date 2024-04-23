package az.rock.flyjob.js.presentation.api.rest.privates.command.resume.detail;

import az.rock.flyjob.js.domain.presentation.dto.request.abstracts.CreateRequest;
import az.rock.flyjob.js.domain.presentation.dto.request.abstracts.UpdateRequest;
import az.rock.flyjob.js.domain.presentation.dto.request.item.ProjectCommandModel;
import az.rock.flyjob.js.domain.presentation.dto.request.item.ReorderCommandModel;
import az.rock.flyjob.js.domain.presentation.ports.input.services.command.abstracts.AbstractProjectCommandDomainPresentationService;
import az.rock.flyjob.js.spec.privates.command.resume.detail.ProjectCommandPrivateSpec;
import az.rock.lib.jresponse.response.success.JSuccessResponse;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;
@CrossOrigin
@RestController
@RequestMapping(value ="/js/1.0/private/command/project" ,produces = MediaType.APPLICATION_JSON_VALUE)
public class ProjectCommandPrivateController implements ProjectCommandPrivateSpec {
    private final AbstractProjectCommandDomainPresentationService projectCommandDomainPresentationService;

    public ProjectCommandPrivateController(AbstractProjectCommandDomainPresentationService projectCommandDomainPresentationService) {
        this.projectCommandDomainPresentationService = projectCommandDomainPresentationService;
    }

    @Override
    @PostMapping(value = "/create")
    public ResponseEntity<JSuccessResponse> create(@RequestBody CreateRequest<ProjectCommandModel> request) {
        this.projectCommandDomainPresentationService.create(request);
        return ResponseEntity.ok(JSuccessResponse.success());
    }

    @Override
    @PutMapping(value = "/update")
    public ResponseEntity<JSuccessResponse> update(@RequestBody UpdateRequest<ProjectCommandModel> request) {
        this.projectCommandDomainPresentationService.update(request);
        return ResponseEntity.ok(JSuccessResponse.success());
    }

    @Override
    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<JSuccessResponse> delete(@PathVariable("id") UUID projectId) {
        this.projectCommandDomainPresentationService.delete(projectId);
        return ResponseEntity.ok(JSuccessResponse.success());
    }

    @Override
    @PatchMapping("/reorder")
    public ResponseEntity<JSuccessResponse> reorder(@RequestBody ReorderCommandModel request) {
        this.projectCommandDomainPresentationService.reorder(request);
        return ResponseEntity.ok(JSuccessResponse.success());
    }
}
