package az.rock.flyjob.js.dataaccess.mapper.concretes;

import az.rock.flyjob.js.dataaccess.mapper.abstracts.AbstractInformationDataAccessMapper;
import az.rock.flyjob.js.dataaccess.mapper.abstracts.AbstractResumeDataAccessMapper;
import az.rock.flyjob.js.dataaccess.model.entity.resume.ResumeEntity;
import az.rock.flyjob.js.dataaccess.model.entity.resume.main.InformationEntity;
import az.rock.flyjob.js.domain.core.root.ResumeRoot;
import az.rock.flyjob.js.domain.core.root.main.InformationRoot;
import az.rock.lib.domain.id.js.ResumeID;
import az.rock.lib.util.GDateTime;
import az.rock.lib.valueObject.Version;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.UUID;

@Component
public class ResumeDataAccessMapper implements AbstractResumeDataAccessMapper {
    private final AbstractInformationDataAccessMapper informationDataAccessMapper;

    public ResumeDataAccessMapper(AbstractInformationDataAccessMapper informationDataAccessMapper) {
        this.informationDataAccessMapper = informationDataAccessMapper;
    }


    @Override
    public Optional<ResumeRoot> toRoot(ResumeEntity entity) {
        var optionalEntity = Optional.ofNullable(entity);
        if (optionalEntity.isPresent()) {
            var safetyResumeEntity = optionalEntity.get();
            var informationRoot = this.informationDataAccessMapper
                    .toRoot(safetyResumeEntity.getInformation());
            return Optional.of(
                    ResumeRoot.Builder
                            .builder()
                            .resumeID(ResumeID.of(safetyResumeEntity.getUuid()))
                            .processStatus(safetyResumeEntity.getProcessStatus())
                            .rowStatus(safetyResumeEntity.getRowStatus())
                            .createdDate(GDateTime.toZonedDateTime(safetyResumeEntity.getCreatedDate()))
                            .lastModifiedDate(GDateTime.toZonedDateTime(safetyResumeEntity.getLastModifiedDate()))
                            .version(Version.of(safetyResumeEntity.getVersion()))
                            .information(informationRoot.orElse(InformationRoot.EMPTY))
                            .userId(entity.getUserId())
                            //TODO
                            .build()
            );
        } else return Optional.empty();
    }

    @Override
    public Optional<ResumeEntity> toEntity(ResumeRoot root) {
        var optionalResumeRoot = Optional.ofNullable(root);
        if (optionalResumeRoot.isPresent()) {
            var safetyResumeRoot = optionalResumeRoot.get();
            var informationEntity = this.informationDataAccessMapper
                    .toEntity(safetyResumeRoot.getInformation())
                    .orElse(InformationEntity.referenceOf(
                            UUID.randomUUID(),
                            safetyResumeRoot.getRootID().getAbsoluteID()
                    ));
            var resumeEntity = ResumeEntity.Builder
                    .builder()
                    .uuid(safetyResumeRoot.getRootID().getAbsoluteID())
                    .accessModifier(safetyResumeRoot.getAccessModifier())
                    .version(safetyResumeRoot.getVersion().value())
                    .processStatus(safetyResumeRoot.getProcessStatus())
                    .rowStatus(safetyResumeRoot.getRowStatus())
                    .createdDate(GDateTime.toTimestamp(safetyResumeRoot.getCreatedDate()))
                    .lastModifiedDate(GDateTime.toTimestamp(safetyResumeRoot.getModificationDate()))
                    .userId(safetyResumeRoot.getUserId())
                    //TODO tekrar duzelis olunmalidir.
                    .information(informationEntity)
                    .build();
            informationEntity.setResume(resumeEntity);
            return Optional.of(resumeEntity);
        } else return Optional.empty();
    }
}
