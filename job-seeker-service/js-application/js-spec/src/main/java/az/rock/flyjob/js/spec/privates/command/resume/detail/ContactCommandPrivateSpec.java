package az.rock.flyjob.js.spec.privates.command.resume.detail;

import az.rock.flyjob.js.domain.presentation.dto.request.abstracts.CreateRequest;
import az.rock.flyjob.js.domain.presentation.dto.request.abstracts.ReorderRequest;
import az.rock.flyjob.js.domain.presentation.dto.request.abstracts.UpdateRequest;
import az.rock.flyjob.js.domain.presentation.dto.request.item.ContactCommandModel;
import az.rock.flyjob.js.domain.presentation.dto.request.item.ReorderCommandModel;
import az.rock.lib.domain.id.js.ResumeID;
import az.rock.lib.jresponse.response.success.JSuccessResponse;
import org.springframework.http.ResponseEntity;

import java.rmi.server.UID;
import java.util.List;
import java.util.UUID;

public interface ContactCommandPrivateSpec {
    ResponseEntity<JSuccessResponse> create(CreateRequest<ContactCommandModel> request);

    ResponseEntity<JSuccessResponse> update(UpdateRequest<ContactCommandModel> request);

    ResponseEntity<JSuccessResponse> delete(UUID contactId);

     ResponseEntity<JSuccessResponse> deleteAll(ResumeID resumeID);

    ResponseEntity<JSuccessResponse> reorder(ReorderRequest<ContactCommandModel> request);
}
