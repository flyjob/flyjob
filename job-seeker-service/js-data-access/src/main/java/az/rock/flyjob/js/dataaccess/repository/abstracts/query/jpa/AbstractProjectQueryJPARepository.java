package az.rock.flyjob.js.dataaccess.repository.abstracts.query.jpa;

import az.rock.flyjob.js.dataaccess.model.entity.resume.details.EducationEntity;
import az.rock.flyjob.js.dataaccess.model.entity.resume.details.ProjectEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface AbstractProjectQueryJPARepository extends JpaRepository<ProjectEntity, UUID> {
    @Query("SELECT e FROM ProjectEntity e WHERE e.resume.uuid = :resumeID AND e.uuid = :projectId AND e.rowStatus = 'ACTIVE'")
    Optional<ProjectEntity> findByIdAndResumeIdAndRowStatusActive(@Param("resumeID") UUID resumeID, @Param("projectId") UUID projectId);

    @Query("SELECT e FROM ProjectEntity e WHERE e.uuid = :projectId AND e.rowStatus = 'ACTIVE'")
    Optional<ProjectEntity> findById(@Param("projectId") UUID projectId);

    @Query("SELECT e FROM ProjectEntity e WHERE e.resume.uuid = :resumeID AND e.rowStatus = 'ACTIVE' order by e.orderNumber")
    List<ProjectEntity> findAll(@Param("resumeID") UUID resumeID);
}
