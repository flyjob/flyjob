package az.rock.flyjob.js.dataaccess.mapper.concretes;


import az.rock.flyjob.js.dataaccess.mapper.abstracts.AbstractEducationDataAccessMapper;
import az.rock.flyjob.js.dataaccess.model.batis.model.EducationCompose;
import az.rock.flyjob.js.dataaccess.model.entity.resume.ResumeEntity;
import az.rock.flyjob.js.dataaccess.model.entity.resume.details.EducationEntity;
import az.rock.flyjob.js.domain.core.root.detail.EducationRoot;
import az.rock.lib.domain.id.js.EducationID;
import az.rock.lib.domain.id.js.ResumeID;
import az.rock.lib.util.GDateTime;
import az.rock.lib.valueObject.AccessModifier;
import az.rock.lib.valueObject.ProcessStatus;
import az.rock.lib.valueObject.RowStatus;
import az.rock.lib.valueObject.Version;
import az.rock.lib.valueObject.js.EducationDegree;
import az.rock.lib.valueObject.js.EducationState;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.UUID;

@Component
public class EducationDataAccessMapper implements AbstractEducationDataAccessMapper {


    @Override
    public Optional<EducationRoot> toRoot(EducationEntity entity) {
        var optionalEntity = Optional.ofNullable(entity);
        if (optionalEntity.isEmpty()) return Optional.empty();
        return Optional.of(EducationRoot.Builder.builder()
                .uuid(EducationID.of(entity.getUuid()))
                .resume(ResumeID.of(entity.getResume().getUuid()))
                .version(Version.of(entity.getVersion()))
                .rowStatus(entity.getRowStatus())
                .processStatus(entity.getProcessStatus())
                .createdDate(GDateTime.toZonedDateTime(entity.getCreatedDate()))
                .lastModifiedDate(GDateTime.toZonedDateTime(entity.getCreatedDate()))
                .accessModifier(entity.getAccessModifier())
                .cityId(entity.getCityId())
                .establishmentUUID(entity.getEstablishmentUUID())
                .establishmentName(entity.getEstablishmentName())
                .orderNumber(entity.getOrderNumber())
                .startDate(entity.getStartDate())
                .endDate(entity.getEndDate())
                .description(entity.getDescription())
                .link(entity.getLink())
                .state(entity.getState())
                .degree(entity.getDegree())
                .build());
    }

    @Override
    public Optional<EducationEntity> toEntity(EducationRoot root) {
        var optionalRoot = Optional.ofNullable(root);
        if (optionalRoot.isEmpty()) return Optional.empty();
        return Optional.of(EducationEntity.builder()
                .uuid(root.getRootID().getAbsoluteID())
                .resume(ResumeEntity.referenceOf(root.getResumeID().getAbsoluteID()))
                .version(root.getVersionValue())
                .rowStatus(root.getRowStatus())
                .processStatus(root.getProcessStatus())
                .accessModifier(root.getAccessModifier())
                .cityId(root.getCityId())
                .establishmentUUID(root.getEstablishmentUUID())
                .establishmentName(root.getEstablishmentName())
                .orderNumber(root.getOrderNumber())
                .startDate(root.getStartDate())
                .endDate(root.getEndDate())
                .description(root.getDescription())
                .link(root.getLink())
                .state(root.getState())
                .degree(root.getDegree())
                .build());
    }


    @Override
    public Optional<EducationRoot> composeToRoot(EducationCompose educationCompose) {
        var optionalEducationCompose = Optional.ofNullable(educationCompose);
        return optionalEducationCompose.map(compose -> EducationRoot.Builder.builder()
                .uuid(EducationID.of(compose.getUuid()))
                .resume(ResumeID.of(compose.getResumeUuid()))
                .version(Version.of(compose.getVersion()))
                .rowStatus(RowStatus.valueOf(compose.getRowStatus()))
                .processStatus(ProcessStatus.of(compose.getProcessStatus()))
                .createdDate(GDateTime.of(compose.getCreatedDate()))
                .lastModifiedDate(GDateTime.of(compose.getModificationDate()))
                .accessModifier(AccessModifier.valueOf(compose.getAccessModifier()))
                .cityId((UUID) compose.getCityId())
                .establishmentUUID((UUID) compose.getEstablishmentUuid())
                .establishmentName(compose.getEstablishmentName())
                .orderNumber(compose.getOrderNumber())
                .startDate(GDateTime.convertToLocalDate(compose.getStartDate()))
                .endDate(GDateTime.convertToLocalDate(compose.getEndDate()))
                .description(compose.getDescription())
                .link(compose.getLink())
                .state(EducationState.valueOf(compose.getState()))
                .degree(EducationDegree.valueOf(compose.getDegree()))
                .build());
    }


}
