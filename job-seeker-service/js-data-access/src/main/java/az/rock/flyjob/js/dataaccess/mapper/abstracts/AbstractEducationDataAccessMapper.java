package az.rock.flyjob.js.dataaccess.mapper.abstracts;

import az.rock.flyjob.js.dataaccess.model.batis.model.EducationCompose;
import az.rock.flyjob.js.dataaccess.model.entity.resume.details.EducationEntity;
import az.rock.flyjob.js.domain.core.root.detail.EducationRoot;
import com.intellibucket.lib.fj.dataaccess.AbstractDataAccessMapper;

import java.util.Optional;


public interface AbstractEducationDataAccessMapper extends AbstractDataAccessMapper<EducationEntity, EducationRoot> {
    Optional<EducationRoot> composeToRoot(EducationCompose educationCompose);

}
