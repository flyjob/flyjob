package az.rock.flyjob.js.domain.presentation.ports.input.services.command.concretes;


import az.rock.flyjob.js.domain.presentation.dto.request.abstracts.CreateRequest;
import az.rock.flyjob.js.domain.presentation.dto.request.abstracts.UpdateRequest;
import az.rock.flyjob.js.domain.presentation.dto.request.item.CourseCommandModel;
import az.rock.flyjob.js.domain.presentation.dto.request.item.ReorderCommandModel;
import az.rock.flyjob.js.domain.presentation.handler.abstracts.AbstractCourseCommandHandler;
import az.rock.flyjob.js.domain.presentation.ports.input.services.command.abstracts.AbstractCourseCommandDomainPresentationService;
import az.rock.lib.annotation.InputPort;
import az.rock.lib.jexception.JRuntimeException;
import az.rock.lib.valueObject.MultipartFileWrapper;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@InputPort
@Slf4j
public class CourseCommandDomainPresentationService implements AbstractCourseCommandDomainPresentationService {
    private AbstractCourseCommandHandler commandHandler;

    public CourseCommandDomainPresentationService(AbstractCourseCommandHandler commandHandler) {
        this.commandHandler = commandHandler;
    }

    @SneakyThrows
    @Override
    public void create(CreateRequest<CourseCommandModel> command) {
        var courseCreatedEvent = commandHandler.create(command.getModel());
    }
    @SneakyThrows
    @Override
    public void update(UpdateRequest<CourseCommandModel> command) {
        var courseUpdatedEvent = commandHandler.merge(command.getModel(), command.getTargetId());
    }
    @SneakyThrows
    @Override
    public void delete(UUID courseId) {
        var courseDeleteEvent = commandHandler.delete(courseId);
    }

    @SneakyThrows
    @Override
    public void reorder(ReorderCommandModel command) {
        var reorderEvent = commandHandler.reorder(command);
    }

    @SneakyThrows
    @Override
    public void uploadCertificate(UUID courseId, MultipartFileWrapper file) {
        var certificateEvent = commandHandler.uploadCertificate(courseId, file);
    }
}
