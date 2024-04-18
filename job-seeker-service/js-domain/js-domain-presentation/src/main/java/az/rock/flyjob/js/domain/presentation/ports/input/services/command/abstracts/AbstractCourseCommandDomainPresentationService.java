package az.rock.flyjob.js.domain.presentation.ports.input.services.command.abstracts;

import az.rock.flyjob.js.domain.presentation.dto.request.abstracts.CreateRequest;
import az.rock.flyjob.js.domain.presentation.dto.request.abstracts.UpdateRequest;
import az.rock.flyjob.js.domain.presentation.dto.request.item.CourseCommandModel;
import az.rock.flyjob.js.domain.presentation.dto.request.item.ReorderCommandModel;
import az.rock.lib.valueObject.MultipartFileWrapper;

import java.util.UUID;



public interface AbstractCourseCommandDomainPresentationService {
    void create(CreateRequest<CourseCommandModel> command);
    void update(UpdateRequest<CourseCommandModel> command);
    void delete(UUID courseId);
    void reorder(ReorderCommandModel request);
    void uploadCertificate(UUID courseId, MultipartFileWrapper file);

}
