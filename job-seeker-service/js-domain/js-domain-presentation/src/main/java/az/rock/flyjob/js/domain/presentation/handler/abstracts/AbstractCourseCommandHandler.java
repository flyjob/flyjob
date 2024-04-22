package az.rock.flyjob.js.domain.presentation.handler.abstracts;


import az.rock.flyjob.js.domain.core.exception.course.CourseDomainException;
import az.rock.flyjob.js.domain.presentation.dto.request.item.CourseCommandModel;
import az.rock.flyjob.js.domain.presentation.dto.request.item.ReorderCommandModel;
import az.rock.lib.valueObject.MultipartFileWrapper;
import com.intellibucket.lib.payload.event.command.create.CourseCertificateUploadedEvent;
import com.intellibucket.lib.payload.event.command.create.CourseMergeEvent;
import com.intellibucket.lib.payload.event.command.delete.CourseDeleteEvent;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Transactional(propagation = Propagation.REQUIRES_NEW)
public interface AbstractCourseCommandHandler {

    CourseMergeEvent create(CourseCommandModel command) throws CourseDomainException;

    CourseMergeEvent merge(CourseCommandModel command,UUID id) throws CourseDomainException;

    CourseDeleteEvent delete(UUID id) throws CourseDomainException;

    CourseCertificateUploadedEvent uploadCertificate(UUID courseId, MultipartFileWrapper file) throws CourseDomainException;

    CourseMergeEvent reorder(ReorderCommandModel reorderCommandModel) throws CourseDomainException;
}
