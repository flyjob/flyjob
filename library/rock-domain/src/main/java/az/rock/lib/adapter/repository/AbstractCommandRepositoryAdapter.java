package az.rock.lib.adapter.repository;

import az.rock.lib.annotation.DomainOutputPort;
import az.rock.lib.domain.RootID;
import az.rock.lib.jexception.UnsupportedOperationJException;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@DomainOutputPort
public interface AbstractCommandRepositoryAdapter<R> {
    Optional<R> create(R root);

    default void update(R root){
        throw new UnsupportedOperationJException("Update");
    }

    default void delete(R root){
        throw new UnsupportedOperationJException("Delete");
    }

    default void updateAll(List<R> emailRoots){
        throw new UnsupportedOperationJException("Update All");
    }

    default void inActive(R root) {
        throw new UnsupportedOperationJException("Inactive");
    }

    default void deleteAll(List<R> roots) {
        throw new UnsupportedOperationJException("Delete All");
    }

    default void rollback(Collection<R> roots) {
        roots.forEach(this::rollback);
    }

    default void rollback(R root) {
        throw new UnsupportedOperationException("Rollback");
    }
}
