package az.rock.flyjob.js.dataaccess.mapper.concretes;

import az.rock.flyjob.js.dataaccess.mapper.abstracts.AbstractInterestDataAccessMapper;
import az.rock.flyjob.js.dataaccess.model.batis.model.InterestCompose;
import az.rock.flyjob.js.dataaccess.model.entity.resume.ResumeEntity;
import az.rock.flyjob.js.dataaccess.model.entity.resume.details.InterestEntity;
import az.rock.flyjob.js.domain.core.root.detail.InterestRoot;
import az.rock.lib.domain.id.js.InterestID;
import az.rock.lib.domain.id.js.ResumeID;
import az.rock.lib.util.GDateTime;
import az.rock.lib.valueObject.AccessModifier;
import az.rock.lib.valueObject.ProcessStatus;
import az.rock.lib.valueObject.RowStatus;
import az.rock.lib.valueObject.Version;
import org.springframework.stereotype.Component;

import java.time.ZoneId;
import java.util.Optional;

@Component
public class InterestDataAccessMapper implements AbstractInterestDataAccessMapper {
    @Override
    public Optional<InterestRoot> toRoot(InterestEntity entity) {
        var optionalEntity = Optional.ofNullable(entity);
        if (optionalEntity.isEmpty()) return Optional.empty();
        return Optional.of(InterestRoot.Builder
                .builder()
                .resume(ResumeID.of(entity.getResume().getUuid()))
                .id(InterestID.of(entity.getUuid()))
                .version(Version.of(entity.getVersion()))
                .rowStatus(entity.getRowStatus())
                .processStatus(entity.getProcessStatus())
                .createdDate(GDateTime.toZonedDateTime(
                        entity.getCreatedDate()
                ))
                .lastModifiedDate(GDateTime.toZonedDateTime(
                        entity.getLastModifiedDate()
                ))
                .accessModifier(entity.getAccessModifier())
                .name(entity.getName())
                        .description(entity.getDescription())
                .orderNumber(entity.getOrderNumber())
                        .isHobby(entity.getIsHobby())
                .build()
         );

    }

    @Override
    public Optional<InterestEntity> toEntity(InterestRoot root) {
        var optionalInterestRoot = Optional.ofNullable(root);
        if (optionalInterestRoot.isEmpty()) return Optional.empty();
            return Optional.of(
                    InterestEntity.Builder
                           .builder()
                            .uuid(root.getRootID().getAbsoluteID())
                            .processStatus(root.getProcessStatus())
                            .rowStatus(root.getRowStatus())
                            .version(root.getVersion().value())
                            .createdDate(
                                    GDateTime.toTimestamp(
                                            root.getCreatedDate()
                                    )
                            )
                            .lastModifiedDate(
                                    GDateTime.toTimestamp(
                                            root.getModificationDate()
                                    )
                            )
                            .resume(ResumeEntity.referenceOf(
                                    root.getResume().getAbsoluteID()
                            ))
                            .accessModifier(root.getAccessModifier())
                            .name(root.getName())
                            .description(root.getDescription())
                            .orderNumber(root.getOrderNumber())
                            .isHobby(root.getHobby())

                            .build()
            );

        }

    @Override
    public Optional<InterestRoot> toRoot(InterestCompose compose) {
        var optionalEntity = Optional.ofNullable(compose);
        if (optionalEntity.isEmpty()) return Optional.empty();
        return Optional.of(InterestRoot.Builder
                .builder()
                .resume(ResumeID.of(compose.getResumeUuid()))
                .id(InterestID.of(compose.getUuid()))
                .version(Version.of(compose.getVersion()))
                .rowStatus(RowStatus.valueOf(compose.getRowStatus()))
                .processStatus(ProcessStatus.valueOf(compose.getProcessStatus()))
                .createdDate(
                        compose.getCreatedDate().toInstant().atZone(ZoneId.systemDefault())
                )
                .lastModifiedDate(compose.getModificationDate().toInstant().atZone(ZoneId.systemDefault())
                )
                .accessModifier(AccessModifier.valueOf(compose.getAccessModifier()))
                .name(compose.getName())
                .description(compose.getDescription())
                .orderNumber(compose.getOrderNumber())
                .isHobby(compose.getIsHobby())
                .build()
        );
    }
}
