package az.rock.flyjob.js.dataaccess.adapter.command.detail;

import az.rock.flyjob.js.dataaccess.mapper.abstracts.AbstractCourseDataAccessMapper;
import az.rock.flyjob.js.dataaccess.repository.abstracts.command.custom.detail.AbstractCourseCustomCommandJPARepository;
import az.rock.flyjob.js.dataaccess.repository.concretes.command.custom.detail.CourseCustomCommandJPARepository;
import az.rock.flyjob.js.domain.core.root.detail.CourseRoot;
import az.rock.flyjob.js.domain.presentation.ports.output.repository.command.AbstractCourseCommandRepositoryAdapter;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Component
public class CourseCommandRepositoryAdapter implements AbstractCourseCommandRepositoryAdapter {

    private final AbstractCourseDataAccessMapper abstractCourseDataAccessMapper;

    private final AbstractCourseCustomCommandJPARepository customCommandJPARepository;


    public CourseCommandRepositoryAdapter(AbstractCourseDataAccessMapper abstractCourseDataAccessMapper, CourseCustomCommandJPARepository customCommandJPARepository) {
        this.abstractCourseDataAccessMapper = abstractCourseDataAccessMapper;
        this.customCommandJPARepository = customCommandJPARepository;
    }

    @Override
    public Optional<CourseRoot> create(CourseRoot root) {
        var optional = this.abstractCourseDataAccessMapper.toEntity(root);
        if(optional.isEmpty())return Optional.empty();
        var courseEntity = optional.get();
        return this.abstractCourseDataAccessMapper.toRoot(
                customCommandJPARepository.persist(courseEntity)
        );
    }
    @Override
    public void update(CourseRoot root) {
        var optional = this.abstractCourseDataAccessMapper.toEntity(root);
        optional.ifPresent(this.customCommandJPARepository::merge);
    }

    @Override
    public void delete(CourseRoot root) {
        var optional = this.abstractCourseDataAccessMapper.toEntity(root);
        optional.ifPresent(this.customCommandJPARepository::delete);
    }

    @Override
    public void updateAll(List<CourseRoot> roots) {
        var rootList = roots
                .stream()
                .map(this.abstractCourseDataAccessMapper::toEntity)
                .filter(Optional::isPresent)
                .map(Optional::get)
                .toList();
        this.customCommandJPARepository.updateAll(rootList);
    }


}
