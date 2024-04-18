package az.rock.lib.domain;

import az.rock.lib.valueObject.ProcessStatus;
import az.rock.lib.valueObject.RowStatus;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.Date;
import java.util.UUID;

@MappedSuperclass
public class BaseEntity {
    @Id
    @Column(length = 36, updatable = false, nullable = false )
    private UUID uuid;

    @Version
    private Long version;

    @Enumerated(EnumType.STRING)
    @Column(name = "process_status", nullable = false)
    private ProcessStatus processStatus;

    @Enumerated(EnumType.STRING)
    @Column(name = "row_status", nullable = false)
    private RowStatus rowStatus;

    @CreationTimestamp
    @Column(name = "created_date", updatable = false, nullable = false)
    private Timestamp createdDate;

    @Column(name = "modification_date")
    @UpdateTimestamp
    private Timestamp lastModifiedDate;


    public void active() {
        this.rowStatus = RowStatus.ACTIVE;
    }

    public void inActive() {
        this.rowStatus = RowStatus.INACTIVE;
    }

    public void delete() {
        this.rowStatus = RowStatus.DELETED;
    }

    public void hide() {
        this.rowStatus = RowStatus.HIDDEN;
    }

    public void rollback() {
        this.rowStatus = RowStatus.ROLLBACK;
    }

    private BaseEntity(Builder builder) {
        setUuid(builder.uuid);
        setVersion(builder.version);
        setCreatedDate(builder.createdDate);
        setLastModifiedDate(builder.lastModifiedDate);
        processStatus = builder.processStatus;
        rowStatus = builder.rowStatus;
    }

    public boolean isNew() {
        return this.uuid == null;
    }


    public BaseEntity() {
    }


    public BaseEntity(UUID uuid,
                      Long version,
                      Timestamp createdDate,
                      Timestamp lastModifiedDate,
                      ProcessStatus processStatus,
                      RowStatus rowStatus) {
        this.uuid = uuid;
        this.version = version;
        this.createdDate = createdDate;
        this.lastModifiedDate = lastModifiedDate;
        this.processStatus = processStatus;
        this.rowStatus = rowStatus;
    }

    public void setCreatedDate(Timestamp createdDate) {
        this.createdDate = createdDate;
    }


    public void setLastModifiedDate(Timestamp lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

    public void setCreatedDate(Date createdDate) {
        if (createdDate != null)
            this.createdDate = Timestamp.from(createdDate.toInstant());
    }


    public void setLastModifiedDate(Date lastModifiedDate) {
        if (lastModifiedDate != null)
            this.lastModifiedDate = Timestamp.from(lastModifiedDate.toInstant());
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = Timestamp.valueOf(createdDate);
    }


    public void setLastModifiedDate(LocalDateTime lastModifiedDate) {
        this.lastModifiedDate = Timestamp.valueOf(lastModifiedDate);
    }

    public void setCreatedDate(ZonedDateTime createdDate) {
        this.createdDate = Timestamp.valueOf(createdDate.toLocalDateTime());
    }


    public void setLastModifiedDate(ZonedDateTime lastModifiedDate) {
        this.lastModifiedDate = Timestamp.valueOf(lastModifiedDate.toLocalDateTime());
    }

    public void setActive(RowStatus rowStatus) {
        this.rowStatus = rowStatus;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public void setStatus(ProcessStatus processStatus) {
        this.processStatus = processStatus;
    }

    public UUID getUuid() {
        return uuid;
    }

    public Long getVersion() {
        return version;
    }

    public Timestamp getCreatedDate() {
        return createdDate;
    }

    public Timestamp getLastModifiedDate() {
        return lastModifiedDate;
    }

    public RowStatus getRowStatus() {
        return this.rowStatus;
    }

    public ProcessStatus getProcessStatus() {
        return processStatus;
    }

    public void setRowStatus(RowStatus rowStatus) {
        this.rowStatus = rowStatus;
    }

    public void setProcessStatus(ProcessStatus processStatus) {
        this.processStatus = processStatus;
    }

    public static final class Builder {
        private UUID uuid;
        private Long version;
        private Timestamp createdDate;
        private Timestamp lastModifiedDate;
        private ProcessStatus processStatus;
        private RowStatus rowStatus;

        private Builder() {
        }

        public static Builder builder() {
            return new Builder();
        }

        public Builder uuid(UUID uuid) {
            this.uuid = uuid;
            return this;
        }

        public Builder version(Long version) {
            this.version = version;
            return this;
        }

        public Builder createdDate(Timestamp createdDate) {
            this.createdDate = createdDate;
            return this;
        }

        public Builder lastModifiedDate(Timestamp lastModifiedDate) {
            this.lastModifiedDate = lastModifiedDate;
            return this;
        }

        public Builder processStatus(ProcessStatus processStatus) {
            this.processStatus = processStatus;
            return this;
        }

        public Builder rowStatus(RowStatus rowStatus) {
            this.rowStatus = rowStatus;
            return this;
        }

        public Builder isActive(RowStatus rowStatus) {
            this.rowStatus = rowStatus;
            return this;
        }

        public BaseEntity build() {
            return new BaseEntity(this);
        }
    }
}