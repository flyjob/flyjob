package az.rock.flyjob.js.dataaccess.mapper.concretes;

import az.rock.flyjob.js.dataaccess.mapper.abstracts.AbstractPersonalSummaryDataAccessMapper;
import az.rock.flyjob.js.dataaccess.model.entity.resume.ResumeEntity;
import az.rock.flyjob.js.dataaccess.model.entity.resume.details.PersonalSummaryEntity;
import az.rock.flyjob.js.domain.core.root.detail.PersonalSummaryRoot;

import az.rock.lib.domain.id.js.PersonalSummaryID;
import az.rock.lib.domain.id.js.ResumeID;
import az.rock.lib.util.GDateTime;
import az.rock.lib.valueObject.Version;

import java.util.Optional;

public class PersonalSummaryDataAccessMapper implements AbstractPersonalSummaryDataAccessMapper {
    @Override
    public Optional<PersonalSummaryRoot> toRoot(PersonalSummaryEntity entity) {
        var optionalEntity = Optional.ofNullable(entity);
        if (optionalEntity.isEmpty()) {
            return Optional.ofNullable(PersonalSummaryRoot.Builder.builder()
                    .id(PersonalSummaryID.of(entity.getUuid()))
                    .resume(ResumeID.of(entity.getResume().getUuid()))
                    .summary(entity.getSummary())
                    .accessModifier(entity.getAccessModifier())
                    .createdDate(GDateTime.toZonedDateTime(
                            entity.getCreatedDate()))
                    .lastModifiedDate(GDateTime.toZonedDateTime
                            (entity.getLastModifiedDate()))
                    .processStatus(entity.getProcessStatus())
                    .version(Version.of(entity.getVersion().longValue()))
                    .rowStatus(entity.getRowStatus())
                    .build());
        }
        return Optional.empty();
    }

    @Override
    public Optional<PersonalSummaryEntity> toEntity(PersonalSummaryRoot root) {
        var optionalEntity = Optional.ofNullable(root);
        if (optionalEntity.isEmpty()) {
            return Optional.ofNullable(PersonalSummaryEntity.Builder.builder()
                    .uuid(root.getRootID().getAbsoluteID())
                    .resume(ResumeEntity.referenceOf(
                            root.getResume().getAbsoluteID()))
                    .rowStatus(root.getRowStatus())
                    .accessModifier(root.getAccessModifier())
                    .summary(root.getSummary())
                    .processStatus(root.getProcessStatus())
                    .createdDate(GDateTime.toTimestamp(
                            root.getCreatedDate()))
                    .lastModifiedDate(GDateTime.toTimestamp(
                            (root.getModificationDate())))

                    .version(root.getVersionValue())
                    .build()
            );
        }
        return Optional.empty();

    }
}
