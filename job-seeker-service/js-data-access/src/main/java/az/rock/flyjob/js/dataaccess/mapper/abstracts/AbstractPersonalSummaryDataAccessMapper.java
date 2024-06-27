package az.rock.flyjob.js.dataaccess.mapper.abstracts;

import az.rock.flyjob.js.dataaccess.model.entity.resume.details.PersonalSummaryEntity;
import az.rock.flyjob.js.domain.core.root.detail.PersonalSummaryRoot;
import com.intellibucket.lib.fj.dataaccess.AbstractDataAccessMapper;

import java.util.Optional;

public interface AbstractPersonalSummaryDataAccessMapper  extends AbstractDataAccessMapper<PersonalSummaryEntity, PersonalSummaryRoot> {
    Optional<PersonalSummaryRoot> toRoot(PersonalSummaryEntity entity);
    Optional<PersonalSummaryEntity> toEntity(PersonalSummaryRoot root);

}
