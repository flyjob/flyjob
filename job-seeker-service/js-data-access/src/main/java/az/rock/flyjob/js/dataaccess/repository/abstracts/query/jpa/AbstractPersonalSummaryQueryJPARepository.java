package az.rock.flyjob.js.dataaccess.repository.abstracts.query.jpa;

import az.rock.flyjob.js.dataaccess.model.entity.resume.details.PersonalSummaryEntity;
import az.rock.lib.valueObject.AccessModifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface AbstractPersonalSummaryQueryJPARepository extends JpaRepository<PersonalSummaryEntity, UUID> {
    @Query("select p from PersonalSummaryEntity p where p.resume.uuid=:resumeId  AND p.uuid=:summaryId AND p.accessModifier IN :access AND p.rowStatus='ACTIVE'")
    Optional<PersonalSummaryEntity> findSummaryByResumeIdAndSumId(@Param(value = "resumeId") UUID resumeID,@Param(value = "summaryId" ) UUID summaryId, @Param(value = "access") List<AccessModifier> modifierList);

    @Query("select p from PersonalSummaryEntity p where p.resume.uuid=:resumeId  AND p.rowStatus='ACTIVE'")
    Optional<PersonalSummaryEntity> findByResumeId(@Param(value = "resumeId") UUID resumeID);


}
