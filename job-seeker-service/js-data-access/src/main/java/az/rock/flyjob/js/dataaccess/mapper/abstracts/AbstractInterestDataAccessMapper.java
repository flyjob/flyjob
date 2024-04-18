package az.rock.flyjob.js.dataaccess.mapper.abstracts;

import az.rock.flyjob.js.dataaccess.model.batis.model.InterestCompose;
import az.rock.flyjob.js.dataaccess.model.entity.resume.details.InterestEntity;
import az.rock.flyjob.js.domain.core.root.detail.InterestRoot;
import com.intellibucket.lib.fj.dataaccess.AbstractDataAccessMapper;

import java.util.Optional;

public interface AbstractInterestDataAccessMapper extends AbstractDataAccessMapper<InterestEntity, InterestRoot> {
    Optional<InterestRoot> toRoot(InterestCompose compose);
}
