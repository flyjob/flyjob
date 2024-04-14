package az.rock.flyjob.js.presentation.api.rest.privates.command.resume.detail;

import az.rock.flyjob.js.domain.presentation.dto.request.abstracts.CreateRequest;
import az.rock.flyjob.js.domain.presentation.dto.request.abstracts.UpdateRequest;
import az.rock.flyjob.js.domain.presentation.dto.request.item.ExperienceCommandModel;
import az.rock.flyjob.js.domain.presentation.dto.request.item.ReorderCommandModel;
import az.rock.flyjob.js.spec.privates.command.resume.detail.ExperienceCommandPrivateSpec;
import az.rock.lib.jresponse.response.success.JSuccessResponse;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;
@CrossOrigin
@RestController
@RequestMapping(value = "/js/1.0/private/command/experience",produces = MediaType.APPLICATION_JSON_VALUE)
public class ExperienceCommandPrivateController implements ExperienceCommandPrivateSpec {
    @Override
    public ResponseEntity<JSuccessResponse> create(CreateRequest<ExperienceCommandModel> request) {
        return null;
    }

    @Override
    public ResponseEntity<JSuccessResponse> update(UpdateRequest<ExperienceCommandModel> request) {
        return null;
    }

    @Override
    public ResponseEntity<JSuccessResponse> delete(UUID experienceId) {
        return null;
    }

    @Override
    public ResponseEntity<JSuccessResponse> deleteAll() {
        return ExperienceCommandPrivateSpec.super.deleteAll();
    }

    @Override
    public ResponseEntity<JSuccessResponse> reorder(ReorderCommandModel request) {
        return null;
    }
}
