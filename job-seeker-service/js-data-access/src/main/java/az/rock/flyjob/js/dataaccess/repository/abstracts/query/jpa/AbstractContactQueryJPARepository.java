package az.rock.flyjob.js.dataaccess.repository.abstracts.query.jpa;

import az.rock.flyjob.js.dataaccess.model.entity.resume.details.ContactEntity;
import az.rock.flyjob.js.domain.core.root.detail.ContactRoot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface AbstractContactQueryJPARepository extends JpaRepository<ContactEntity, UUID> {

    @Query("SELECT count(row) > 0 FROM ContactEntity row " +
            "WHERE (:resume = row.resume) and (row.rowStatus = 'ACTIVE')")
    Boolean existByContact(ContactRoot resume);

    @Query("SELECT  e FROM ContactEntity  e WHERE e.resume.uuid=:resume AND e.uuid=:uuid AND e.rowStatus='ACTIVE'")
    Optional<ContactEntity> findResumeIAndContactID(@Param(value = "resume") UUID resume, @Param(value = "uuid") UUID uuid);

    @Query("SELECT e FROM ContactEntity e WHERE e.resume.uuid = :resumeID AND e.rowStatus = 'ACTIVE' order by e.orderNumber")
    Optional<ContactEntity> findByPID(@Param("resumeID") UUID resumeID);

    @Query("SELECT e FROM ContactEntity e WHERE e.uuid = :contactId AND e.rowStatus = 'ACTIVE'")
    Optional<ContactEntity> findById(@Param("contactId") UUID contactId);

    @Query("SELECT e FROM ContactEntity e WHERE e.resume.uuid = :resumeID AND e.rowStatus = 'ACTIVE' order by e.orderNumber")
    List<ContactEntity> findAll(@Param("resumeID") UUID resumeID);

}
