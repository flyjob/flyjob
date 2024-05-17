package az.rock.flyjob.js.dataaccess.mapper.concretes;

import az.rock.flyjob.js.dataaccess.mapper.abstracts.AbstractContactDataAccessMapper;
import az.rock.flyjob.js.dataaccess.model.entity.resume.ResumeEntity;
import az.rock.flyjob.js.dataaccess.model.entity.resume.details.ContactEntity;
import az.rock.flyjob.js.domain.core.root.detail.ContactRoot;
import az.rock.lib.domain.id.js.ContactID;
import az.rock.lib.domain.id.js.ResumeID;
import az.rock.lib.util.GDateTime;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class ContactDataAccessMapper implements AbstractContactDataAccessMapper {
    @Override
    public Optional<ContactRoot> toRoot(ContactEntity entity) {
        var optionalEntity = Optional.ofNullable(entity);
        if (optionalEntity.isEmpty()) return Optional.empty();
        return Optional.of(ContactRoot.Builder
                .builder()
                .id(ContactID.of(entity.getUuid()))
                .accessModifier(entity.getAccessModifier())
                .formatType(entity.getFormatType())
                .data(entity.getData())
                .version(entity.getVersion())
                .processStatus(entity.getProcessStatus())
                .createdDate(GDateTime.toZonedDateTime(entity.getCreatedDate()))
                .liveType(entity.getLiveType())
                .orderNumber(entity.getOrderNumber())
                .resume(ResumeID.of(entity.getResume().getUuid()))
                .lastModifiedDate(GDateTime.toZonedDateTime(entity.getLastModifiedDate()))
                .orderNumber(entity.getOrderNumber())
                .rowStatus(entity.getRowStatus())
                .build()
        );
    }


    @Override
    public Optional<ContactEntity> toEntity(ContactRoot root) {
        return Optional.of(ContactEntity.Builder
                .builder()
                .uuid(root.getRootID().getAbsoluteID())
                .rowStatus(root.getRowStatus())
                .processStatus(root.getProcessStatus())
                .accessModifier(root.getAccessModifier())
                .createdDate(GDateTime.toTimestamp(root.getCreatedDate()))
                .lastModifiedDate(GDateTime.toTimestamp(root.getModificationDate()))
                .formatType(root.getFormatType())
                .data(root.getData())
                .liveType(root.getLiveType())
                .orderNumber(root.getOrderNumber())
                .version(root.getVersionValue())
                .data(root.getData())
                .resume(ResumeEntity.referenceOf(root.getResume().getRootID()))
                .build());

    }
}

