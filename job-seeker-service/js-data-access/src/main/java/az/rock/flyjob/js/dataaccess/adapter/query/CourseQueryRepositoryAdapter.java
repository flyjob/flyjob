package az.rock.flyjob.js.dataaccess.adapter.query;

import az.rock.flyjob.js.dataaccess.mapper.abstracts.AbstractCourseDataAccessMapper;
import az.rock.flyjob.js.dataaccess.mapper.abstracts.AbstractPageableDataAccessMapper;
import az.rock.flyjob.js.dataaccess.model.batis.model.CourseComposeExample;
import az.rock.flyjob.js.dataaccess.repository.abstracts.query.batis.CourseBatisRepository;
import az.rock.flyjob.js.dataaccess.repository.abstracts.query.jpa.AbstractCourseQueryJPARepository;
import az.rock.flyjob.js.domain.core.root.detail.CourseRoot;
import az.rock.flyjob.js.domain.presentation.dto.criteria.CourseCriteria;
import az.rock.flyjob.js.domain.presentation.ports.output.repository.query.AbstractCourseQueryRepositoryAdapter;
import az.rock.lib.domain.id.js.CourseID;
import az.rock.lib.domain.id.js.ResumeID;
import az.rock.lib.valueObject.AccessModifier;
import az.rock.lib.valueObject.SimplePageableRequest;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;


@Component
public class CourseQueryRepositoryAdapter implements AbstractCourseQueryRepositoryAdapter {

    private final AbstractCourseQueryJPARepository courseQueryJPARepository;

    private final CourseBatisRepository courseQueryBatisRepository;
    private final AbstractCourseDataAccessMapper courseDataAccessMapper;

    private final AbstractPageableDataAccessMapper pageableDataAccessMapper;

    public CourseQueryRepositoryAdapter(AbstractCourseQueryJPARepository courseQueryJPARepository, CourseBatisRepository courseQueryBatisRepository, AbstractCourseDataAccessMapper courseDataAccessMapper, AbstractPageableDataAccessMapper pageableDataAccessMapper) {
        this.courseQueryJPARepository = courseQueryJPARepository;
        this.courseQueryBatisRepository = courseQueryBatisRepository;
        this.courseDataAccessMapper = courseDataAccessMapper;
        this.pageableDataAccessMapper = pageableDataAccessMapper;
    }

    @Override
    public Boolean existsByEquality(CourseRoot root) {
        return courseQueryJPARepository.existsByEquality(root.getCourseTitle(), root.getResume().getRootID(),root.getRootID().getRootID());
    }

    @Override
    public Optional<CourseRoot> findById(CourseID courseID,ResumeID resumeID,List<AccessModifier> accessModifiers){
        var courseEntity = courseQueryJPARepository.findById(courseID.getRootID(),resumeID.getRootID(),accessModifiers);
        if(courseEntity.isEmpty())return Optional.empty();
        return courseDataAccessMapper.toRoot(courseEntity.get());
    }

    @Override
    public List<CourseRoot> findAllByResume(ResumeID resumeID,List<AccessModifier> accessModifiers) {
        var courses = courseQueryJPARepository.findAllByResume(resumeID.getRootID(),accessModifiers);
        return courses.stream()
                .map(courseDataAccessMapper::toRoot)
                .filter(Optional::isPresent)
                .map(Optional::get)
                .toList();
    }

    @Override
    public Boolean isInLimit(Long limit,ResumeID resumeId) {
        return courseQueryJPARepository.isInLimit(limit,resumeId.getRootID());
    }

    @Override
    public List<CourseRoot> fetchAllCourses(CourseCriteria criteria, SimplePageableRequest pageableRequest) {
        var courseComposeExample = CourseComposeExample.of(criteria,"order_number",pageableDataAccessMapper.toBatisPageable(pageableRequest));
        return courseQueryBatisRepository.selectByExample(courseComposeExample)
                .stream()
                .map(courseDataAccessMapper::toRoot)
                .filter(Optional::isPresent)
                .map(Optional::get)
                .toList();
    }

    @Override
    public Optional<CourseRoot> fetchCourseById(CourseCriteria criteria) {
        var courseComposeExample = CourseComposeExample.of(criteria);
        return Optional.ofNullable(courseQueryBatisRepository.selectFirstByExample(courseComposeExample))
                .map(courseDataAccessMapper::toRoot)
                .filter(Optional::isPresent)
                .map(Optional::get);
    }


}
