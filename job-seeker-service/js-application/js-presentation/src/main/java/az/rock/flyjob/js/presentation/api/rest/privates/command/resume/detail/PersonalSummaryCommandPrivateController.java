package az.rock.flyjob.js.presentation.api.rest.privates.command.resume.detail;

import az.rock.flyjob.js.domain.presentation.dto.request.item.PersonalSummaryCommandModel;
import az.rock.flyjob.js.domain.presentation.ports.input.services.command.abstracts.AbstractPersonalSummaryCommandDomainPresentationService;
import az.rock.flyjob.js.spec.privates.command.resume.detail.PersonalSummaryCommandPrivateSpec;
import az.rock.lib.jresponse.response.success.JSuccessResponse;
import az.rock.lib.valueObject.SimpleContext;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@CrossOrigin
@RestController
@RequestMapping(value = "/js/1.0/private/command/summary", produces = MediaType.APPLICATION_JSON_VALUE)
public class PersonalSummaryCommandPrivateController implements PersonalSummaryCommandPrivateSpec {
    private final AbstractPersonalSummaryCommandDomainPresentationService abstractPersonalSummaryCommandDomainPresentationService;

    public PersonalSummaryCommandPrivateController(AbstractPersonalSummaryCommandDomainPresentationService abstractPersonalSummaryCommandDomainPresentationService) {
        this.abstractPersonalSummaryCommandDomainPresentationService = abstractPersonalSummaryCommandDomainPresentationService;
    }

    @Override
    @PostMapping("/create")
    public ResponseEntity<JSuccessResponse> createSummary(@ModelAttribute PersonalSummaryCommandModel context) {

        this.abstractPersonalSummaryCommandDomainPresentationService.createSummary(context);
        return ResponseEntity.ok(new JSuccessResponse());
    }

    @Override
    @PutMapping("/change")
    public ResponseEntity<JSuccessResponse> changeSummary(@RequestBody SimpleContext context) {
        this.abstractPersonalSummaryCommandDomainPresentationService.changeSummary(context);
        return ResponseEntity.ok(new JSuccessResponse());
    }

    @DeleteMapping("/delete/{summaryId}")
    @Override
    public ResponseEntity<JSuccessResponse> deleteSummary(@PathVariable("summaryId") UUID summaryId) {
        this.abstractPersonalSummaryCommandDomainPresentationService.deleteSummary(summaryId);
        return ResponseEntity.ok(new JSuccessResponse());
    }
}
