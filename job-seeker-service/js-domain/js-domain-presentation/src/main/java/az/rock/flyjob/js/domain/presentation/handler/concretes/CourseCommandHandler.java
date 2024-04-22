package az.rock.flyjob.js.domain.presentation.handler.concretes;

import az.rock.flyjob.js.domain.core.exception.course.CourseAlreadyExistException;
import az.rock.flyjob.js.domain.core.exception.course.CourseDomainException;
import az.rock.flyjob.js.domain.core.exception.course.CourseLimitExceededException;
import az.rock.flyjob.js.domain.core.exception.course.CourseNotFoundException;
import az.rock.flyjob.js.domain.core.root.detail.CourseRoot;
import az.rock.flyjob.js.domain.presentation.dto.request.item.CourseCommandModel;
import az.rock.flyjob.js.domain.presentation.dto.request.item.ReorderCommandModel;
import az.rock.flyjob.js.domain.presentation.handler.abstracts.AbstractCourseCommandHandler;
import az.rock.flyjob.js.domain.presentation.handler.abstracts.AbstractCourseQueryHandler;
import az.rock.flyjob.js.domain.presentation.mapper.abstracts.AbstractCourseDomainMapper;
import az.rock.flyjob.js.domain.presentation.ports.dfs.AbstractFileStorageAdapter;
import az.rock.flyjob.js.domain.presentation.ports.output.repository.command.AbstractCourseCommandRepositoryAdapter;
import az.rock.flyjob.js.domain.presentation.ports.output.repository.query.AbstractCourseQueryRepositoryAdapter;
import az.rock.flyjob.js.domain.presentation.security.AbstractSecurityContextHolder;
import az.rock.lib.domain.id.js.CourseID;
import az.rock.lib.valueObject.AccessModifier;
import az.rock.lib.valueObject.MultipartFileWrapper;
import com.intellibucket.lib.payload.event.command.create.CourseCertificateUploadedEvent;
import com.intellibucket.lib.payload.event.command.create.CourseMergeEvent;
import com.intellibucket.lib.payload.event.command.delete.CourseDeleteEvent;
import com.intellibucket.lib.payload.payload.command.CourseDeletedPayload;
import com.intellibucket.lib.payload.payload.command.CourseFilePayload;
import com.intellibucket.lib.payload.payload.command.CourseMergePayload;
import org.springframework.stereotype.Component;

import java.util.Comparator;
import java.util.List;
import java.util.UUID;

@Component
public class CourseCommandHandler implements AbstractCourseCommandHandler {
    private final AbstractCourseQueryRepositoryAdapter courseQueryRepositoryAdapter;
    private final AbstractCourseDomainMapper courseDomainMapper;
    private final AbstractCourseCommandRepositoryAdapter courseCommandRepositoryAdapter;

    private final AbstractFileStorageAdapter fileStorageService;
    private final AbstractSecurityContextHolder securityContextHolder;

    private List<AccessModifier> mockAccessModifiers = List.of(AccessModifier.values());

    public CourseCommandHandler(AbstractCourseQueryRepositoryAdapter courseQueryRepositoryAdapter, AbstractCourseDomainMapper courseDomainMapper, AbstractCourseCommandRepositoryAdapter courseCommandRepositoryAdapter, AbstractFileStorageAdapter fileStorageService, AbstractSecurityContextHolder securityContextHolder) {
        this.courseQueryRepositoryAdapter = courseQueryRepositoryAdapter;
        this.courseDomainMapper = courseDomainMapper;
        this.courseCommandRepositoryAdapter = courseCommandRepositoryAdapter;
        this.fileStorageService = fileStorageService;
        this.securityContextHolder = securityContextHolder;
    }

    @Override
    public CourseMergeEvent create(CourseCommandModel command) throws CourseDomainException {
        var newCourseRoot = this.courseDomainMapper.toRoot(command, securityContextHolder.availableResumeID());
        if (courseQueryRepositoryAdapter.isInLimit(10L, securityContextHolder.availableResumeID()))
            throw new CourseLimitExceededException();
        if (courseQueryRepositoryAdapter.existsByEquality(newCourseRoot))
            throw new CourseAlreadyExistException();
        var optionalCourseRoot = this.courseCommandRepositoryAdapter.create(newCourseRoot);
        return CourseMergeEvent.of(CourseMergePayload.of(optionalCourseRoot.orElseThrow(CourseDomainException::new).getRootID().getRootID()));
    }

    @Override
    public CourseMergeEvent merge(CourseCommandModel command, UUID id) throws CourseDomainException {
        var oldCourse = courseQueryRepositoryAdapter.findById(CourseID.of(id), securityContextHolder.availableResumeID(), mockAccessModifiers);
        if (oldCourse.isEmpty()) throw new CourseNotFoundException();
        var course = courseDomainMapper.toRoot(command, oldCourse.get(), securityContextHolder.availableResumeID());
        if (courseQueryRepositoryAdapter.existsByEquality(course))
            throw new CourseAlreadyExistException();
        courseCommandRepositoryAdapter.update(course);
        return CourseMergeEvent.of(CourseMergePayload.of(id));
    }

    @Override
    public CourseDeleteEvent delete(UUID id) throws CourseDomainException {
        var optional = courseQueryRepositoryAdapter.findById(CourseID.of(id), securityContextHolder.availableResumeID(), mockAccessModifiers);
        if (optional.isEmpty()) throw new CourseNotFoundException();
        this.courseCommandRepositoryAdapter.delete(optional.get());
        return CourseDeleteEvent.of(CourseDeletedPayload.of(id));
    }

    @Override
    public CourseCertificateUploadedEvent uploadCertificate(UUID courseId, MultipartFileWrapper file) throws CourseDomainException {
        var optional = courseQueryRepositoryAdapter.findById(CourseID.of(courseId), securityContextHolder.availableResumeID(), mockAccessModifiers);
        if (optional.isEmpty()) throw new CourseNotFoundException();
        var savedFile = fileStorageService.uploadFile(file);
        var course = optional.get();
        course = course.changeCertificateFilePath(savedFile.getObject());
        this.courseCommandRepositoryAdapter.update(course);
        return CourseCertificateUploadedEvent.of(CourseFilePayload.of(courseId));
    }

    @Override
    public CourseMergeEvent reorder(
            ReorderCommandModel reorderCommandModel
    ) throws CourseDomainException {
        var courseList = courseQueryRepositoryAdapter.findAllByResume(securityContextHolder.availableResumeID(), mockAccessModifiers);
        var course = courseList.stream().filter(
                t -> t.getRootID().getRootID().
                        equals(reorderCommandModel.getTargetId()))
                .findFirst().orElseThrow(CourseNotFoundException::new);
        var reOrderNumber = reorderCommandModel.getOrderNumber();
        if (reorderCommandModel.getOrderNumber() > course.getOrderNumber()) ++reOrderNumber;
        course.changeOrderNumber(reOrderNumber);
        courseList.stream()
                .filter(t -> t.getOrderNumber() >= course.getOrderNumber() && !t.equals(course))
                .forEach(t -> t.changeOrderNumber(t.getOrderNumber() + 1));
        int orderCounter = 1;
        for (CourseRoot courseRoot : courseList.stream()
                .sorted(Comparator.comparingInt(CourseRoot::getOrderNumber))
                .toList()) {
            courseRoot.changeOrderNumber(orderCounter++);
        }
        courseCommandRepositoryAdapter.updateAll(courseList);
        return CourseMergeEvent.of(CourseMergePayload.of(reorderCommandModel.getTargetId()));
    }

}
