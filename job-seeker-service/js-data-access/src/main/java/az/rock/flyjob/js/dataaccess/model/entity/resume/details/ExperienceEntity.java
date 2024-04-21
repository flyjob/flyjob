package az.rock.flyjob.js.dataaccess.model.entity.resume.details;

import az.rock.flyjob.js.dataaccess.model.entity.resume.ResumeEntity;
import az.rock.lib.domain.BaseEntity;
import az.rock.lib.valueObject.*;
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
@Table(name = "experiences", schema = "resume", indexes = {
        @Index(name = "idx_experienceentity_resume_uuid", columnList = "resume_uuid, accessModifier")
})
@Entity(name = "ExperienceEntity")
public class ExperienceEntity extends BaseEntity {
    @ManyToOne
    private ResumeEntity resume;

    @Column(length = 32, columnDefinition = "varchar(32) default 'AUTHENTICATED'")
    @Enumerated(EnumType.STRING)
    private AccessModifier accessModifier;

    @Column(name = "order_number",nullable = false)
    private Integer orderNumber;

    @Column(name = "employer", nullable = false)
    private String employer;

    @Column(name = "link")
    private String link;

    @Column(name = "job_title", nullable = false)
    private String jobTitle;

    @Column(name = "city_id")
    private UUID cityId;

    @Enumerated(EnumType.STRING)
    private WorkingType workingType;

    @Enumerated(EnumType.STRING)
    private WorkingTimeLineType workingTimeType;

    @Column(name = "description")
    private String description;

    private LocalDate startDate;

    private LocalDate endDate;

    private ExperienceEntity(Builder builder) {
        setResume(builder.resume);
        setAccessModifier(builder.accessModifier);
        setOrderNumber(builder.orderNumber);
        setEmployer(builder.employer);
        setLink(builder.link);
        setJobTitle(builder.jobTitle);
        setCityId(builder.cityId);
        setWorkingType(builder.workingType);
        setWorkingTimeType(builder.workingTimeType);
        setDescription(builder.description);
        setStartDate(builder.startDate);
        setEndDate(builder.endDate);
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
        private String employer;
        private String link;
        private String jobTitle;
        private UUID cityId;
        private WorkingType workingType;
        private WorkingTimeLineType workingTimeType;
        private String description;
        private LocalDate startDate;
        private LocalDate endDate;
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

        public Builder employer(String val) {
            employer = val;
            return this;
        }

        public Builder link(String val) {
            link = val;
            return this;
        }

        public Builder jobTitle(String val) {
            jobTitle = val;
            return this;
        }

        public Builder cityId(UUID val) {
            cityId = val;
            return this;
        }

        public Builder workingType(WorkingType val) {
            workingType = val;
            return this;
        }

        public Builder workingTimeType(WorkingTimeLineType val) {
            workingTimeType = val;
            return this;
        }

        public Builder description(String val) {
            description = val;
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

        public ExperienceEntity build() {
            return new ExperienceEntity(this);
        }
    }
}
