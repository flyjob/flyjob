package az.rock.flyjob.js.presentation.api.rest.privates.command.resume.detail;

import az.rock.flyjob.js.domain.presentation.ports.input.services.command.abstracts.AbstractPersonalSummaryCommandDomainPresentationService;
import az.rock.flyjob.js.spec.privates.command.resume.detail.PersonalSummaryCommandPrivateSpec;
import az.rock.lib.jresponse.response.success.JSuccessResponse;
import az.rock.lib.valueObject.SimpleContext;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping(value = "/js/1.0/private/command/summary", produces = MediaType.APPLICATION_JSON_VALUE)
public class PersonalSummaryCommandPrivateController implements PersonalSummaryCommandPrivateSpec {
    private final AbstractPersonalSummaryCommandDomainPresentationService abstractPersonalSummaryCommandDomainPresentationService;

    public PersonalSummaryCommandPrivateController(AbstractPersonalSummaryCommandDomainPresentationService abstractPersonalSummaryCommandDomainPresentationService) {
        this.abstractPersonalSummaryCommandDomainPresentationService = abstractPersonalSummaryCommandDomainPresentationService;
    }

    @Override
    @PutMapping("/change")
    public ResponseEntity<JSuccessResponse> changeSummary(@RequestBody SimpleContext context) {
        System.out.println("------------------"+context.getContext()+"----"+context.getTargetId()+"-------------------");
       this.abstractPersonalSummaryCommandDomainPresentationService.changeSummary(context);
        return ResponseEntity.ok(new JSuccessResponse());
    }
}
