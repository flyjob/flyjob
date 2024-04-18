package az.rock.flyjob.js.dataaccess.repository.abstracts;

import az.rock.lib.domain.BaseEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GJpaRepository<E extends BaseEntity, ID> extends JpaRepository<E, ID> {


    default void active(ID id) {
        var optionalEntity = this.findById(id);
        optionalEntity.ifPresent(BaseEntity::active);
    }


    default void deleteBySystem(ID id) {
        var optionalEntity = this.findById(id);
        optionalEntity.ifPresent((entity) -> {
            entity.inActive();
            this.save(entity);
        });
    }

    default void deleteByUser(ID id) {
        var optionalEntity = this.findById(id);
        optionalEntity.ifPresent((entity) -> {
            entity.delete();
            this.save(entity);
        });
    }

    default void rollback(ID id) {
        var optionalEntity = this.findById(id);
        optionalEntity.ifPresent((entity) -> {
            entity.rollback();
            this.save(entity);
        });
    }
}
