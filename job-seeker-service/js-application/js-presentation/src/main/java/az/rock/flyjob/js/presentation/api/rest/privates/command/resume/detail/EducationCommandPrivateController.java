package az.rock.flyjob.js.presentation.api.rest.privates.command.resume.detail;

import az.rock.flyjob.js.domain.presentation.dto.request.abstracts.CreateRequest;
import az.rock.flyjob.js.domain.presentation.dto.request.abstracts.UpdateRequest;
import az.rock.flyjob.js.domain.presentation.dto.request.item.EducationCommandModel;
import az.rock.flyjob.js.domain.presentation.dto.request.item.ReorderCommandModel;
import az.rock.flyjob.js.domain.presentation.ports.input.services.command.abstracts.AbstractEducationCommandDomainPresentationService;
import az.rock.flyjob.js.spec.privates.command.resume.detail.EducationCommandPrivateSpec;
import az.rock.lib.jresponse.response.success.JSuccessResponse;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@CrossOrigin
@RestController
@RequestMapping(value = "/js/1.0/private/command/education", produces = MediaType.APPLICATION_JSON_VALUE)
public class EducationCommandPrivateController implements EducationCommandPrivateSpec {

    private final AbstractEducationCommandDomainPresentationService abstractEducationCommandDomainPresentationService;

    public EducationCommandPrivateController(AbstractEducationCommandDomainPresentationService abstractEducationCommandDomainPresentationService) {
        this.abstractEducationCommandDomainPresentationService = abstractEducationCommandDomainPresentationService;

    }

    @Override
    @PostMapping("/create")
    public ResponseEntity<JSuccessResponse> create(@RequestBody CreateRequest<EducationCommandModel> request) {
        this.abstractEducationCommandDomainPresentationService.create(request);
        return ResponseEntity.ok(JSuccessResponse.success());
    }

    @Override
    @PutMapping("/update")
    public ResponseEntity<JSuccessResponse> update(@RequestBody UpdateRequest<EducationCommandModel> request) {
        this.abstractEducationCommandDomainPresentationService.update(request);
        return ResponseEntity.ok(JSuccessResponse.success());
    }

    @Override
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<JSuccessResponse> delete(@PathVariable UUID id) {
        this.abstractEducationCommandDomainPresentationService.delete(id);
        return ResponseEntity.ok(JSuccessResponse.success());
    }

    @Override
    @PatchMapping("/reorder")
    public ResponseEntity<JSuccessResponse> reorder(ReorderCommandModel request) {
        this.abstractEducationCommandDomainPresentationService.reorder(request);
        return ResponseEntity.ok(JSuccessResponse.success());
    }
}
