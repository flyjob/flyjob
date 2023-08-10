package az.rock.flyjob.js.spec.privates.command.resume.detail;

import az.rock.flyjob.js.domain.presentation.dto.request.abstracts.CreateRequest;
import az.rock.flyjob.js.domain.presentation.dto.request.abstracts.UpdateRequest;
import az.rock.flyjob.js.domain.presentation.dto.request.model.PublicationCommandModel;
import az.rock.flyjob.js.domain.presentation.dto.request.model.ReorderCommandModel;
import az.rock.lib.jresponse.response.success.JSuccessResponse;
import org.springframework.http.ResponseEntity;

import java.util.UUID;

public interface PublicationCommandPrivateSpec {
    ResponseEntity<JSuccessResponse> create(CreateRequest<PublicationCommandModel> request);
    ResponseEntity<JSuccessResponse> update(UpdateRequest<PublicationCommandModel> request);
    ResponseEntity<JSuccessResponse> delete(UUID publicationId);
    ResponseEntity<JSuccessResponse> reorder(ReorderCommandModel request);
}
