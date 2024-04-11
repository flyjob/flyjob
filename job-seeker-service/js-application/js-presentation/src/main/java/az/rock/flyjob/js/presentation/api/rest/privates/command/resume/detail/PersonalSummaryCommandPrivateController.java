package az.rock.flyjob.js.presentation.api.rest.privates.command.resume.detail;

import az.rock.flyjob.js.spec.privates.command.resume.detail.PersonalSummaryCommandPrivateSpec;
import az.rock.lib.jresponse.response.success.JSuccessResponse;
import az.rock.lib.valueObject.SimpleContext;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping(value = "/js/1.0/private/command/summary", produces = MediaType.APPLICATION_JSON_VALUE)
public class PersonalSummaryCommandPrivateController implements PersonalSummaryCommandPrivateSpec {

    @Override
    @PutMapping("/change")
    public ResponseEntity<JSuccessResponse> changeSummary(SimpleContext context) {
        return null;
    }
}
