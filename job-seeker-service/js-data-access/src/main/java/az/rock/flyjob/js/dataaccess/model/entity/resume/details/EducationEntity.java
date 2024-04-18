package az.rock.flyjob.js.dataaccess.model.entity.resume.details;

import az.rock.flyjob.js.dataaccess.model.entity.resume.ResumeEntity;
import az.rock.lib.domain.BaseEntity;
import az.rock.lib.valueObject.AccessModifier;
import az.rock.lib.valueObject.ProcessStatus;
import az.rock.lib.valueObject.RowStatus;
import az.rock.lib.valueObject.js.EducationDegree;
import az.rock.lib.valueObject.js.EducationState;
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
@Table(name = "educations", schema = "resume", indexes = {
        @Index(name = "idx_educationentity_resume_uuid", columnList = "resume_uuid, accessModifier")
})
@Entity(name = "EducationEntity")
public class EducationEntity extends BaseEntity {
    @ManyToOne
    private ResumeEntity resume;

    @Column(length = 32, columnDefinition = "varchar(32) default 'AUTHENTICATED'")
    @Enumerated(EnumType.STRING)
    private AccessModifier accessModifier;

    @Column(name = "order_number",nullable = false)
    private Integer orderNumber;

    @Enumerated(EnumType.STRING)
    private EducationDegree degree;

    @Enumerated(EnumType.STRING)
    private EducationState state;

    @Column(name = "link")
    private String link;

    @Column(name = "establishment_uuid")
    private UUID establishmentUUID;

    @Column(name = "establishment_name", nullable = false)
    private String establishmentName;

    @Column(name = "city_id")
    private UUID cityId;

    @Column(name = "start_date", columnDefinition = "DATE")
    private LocalDate startDate;

    @Column(name = "end_date", columnDefinition = "DATE")
    private LocalDate endDate;

    @Column(name = "description")
    private String description;

    private EducationEntity(Builder builder) {
        setResume(builder.resume);
        setAccessModifier(builder.accessModifier);
        setOrderNumber(builder.orderNumber);
        setDegree(builder.degree);
        setState(builder.state);
        setLink(builder.link);
        setEstablishmentUUID(builder.establishmentUUID);
        setEstablishmentName(builder.establishmentName);
        setCityId(builder.cityId);
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

    public static Builder builder() {
        return new Builder();
    }

    public static final class Builder {
        private ResumeEntity resume;
        private AccessModifier accessModifier;
        private Integer orderNumber;
        private EducationDegree degree;
        private EducationState state;
        private String link;
        private UUID establishmentUUID;
        private String establishmentName;
        private UUID cityId;
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

        public Builder degree(EducationDegree val) {
            degree = val;
            return this;
        }

        public Builder state(EducationState val) {
            state = val;
            return this;
        }

        public Builder link(String val) {
            link = val;
            return this;
        }

        public Builder establishmentUUID(UUID val) {
            establishmentUUID = val;
            return this;
        }

        public Builder establishmentName(String val) {
            establishmentName = val;
            return this;
        }

        public Builder cityId(UUID val) {
            cityId = val;
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

        public EducationEntity build() {
            return new EducationEntity(this);
        }
    }
}
