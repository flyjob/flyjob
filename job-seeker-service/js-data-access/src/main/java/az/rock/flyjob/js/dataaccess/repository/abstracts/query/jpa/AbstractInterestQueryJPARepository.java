package az.rock.flyjob.js.dataaccess.repository.abstracts.query.jpa;

import az.rock.flyjob.js.dataaccess.model.entity.resume.details.InterestEntity;
import az.rock.flyjob.js.domain.core.root.detail.InterestRoot;
import az.rock.lib.domain.id.js.InterestID;
import az.rock.lib.valueObject.AccessModifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface AbstractInterestQueryJPARepository extends JpaRepository<InterestEntity, UUID> {
    @Query("select i from InterestEntity i where i.resume.uuid=:resumeId AND i.accessModifier IN :access AND i.rowStatus='ACTIVE'")
    List<InterestEntity> findAllByResumeID(@Param(value = "resumeId") UUID resumeID,@Param(value = "access") List<AccessModifier> modifierList);


    @Query("select  i from InterestEntity  i where i.resume.uuid=:resumeId and i.uuid=:interestId and i.accessModifier in :access and i.rowStatus='ACTIVE' ")
    Optional<InterestEntity> findByResumeAndInterestId(@Param(value = "resumeId") UUID resumeID, @Param(value = "interestId") UUID interestID,@Param(value = "access") List<AccessModifier>modifierList);


    @Query("select count(i.name) from InterestEntity  i where i.resume.uuid=:resumeId AND i.rowStatus='ACTIVE'")
    Optional<Integer> limitCount(@Param(value = "resumeId") UUID resumeID);

    @Query("select i from InterestEntity i where i.uuid =: rootId and i.rowStatus='ACTIVE'")
    Optional<InterestEntity> findById(@Param(value = "rootId") InterestID rootId);
}
