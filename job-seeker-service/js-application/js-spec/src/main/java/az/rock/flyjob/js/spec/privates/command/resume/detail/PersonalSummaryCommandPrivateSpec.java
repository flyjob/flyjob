package az.rock.flyjob.js.spec.privates.command.resume.detail;

import az.rock.lib.jresponse.response.success.JSuccessResponse;
import az.rock.lib.valueObject.SimpleContext;
import org.springframework.http.ResponseEntity;

public interface PersonalSummaryCommandPrivateSpec {
    ResponseEntity<JSuccessResponse> changeSummary(SimpleContext context );
}
