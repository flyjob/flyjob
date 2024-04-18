package az.rock.flyjob.js.dataaccess.mapper.abstracts;

import az.rock.flyjob.js.dataaccess.model.batis.model.CourseCompose;
import az.rock.flyjob.js.dataaccess.model.entity.resume.details.CourseEntity;
import az.rock.flyjob.js.domain.core.root.detail.CourseRoot;
import com.intellibucket.lib.fj.dataaccess.AbstractDataAccessMapper;

import java.util.Optional;

public interface AbstractCourseDataAccessMapper extends AbstractDataAccessMapper<CourseEntity, CourseRoot> {
    Optional<CourseRoot> toRoot(CourseCompose compose);
}
