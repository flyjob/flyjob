package az.rock.flyjob.js.dataaccess.repository.abstracts.command.custom.detail;

import az.rock.flyjob.js.dataaccess.model.entity.resume.details.EducationEntity;
import az.rock.flyjob.js.dataaccess.repository.abstracts.CustomCommandJPARepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AbstractCustomEducationCommandJpaRepository extends CustomCommandJPARepository<EducationEntity> {

}
