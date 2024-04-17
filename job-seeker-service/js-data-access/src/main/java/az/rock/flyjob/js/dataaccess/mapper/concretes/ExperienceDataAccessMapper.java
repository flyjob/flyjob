package az.rock.flyjob.js.dataaccess.mapper.concretes;

import az.rock.flyjob.js.dataaccess.mapper.abstracts.AbstractExperienceDataAccessMapper;
import az.rock.flyjob.js.dataaccess.model.batis.model.ExperienceCompose;
import az.rock.flyjob.js.dataaccess.model.entity.resume.ResumeEntity;
import az.rock.flyjob.js.dataaccess.model.entity.resume.details.ExperienceEntity;
import az.rock.flyjob.js.domain.core.root.detail.ExperienceRoot;
import az.rock.lib.domain.BaseEntity;
import az.rock.lib.domain.id.js.CourseID;
import az.rock.lib.domain.id.js.ExperienceID;
import az.rock.lib.domain.id.js.ResumeID;
import az.rock.lib.util.GDateTime;
import az.rock.lib.valueObject.*;
import org.springframework.stereotype.Component;

import java.time.ZoneId;
import java.util.Optional;


@Component
public class    ExperienceDataAccessMapper implements AbstractExperienceDataAccessMapper {
    @Override
    public Optional<ExperienceRoot> toRoot(ExperienceEntity entity) {
        var optionalEntity = Optional.ofNullable(entity);
        if(optionalEntity.isEmpty())return Optional.empty();
        var safetyResumeEntity = optionalEntity.get();
        return Optional.of(
                ExperienceRoot.Builder.builder()
                        .id(ExperienceID.of(safetyResumeEntity.getUuid()))
                        .version(Version.of(safetyResumeEntity.getVersion()))
                        .processStatus(safetyResumeEntity.getProcessStatus())
                        .rowStatus(safetyResumeEntity.getRowStatus())
                        .createdDate(GDateTime.toZonedDateTime(safetyResumeEntity.getCreatedDate()))
                        .lastModifiedDate(GDateTime.toZonedDateTime(safetyResumeEntity.getLastModifiedDate()))
                        .resume(ResumeID.of(safetyResumeEntity.getResume().getUuid()))
                        .accessModifier(safetyResumeEntity.getAccessModifier())
                        .orderNumber(safetyResumeEntity.getOrderNumber())
                        .employer(safetyResumeEntity.getEmployer())
                        .link(safetyResumeEntity.getLink())
                        .jobTitle(safetyResumeEntity.getJobTitle())
                        .cityId(safetyResumeEntity.getCityId())
                        .workingType(safetyResumeEntity.getWorkingType())
                        .workingTimeType(safetyResumeEntity.getWorkingTimeType())
                        .description(safetyResumeEntity.getDescription())
                        .startDate(GDateTime.toZonedDateTime(safetyResumeEntity.getStartDate()))
                        .endDate(GDateTime.toZonedDateTime(safetyResumeEntity.getEndDate()))
                        .build()
        );
    }

    @Override
    public Optional<ExperienceEntity> toEntity(ExperienceRoot root) {
        var optionalCourseRoot = Optional.ofNullable(root);
        if(optionalCourseRoot.isEmpty())return Optional.empty();
        var safetyCourseRoot = optionalCourseRoot.get();
        var resume  = ResumeEntity.referenceOf(safetyCourseRoot.getResume().getRootID());
        return Optional.of(
                ExperienceEntity.Builder.builder()
                        .uuid(safetyCourseRoot.getRootID().getAbsoluteID())
                        .version(safetyCourseRoot.getVersionValue())
                        .processStatus(safetyCourseRoot.getProcessStatus())
                        .rowStatus(safetyCourseRoot.getRowStatus())
                        .createdDate(GDateTime.toTimestamp(safetyCourseRoot.getCreatedDate()))
                        .lastModifiedDate(GDateTime.toTimestamp(safetyCourseRoot.getModificationDate()))
                        .resume(resume)
                        .accessModifier(safetyCourseRoot.getAccessModifier())
                        .orderNumber(safetyCourseRoot.getOrderNumber())
                        .employer(safetyCourseRoot.getEmployer())
                        .link(safetyCourseRoot.getLink())
                        .jobTitle(safetyCourseRoot.getLink())
                        .cityId(safetyCourseRoot.getCityId())
                        .workingTimeType(safetyCourseRoot.getWorkingTimeType())
                        .workingTimeType(safetyCourseRoot.getWorkingTimeType())
                        .description(safetyCourseRoot.getDescription())
                        .startDate(GDateTime.toTimestamp(safetyCourseRoot.getStartDate()))
                        .endDate(GDateTime.toTimestamp(safetyCourseRoot.getEndDate()))
                        .build()
        );
    }

    @Override
    public Optional<ExperienceRoot> toRoot(ExperienceCompose compose) {
        var optionalCompose = Optional.ofNullable(compose);
        if(optionalCompose.isEmpty())return Optional.empty();
        var safetyCompose = optionalCompose.get();
        return Optional.of(
                ExperienceRoot.Builder.builder()
                        .id(ExperienceID.of(safetyCompose.getUuid()))
                        .version(Version.of(safetyCompose.getVersion()))
                        .processStatus(ProcessStatus.of(safetyCompose.getProcessStatus()))
                        .rowStatus(RowStatus.valueOf(safetyCompose.getRowStatus()))
                        .createdDate(safetyCompose.getCreatedDate().toInstant().atZone(ZoneId.systemDefault()))
                        .lastModifiedDate(safetyCompose.getModificationDate().toInstant().atZone(ZoneId.systemDefault()))
                        .resume(ResumeID.of(safetyCompose.getResumeUuid()))
                        .accessModifier(AccessModifier.valueOf(safetyCompose.getAccessModifier()))
                        .orderNumber(safetyCompose.getOrderNumber())
                        .employer(safetyCompose.getEmployer())
                        .link(safetyCompose.getLink())
                        .jobTitle(safetyCompose.getJobTitle())
                        .cityId(safetyCompose.getCityId())
                        .workingType(WorkingType.valueOf(safetyCompose.getWorkingType()))
                        .workingTimeType(WorkingTimeLineType.valueOf(safetyCompose.getWorkingTimeType()))
                        .description(safetyCompose.getDescription())
                        .startDate(GDateTime.toZonedDateTime(safetyCompose.getStartDate()))
                        .endDate(GDateTime.toZonedDateTime(safetyCompose.getEndDate()))
                        .build()
        );
    }
}
