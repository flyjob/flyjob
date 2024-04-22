package az.rock.flyjob.js.domain.presentation.mapper.concretes;

import az.rock.flyjob.js.domain.core.root.detail.CourseRoot;
import az.rock.flyjob.js.domain.presentation.dto.request.item.CourseCommandModel;
import az.rock.flyjob.js.domain.presentation.mapper.abstracts.AbstractCourseDomainMapper;
import az.rock.lib.domain.id.js.CourseID;
import az.rock.lib.domain.id.js.ResumeID;
import az.rock.lib.valueObject.AccessModifier;
import az.rock.lib.valueObject.ProcessStatus;
import az.rock.lib.valueObject.RowStatus;
import az.rock.lib.valueObject.Version;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class CourseDomainMapper implements AbstractCourseDomainMapper {

    @Override
    public CourseRoot toRoot(CourseCommandModel courseCommandModel, ResumeID resumeId) {
        var courseId = CourseID.of(UUID.randomUUID());
        return CourseRoot.Builder.builder()
                .courseTitle(courseCommandModel.getCourseTitle())
                .description(courseCommandModel.getDescription())
                .id(courseId)
                .country(courseCommandModel.getCountry())
                .city(courseCommandModel.getCity())
                .startDate(courseCommandModel.getStartDate().toLocalDate())
                .endDate(courseCommandModel.getEndDate().toLocalDate())
                .isOnline(courseCommandModel.getIsOnline())
                .rowStatus(RowStatus.ACTIVE)
                .version(Version.ONE)
                .verificationAddress(courseCommandModel.getVerificationAddress())
                .accessModifier(AccessModifier.PUBLIC)
                .processStatus(ProcessStatus.COMPLETED)
                .resume(resumeId)
                .institution(courseCommandModel.getInstitution())
                .orderNumber(-1)
                .build();
    }

    public CourseRoot toRoot(CourseCommandModel courseCommandModel, CourseRoot courseRoot,ResumeID resumeID){
        return CourseRoot.Builder.builder()
                .id(courseRoot.getRootID())
                .version(courseRoot.getVersion())
                .processStatus(courseRoot.getProcessStatus())
                .rowStatus(courseRoot.getRowStatus())
                .createdDate(courseRoot.getCreatedDate())
                .lastModifiedDate(courseRoot.getModificationDate())
                .resume(resumeID)
                .accessModifier(courseRoot.getAccessModifier())
                .orderNumber(courseRoot.getOrderNumber())
                .courseTitle(courseCommandModel.getCourseTitle())
                .institution(courseCommandModel.getInstitution())
                .isOnline(courseCommandModel.getIsOnline())
                .city(courseCommandModel.getCity())
                .country(courseCommandModel.getCountry())
                .startDate(courseCommandModel.getStartDate().toLocalDate())
                .endDate(courseCommandModel.getEndDate().toLocalDate())
                .description(courseCommandModel.getDescription())
                .certificateFilePath(courseRoot.getCertificateFilePath())
                .verificationAddress(courseCommandModel.getVerificationAddress())
                .build();
    }

}
