package az.rock.flyjob.js.dataaccess.repository.abstracts.query.jpa;

import az.rock.flyjob.js.dataaccess.model.entity.resume.details.EducationEntity;
import az.rock.flyjob.js.dataaccess.model.entity.resume.details.ExperienceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface AbstractExperienceQueryJPARepository extends JpaRepository<ExperienceEntity, UUID> {
    @Query("SELECT e FROM ExperienceEntity e WHERE e.resume.uuid = :resumeID AND e.uuid = :experienceId AND e.rowStatus = 'ACTIVE'")
    Optional<ExperienceEntity> findByIdAndResumeIdAndRowStatusActive(@Param("resumeID") UUID resumeID, @Param("experienceId") UUID experienceId);

    @Query("SELECT e FROM ExperienceEntity e WHERE e.uuid = :experienceId AND e.rowStatus = 'ACTIVE'")
    Optional<ExperienceEntity> findById(@Param("experienceId") UUID experienceId);

    @Query("SELECT e FROM ExperienceEntity e WHERE e.resume.uuid = :resumeID AND e.rowStatus = 'ACTIVE' order by e.orderNumber")
    List<ExperienceEntity> findAllByPID(@Param("resumeID") UUID resumeID);

    @Query("SELECT e FROM ExperienceEntity e WHERE e.resume.uuid = :resumeID AND e.rowStatus = 'ACTIVE' AND e.uuid = :experienceId ")
    Optional<ExperienceEntity> findByOwnId(@Param("resumeID") UUID resumeID,@Param("experienceId") UUID experienceId);
}
