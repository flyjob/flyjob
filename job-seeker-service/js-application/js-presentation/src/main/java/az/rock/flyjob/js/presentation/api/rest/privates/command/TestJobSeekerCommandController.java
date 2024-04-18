package az.rock.flyjob.js.presentation.api.rest.privates.command;

import az.rock.flyjob.js.domain.presentation.ports.input.services.command.abstracts.AbstractTestCommandDomainPresentationService;
import az.rock.lib.jresponse.response.success.JSuccessDataResponse;
import org.springframework.context.annotation.Profile;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@CrossOrigin("*")
@RestController
@Profile({"local", "devlop", "pre-develop"})
@RequestMapping(value = "/js/1.0/private/command/test", produces = MediaType.APPLICATION_JSON_VALUE)
public class TestJobSeekerCommandController {
    private final AbstractTestCommandDomainPresentationService testCommandDomainPresentationService;

    public TestJobSeekerCommandController(AbstractTestCommandDomainPresentationService testCommandDomainPresentationService) {
        this.testCommandDomainPresentationService = testCommandDomainPresentationService;
    }

    @GetMapping("/authorization/relation/{userId}/{targetUserId}")
    public ResponseEntity<JSuccessDataResponse<String>> testAuthorizationApiForRelation(@PathVariable(name = "userId") String userId,
                                                                                        @PathVariable(name = "targetUserId") String targetUserId) {
        var result = this.testCommandDomainPresentationService.testAuthorizationApiForRelation(UUID.fromString(userId), UUID.fromString(targetUserId));
        return ResponseEntity.ok(new JSuccessDataResponse<>(result));
    }
}
