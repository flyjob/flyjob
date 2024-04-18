package az.rock.flyjob.js.dataaccess.repository.abstracts.query.jpa;

import az.rock.flyjob.js.dataaccess.model.entity.resume.details.CourseEntity;
import az.rock.flyjob.js.dataaccess.repository.abstracts.GJpaRepository;
import az.rock.lib.valueObject.AccessModifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface AbstractCourseQueryJPARepository extends GJpaRepository<CourseEntity, UUID> {
    @Query("SELECT COUNT(row) > 0 FROM CourseEntity row WHERE row.courseTitle = :title AND row.resume.uuid = :resume AND row.rowStatus = 'ACTIVE' AND row.uuid <> :course")
    Boolean existsByEquality(@Param("title") String title, @Param("resume") UUID resumeId, @Param("course") UUID courseId);

    @Query("SELECT c FROM CourseEntity c WHERE c.uuid=:id AND c.resume.uuid = :resume AND c.accessModifier in :access AND c.rowStatus = 'ACTIVE'")
    Optional<CourseEntity> findById(@Param("id") UUID id, @Param("resume") UUID resumeId,@Param("access") List<AccessModifier> accessModifier);

    @Query("SELECT c FROM CourseEntity c WHERE c.resume.uuid = :resume AND c.accessModifier in :access AND c.rowStatus = 'ACTIVE'")
    List<CourseEntity> findAllByResume(@Param("resume") UUID resume,@Param("access") List<AccessModifier> accessModifiers);

    @Query("SELECT COUNT(c) >= :limit FROM CourseEntity c WHERE c.rowStatus = 'ACTIVE' AND c.resume.uuid = :resume")
    Boolean isInLimit(@Param("limit") Long limit,@Param("resume") UUID resume);
}
