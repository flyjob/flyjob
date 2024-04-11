package az.rock.flyjob.js.dataaccess.mapper.concretes;

import az.rock.flyjob.js.dataaccess.mapper.abstracts.AbstractPersonalSummaryDataAccessMapper;
import az.rock.flyjob.js.dataaccess.model.entity.resume.details.PersonalSummaryEntity;
import az.rock.flyjob.js.domain.core.root.detail.PersonalSummaryRoot;
import az.rock.lib.domain.BaseEntity;
import az.rock.lib.domain.id.js.PersonalSummaryID;
import az.rock.lib.domain.id.js.ResumeID;
import az.rock.lib.util.GDateTime;
import az.rock.lib.valueObject.Version;

import java.util.Optional;

public class PersonalSummaryDataAccessMapper implements AbstractPersonalSummaryDataAccessMapper {
    @Override
    public Optional<PersonalSummaryRoot> toRoot(PersonalSummaryEntity entity) {
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

    @Override
    public Optional<PersonalSummaryEntity> toEntity(PersonalSummaryRoot root) {
        //resumeId gelecek bura


       return Optional.ofNullable(PersonalSummaryEntity.Builder.builder()
                       .uuid(root.getRootID().getAbsoluteID())
                       .resume(root.getResume())
                       .rowStatus(root.getRowStatus())
                       .version(root.getVersionValue()).build()


               );


    }
}
