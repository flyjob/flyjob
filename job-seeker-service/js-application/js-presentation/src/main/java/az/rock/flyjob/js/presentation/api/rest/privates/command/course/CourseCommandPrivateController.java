package az.rock.flyjob.js.presentation.api.rest.privates.command.course;

import az.rock.flyjob.js.domain.presentation.dto.request.abstracts.CreateRequest;
import az.rock.flyjob.js.domain.presentation.dto.request.abstracts.UpdateRequest;
import az.rock.flyjob.js.domain.presentation.dto.request.item.CourseCommandModel;
import az.rock.flyjob.js.domain.presentation.dto.request.item.ReorderCommandModel;
import az.rock.flyjob.js.domain.presentation.ports.input.services.command.abstracts.AbstractCourseCommandDomainPresentationService;
import az.rock.flyjob.js.presentation.mapper.MultipartFileWrapperMapper;
import az.rock.flyjob.js.spec.privates.command.resume.detail.CourseCommandPrivateSpec;
import az.rock.lib.jresponse.response.success.JSuccessResponse;
import az.rock.lib.valueObject.MultipartFileWrapper;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.UUID;


@CrossOrigin
@RestController
@RequestMapping(value = "/js/1.0/private/command/course", produces = MediaType.APPLICATION_JSON_VALUE)
public class CourseCommandPrivateController implements CourseCommandPrivateSpec {
    private final AbstractCourseCommandDomainPresentationService courseCommandDomainPresentationService;

    private final MultipartFileWrapperMapper multipartFileWrapperMapper;

    public CourseCommandPrivateController(AbstractCourseCommandDomainPresentationService courseCommandDomainPresentationService, MultipartFileWrapperMapper multipartFileWrapperMapper) {
        this.courseCommandDomainPresentationService = courseCommandDomainPresentationService;
        this.multipartFileWrapperMapper = multipartFileWrapperMapper;
    }

    @Override
    @PostMapping("/create")
    public ResponseEntity<JSuccessResponse> create(@RequestBody CreateRequest<CourseCommandModel> request) {
        this.courseCommandDomainPresentationService.create(request);
        return ResponseEntity.ok(new JSuccessResponse());
    }

    @Override
    @PutMapping("/update")
    public ResponseEntity<JSuccessResponse> update(@RequestBody UpdateRequest<CourseCommandModel> request) {
        this.courseCommandDomainPresentationService.update(request);
        return ResponseEntity.ok(new JSuccessResponse());
    }

    @Override
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<JSuccessResponse> delete(@PathVariable("id") UUID courseId) {
        this.courseCommandDomainPresentationService.delete(courseId);
        return ResponseEntity.ok(new JSuccessResponse());
    }

    @Override
    @PatchMapping("/reorder")
    public ResponseEntity<JSuccessResponse> reorder(@RequestBody ReorderCommandModel request) {
        this.courseCommandDomainPresentationService.reorder(request);
        return ResponseEntity.ok(new JSuccessResponse());
    }

    @Override
    @PostMapping(value = "/{courseId}/certificates",consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<JSuccessResponse> uploadCertificate(@PathVariable UUID courseId, @RequestBody MultipartFile file) {
        MultipartFileWrapper wrapFile = this.factoryWrapper(file);
        this.courseCommandDomainPresentationService.uploadCertificate(courseId,wrapFile);
        return ResponseEntity.ok(new JSuccessResponse());
    }

    private MultipartFileWrapper factoryWrapper(MultipartFile file) {
        MultipartFileWrapper wrapFile;
        try {
            wrapFile = this.multipartFileWrapperMapper.map(file);
        } catch (IOException e) {
            throw new RuntimeException("F0000000017");
        }
        return wrapFile;
    }
}
