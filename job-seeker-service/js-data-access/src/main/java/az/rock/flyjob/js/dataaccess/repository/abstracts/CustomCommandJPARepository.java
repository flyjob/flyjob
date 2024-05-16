package az.rock.flyjob.js.dataaccess.repository.abstracts;

import az.rock.lib.domain.BaseEntity;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.hibernate.Session;
import org.hibernate.engine.jdbc.spi.JdbcServices;
import org.hibernate.engine.spi.SessionFactoryImplementor;
import org.hibernate.internal.AbstractSharedSessionContract;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

@NoRepositoryBean
@Transactional
public interface CustomCommandJPARepository<T extends BaseEntity> {

    EntityManager entityManager();

    default Session session() {
        return this.entityManager().unwrap(Session.class);
    }

    default void flush() {
        this.entityManager().flush();
    }

    <S extends T> S persist(S entity);

    default <S extends T> S persistAndFlush(S entity) {
        var savedEntity = this.persist(entity);
        this.flush();
        return savedEntity;
    }

    default <S extends T> List<S> persistAll(Iterable<S> entities){
        return this.executeBatch(this.session(), () -> {
            List<S> result = new ArrayList<>();
            entities.forEach(entity -> result.add(this.persist(entity)));
            return result;
        });
    }

    default <S extends T> List<S> persistAllAndFlush(Iterable<S> entities) {
        return this.executeBatch(this.session(), () -> {
            List<S> result = new ArrayList<>();
            entities.forEach(entity -> result.add(this.persist(entity)));
            this.flush();
            return result;
        });
    }

    default <S extends T> void inActive(S entity) {
        entity.inActive();
        this.merge(entity);
    }

    default <S extends T> void rollback(S entity) {
        entity.rollback();
        this.merge(entity);
    }

    default <S extends T> void rollbackAndFlush(S entity) {
        this.rollback(entity);
        this.flush();
    }

    default <S extends T> void inActiveAndFlush(S entity) {
        this.inActive(entity);
        this.flush();
    }

    default <S extends T> void inActiveAll(Iterable<S> entities) {
        this.executeBatch(this.session(), () -> {
            entities.forEach(this::inActive);
            return null;
        });
    }

    default <S extends T> void inActiveAllAndFlush(Iterable<S> entities) {
        this.executeBatch(this.session(), () -> {
            entities.forEach(this::inActive);
            this.flush();
            return null;
        });
    }


    default <S extends T> void delete(S entity) {
        entity.delete();
        this.merge(entity);
    }

    default <S extends T> void deleteAndFlush(S entity) {
        this.delete(entity);
        this.flush();
    }

    default <S extends T> void deleteAll(Iterable<S> entities) {
        this.executeBatch(this.session(), () -> {
            entities.forEach(this::delete);
            return null;
        });
    }

    default <S extends T> void deleteAllAndFlush(Iterable<S> entities) {
        this.executeBatch(this.session(), () -> {
            entities.forEach(this::delete);
            this.flush();
            return null;
        });
    }


    <S extends T> S merge(S entity);

    default <S extends T> S mergeAndFlush(S entity){
        var savedEntity = this.merge(entity);
        this.flush();
        return savedEntity;
    }

    default <S extends T> List<S> mergeAll(Iterable<S> entities){
        return this.executeBatch(this.session(), () -> {
            List<S> result = new ArrayList<>();
            entities.forEach(entity -> result.add(this.merge(entity)));
            return result;
        });
    }

    default <S extends T> List<S> mergeAllAndFlush(Iterable<S> entities){
        return this.executeBatch(this.session(), () -> {
            List<S> result = new ArrayList<>();
            entities.forEach(entity -> result.add(this.merge(entity)));
            this.flush();
            return result;
        });
    }

    default <S extends T> S update(S entity){
        return this.merge(entity);
    }

    default <S extends T> S updateAndFlush(S entity){
        return this.mergeAndFlush(entity);
    }

    default <S extends T> List<S> updateAll(Iterable<S> entities){
        return this.mergeAll(entities);
    }

    default <S extends T> List<S> updateAllAndFlush(Iterable<S> entities){
        return this.mergeAllAndFlush(entities);
    }

    default Integer getBatchSize(Session session) {
        var sessionFactory = session.getSessionFactory().unwrap(SessionFactoryImplementor.class);
        try {
            final var jdbcServices = sessionFactory.getServiceRegistry().getService(JdbcServices.class);
            var isSupportsBatchUpdates = jdbcServices.getExtractedMetaDataSupport().supportsBatchUpdates();
            if (!isSupportsBatchUpdates) return Integer.MIN_VALUE;
            return session.unwrap(AbstractSharedSessionContract.class).getConfiguredJdbcBatchSize();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    default  <R> R executeBatch(Session session,Supplier<R> callback) {
        var isOpen = session.isOpen();
        Integer jdbcBatchSize = this.getBatchSize(session);
        Integer originalSessionBatchSize = session.getJdbcBatchSize();
        try {
            if (jdbcBatchSize == null) session.setJdbcBatchSize(10);
            return callback.get();
        } finally {
            session.setJdbcBatchSize(originalSessionBatchSize);
        }
    }

    default <R> void callBatch(Session session, Runnable callback) {
        Integer jdbcBatchSize = this.getBatchSize(session);
        Integer originalSessionBatchSize = session.getJdbcBatchSize();
        try {
            if (jdbcBatchSize == null) session.setJdbcBatchSize(10);
            callback.run();
        } finally {
            session.setJdbcBatchSize(originalSessionBatchSize);
        }
    }
}