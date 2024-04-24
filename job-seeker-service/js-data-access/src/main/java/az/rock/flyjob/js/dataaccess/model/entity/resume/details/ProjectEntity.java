package az.rock.flyjob.js.dataaccess.model.entity.resume.details;

import az.rock.flyjob.js.dataaccess.model.entity.resume.ResumeEntity;
import az.rock.lib.domain.BaseEntity;
import az.rock.lib.valueObject.AccessModifier;
import az.rock.lib.valueObject.ProcessStatus;
import az.rock.lib.valueObject.RowStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "projects", schema = "resume", indexes = {
        @Index(name = "idx_projectentity_resume_uuid", columnList = "resume_uuid, accessModifier")
})
@Entity(name = "ProjectEntity")
public class ProjectEntity extends BaseEntity {
    @ManyToOne
    private ResumeEntity resume;

    @Column(length = 32, columnDefinition = "varchar(32) default 'AUTHENTICATED'")
    @Enumerated(EnumType.STRING)
    private AccessModifier accessModifier;

    @Column(name = "order_number",nullable = false)
    private Integer orderNumber;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "subtitle")
    private String subtitle;

    @Column(name = "link")
    private String link;

    private LocalDate startDate;

    private LocalDate endDate;

    @Column(name = "description")
    private String description;

    private ProjectEntity(Builder builder) {
        setResume(builder.resume);
        setAccessModifier(builder.accessModifier);
        setOrderNumber(builder.orderNumber);
        setTitle(builder.title);
        setSubtitle(builder.subtitle);
        setLink(builder.link);
        setStartDate(builder.startDate);
        setEndDate(builder.endDate);
        setDescription(builder.description);
        setUuid(builder.uuid);
        setVersion(builder.version);
        setProcessStatus(builder.processStatus);
        setRowStatus(builder.rowStatus);
        setCreatedDate(builder.createdDate);
        setLastModifiedDate(builder.lastModifiedDate);
    }

    public static final class Builder {
        private ResumeEntity resume;
        private AccessModifier accessModifier;
        private Integer orderNumber;
        private String title;
        private String subtitle;
        private String link;
        private LocalDate startDate;
        private LocalDate endDate;
        private String description;
        private UUID uuid;
        private Long version;
        private ProcessStatus processStatus;
        private RowStatus rowStatus;
        private Timestamp createdDate;
        private Timestamp lastModifiedDate;

        private Builder() {
        }

        public static Builder builder() {
            return new Builder();
        }

        public Builder resume(ResumeEntity val) {
            resume = val;
            return this;
        }

        public Builder accessModifier(AccessModifier val) {
            accessModifier = val;
            return this;
        }

        public Builder orderNumber(Integer val) {
            orderNumber = val;
            return this;
        }

        public Builder title(String val) {
            title = val;
            return this;
        }

        public Builder subtitle(String val) {
            subtitle = val;
            return this;
        }

        public Builder link(String val) {
            link = val;
            return this;
        }

        public Builder startDate(LocalDate val) {
            startDate = val;
            return this;
        }

        public Builder endDate(LocalDate val) {
            endDate = val;
            return this;
        }

        public Builder description(String val) {
            description = val;
            return this;
        }

        public Builder uuid(UUID val) {
            uuid = val;
            return this;
        }

        public Builder version(Long val) {
            version = val;
            return this;
        }

        public Builder processStatus(ProcessStatus val) {
            processStatus = val;
            return this;
        }

        public Builder rowStatus(RowStatus val) {
            rowStatus = val;
            return this;
        }

        public Builder createdDate(Timestamp val) {
            createdDate = val;
            return this;
        }

        public Builder lastModifiedDate(Timestamp val) {
            lastModifiedDate = val;
            return this;
        }

        public ProjectEntity build() {
            return new ProjectEntity(this);
        }
    }
}
