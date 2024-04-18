package az.rock.flyjob.js.presentation.api.rest.privates.command.resume.detail;

import az.rock.flyjob.js.domain.presentation.dto.request.abstracts.CreateRequest;
import az.rock.flyjob.js.domain.presentation.dto.request.abstracts.UpdateRequest;
import az.rock.flyjob.js.domain.presentation.dto.request.item.InterestCommandModel;
import az.rock.flyjob.js.domain.presentation.dto.request.item.ReorderCommandModel;
import az.rock.flyjob.js.domain.presentation.ports.input.services.command.abstracts.AbstractInterestCommandDomainPresentationService;
import az.rock.flyjob.js.spec.privates.command.resume.detail.InterestCommandPrivateSpec;
import az.rock.lib.jresponse.response.success.JSuccessResponse;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@CrossOrigin
@RestController
@RequestMapping(value = "/js/1.0/private/command/interest", produces = MediaType.APPLICATION_JSON_VALUE)
public class InterestCommandPrivateController implements InterestCommandPrivateSpec {

    private final AbstractInterestCommandDomainPresentationService abstractInterestCommandDomainPresentationService;

    public InterestCommandPrivateController(AbstractInterestCommandDomainPresentationService abstractInterestCommandDomainPresentationService) {
        this.abstractInterestCommandDomainPresentationService = abstractInterestCommandDomainPresentationService;
    }


    @Override
    @PostMapping("/create")
    public ResponseEntity<JSuccessResponse> create(@RequestBody CreateRequest<InterestCommandModel> request) {
        this.abstractInterestCommandDomainPresentationService.create(request.getModel());
        return ResponseEntity.ok(new JSuccessResponse());
    }

    @Override
    @PutMapping("/update")
    public ResponseEntity<JSuccessResponse> update(@RequestBody UpdateRequest<InterestCommandModel> request) {
        this.abstractInterestCommandDomainPresentationService.update(request);
        return ResponseEntity.ok(new JSuccessResponse());
    }

    @Override
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<JSuccessResponse> delete(@PathVariable("id") UUID interestId){
        this.abstractInterestCommandDomainPresentationService.delete(interestId);
        return ResponseEntity.ok(new JSuccessResponse());
    }

    @Override
    @PatchMapping("/reorder")
    public ResponseEntity<JSuccessResponse> reorder(@RequestBody ReorderCommandModel request) {
        this.abstractInterestCommandDomainPresentationService.reorder(request);
        return ResponseEntity.ok(new JSuccessResponse());
    }
}
