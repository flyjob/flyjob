package az.rock.flyjob.js.dataaccess.mapper.abstracts;

import az.rock.flyjob.js.dataaccess.model.batis.model.ExperienceCompose;
import az.rock.flyjob.js.dataaccess.model.entity.resume.details.ExperienceEntity;
import az.rock.flyjob.js.domain.core.root.detail.ExperienceRoot;
import com.intellibucket.lib.fj.dataaccess.AbstractDataAccessMapper;

import java.util.Optional;

public interface AbstractExperienceDataAccessMapper extends AbstractDataAccessMapper<ExperienceEntity, ExperienceRoot> {
    Optional<ExperienceRoot> toRoot(ExperienceCompose compose);
}
