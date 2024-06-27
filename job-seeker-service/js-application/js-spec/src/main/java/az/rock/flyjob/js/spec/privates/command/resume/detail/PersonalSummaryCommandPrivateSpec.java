package az.rock.flyjob.js.spec.privates.command.resume.detail;

import az.rock.flyjob.js.domain.presentation.dto.request.item.PersonalSummaryCommandModel;
import az.rock.lib.jresponse.response.success.JSuccessResponse;
import az.rock.lib.valueObject.SimpleContext;
import org.springframework.http.ResponseEntity;

import java.util.UUID;

public interface PersonalSummaryCommandPrivateSpec {


    ResponseEntity<JSuccessResponse> createSummary(PersonalSummaryCommandModel context);
    ResponseEntity<JSuccessResponse> changeSummary(SimpleContext context );

    ResponseEntity<JSuccessResponse> deleteSummary(UUID summaryId );



}
