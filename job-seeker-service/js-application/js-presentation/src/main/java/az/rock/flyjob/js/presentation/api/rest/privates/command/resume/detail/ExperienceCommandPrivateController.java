package az.rock.flyjob.js.presentation.api.rest.privates.command.resume.detail;

import az.rock.flyjob.js.domain.presentation.dto.request.abstracts.CreateRequest;
import az.rock.flyjob.js.domain.presentation.dto.request.abstracts.UpdateRequest;
import az.rock.flyjob.js.domain.presentation.dto.request.item.ExperienceCommandModel;
import az.rock.flyjob.js.domain.presentation.dto.request.item.ReorderCommandModel;
import az.rock.flyjob.js.domain.presentation.ports.input.services.command.abstracts.AbstractExperienceCommandDomainPresentationService;
import az.rock.flyjob.js.spec.privates.command.resume.detail.ExperienceCommandPrivateSpec;
import az.rock.lib.jresponse.response.success.JSuccessResponse;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;
@CrossOrigin
@RestController
@RequestMapping(value = "/js/1.0/private/command/experience",produces = MediaType.APPLICATION_JSON_VALUE)
public class ExperienceCommandPrivateController implements ExperienceCommandPrivateSpec {
    private AbstractExperienceCommandDomainPresentationService abstractExperienceCommandDomainPresentationService;

    public ExperienceCommandPrivateController(AbstractExperienceCommandDomainPresentationService abstractExperienceCommandDomainPresentationService) {
        this.abstractExperienceCommandDomainPresentationService = abstractExperienceCommandDomainPresentationService;
    }

    @Override
    @PostMapping("create")
    public ResponseEntity<JSuccessResponse> create(@RequestBody CreateRequest<ExperienceCommandModel> request) {
        this.abstractExperienceCommandDomainPresentationService.create(request);
        return ResponseEntity.ok(JSuccessResponse.success());
    }

    @Override
    @PutMapping("/update")
    public ResponseEntity<JSuccessResponse> update(@RequestBody UpdateRequest<ExperienceCommandModel> request) {
        this.abstractExperienceCommandDomainPresentationService.update(request);
        return ResponseEntity.ok(JSuccessResponse.success());
    }

    @Override
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<JSuccessResponse> delete(@PathVariable UUID id) {
        this.abstractExperienceCommandDomainPresentationService.delete(id);
        return ResponseEntity.ok(JSuccessResponse.success());
    }

    @Override
    @DeleteMapping("/delete/all")
    public ResponseEntity<JSuccessResponse> deleteAll() {
        this.abstractExperienceCommandDomainPresentationService.deleteAll();
        return ResponseEntity.ok(JSuccessResponse.success());
    }


    @Override
    @PatchMapping( "/reorder")
    public ResponseEntity<JSuccessResponse> reorder(ReorderCommandModel request) {
        this.abstractExperienceCommandDomainPresentationService.reorder(request);
        return ResponseEntity.ok(JSuccessResponse.success());
    }
}
