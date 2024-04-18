package az.rock.flyjob.js.dataaccess.model.entity.resume.details;

import az.rock.flyjob.js.dataaccess.model.entity.resume.ResumeEntity;
import az.rock.lib.domain.BaseEntity;
import az.rock.lib.util.GDateTime;
import az.rock.lib.valueObject.AccessModifier;
import az.rock.lib.valueObject.ProcessStatus;
import az.rock.lib.valueObject.RowStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;
import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "courses", schema = "resume", indexes = {
        @Index(name = "idx_courseentity_resume_uuid", columnList = "resume_uuid, accessModifier")
})
@Entity(name = "CourseEntity")
public class CourseEntity extends BaseEntity {
    @ManyToOne
    private ResumeEntity resume;

    @Column(length = 32, columnDefinition = "varchar(32) default 'AUTHENTICATED'")
    @Enumerated(EnumType.STRING)
    private AccessModifier accessModifier;

    @Column(name = "order_number",nullable = false)
    private Integer orderNumber;

    @Column(name = "course_title", nullable = false)
    private String courseTitle;

    @Column(name = "institution", nullable = false)
    private String institution;

    @Column(name = "is_online", nullable = false)
    private Boolean isOnline;

    @Column(name = "city")
    private String city;

    @Column(name = "country")
    private String country;

    @Column(name = "start_date", columnDefinition = "DATE")
    private LocalDate startDate;

    @Column(name = "end_date", columnDefinition = "DATE")
    private LocalDate endDate;

    @Column(name = "is_continue")
    private String description;

    @Column(name = "certificate_file_path")
    private String certificateFilePath;

    @Column(name = "verification_address")
    private String verificationAddress;


    public CourseEntity(Builder builder) {
        setUuid(builder.uuid);
        setVersion(builder.version);
        setCreatedDate(builder.createdDate);
        setLastModifiedDate(builder.lastModifiedDate);
        setProcessStatus(builder.processStatus);
        setRowStatus(builder.rowStatus);
        setResume(builder.resume);
        setAccessModifier(builder.accessModifier);
        setOrderNumber(builder.orderNumber);
        setCourseTitle(builder.courseTitle);
        setInstitution(builder.institution);
        setIsOnline(builder.isOnline);
        setCity(builder.city);
        setCountry(builder.country);
        setStartDate(builder.startDate);
        setEndDate(builder.endDate);
        setDescription(builder.description);
        setCertificateFilePath(builder.certificateFilePath);
        setVerificationAddress(builder.verificationAddress);
    }


    public static final class Builder{

        private UUID uuid;
        private Long version;
        private Timestamp createdDate;
        private Timestamp lastModifiedDate;
        private ProcessStatus processStatus;
        private RowStatus rowStatus;
        private ResumeEntity resume;
        private AccessModifier accessModifier;
        private Integer orderNumber;
        private String courseTitle;
        private String institution;
        private Boolean isOnline;
        private String city;
        private String country;
        private LocalDate startDate;
        private LocalDate endDate;
        private String description;
        private String certificateFilePath;
        private String verificationAddress;

        public Builder() {
        }

        public static Builder builder(){
            return new Builder();
        }

        public Builder setUuid(UUID uuid) {
            this.uuid = uuid;
            return this;
        }

        public Builder setVersion(Long version) {
            this.version = version;
            return this;
        }

        public Builder setCreatedDate(Timestamp createdDate) {
            this.createdDate = createdDate;
            return this;
        }

        public Builder setLastModifiedDate(Timestamp lastModifiedDate) {
            this.lastModifiedDate = lastModifiedDate;
            return this;
        }

        public Builder setProcessStatus(ProcessStatus processStatus) {
            this.processStatus = processStatus;
            return this;
        }

        public Builder setRowStatus(RowStatus rowStatus) {
            this.rowStatus = rowStatus;
            return this;
        }

        public Builder setResume(ResumeEntity resume) {
            this.resume = resume;
            return this;
        }

        public Builder setAccessModifier(AccessModifier accessModifier) {
            this.accessModifier = accessModifier;
            return this;
        }

        public Builder setOrderNumber(Integer orderNumber) {
            this.orderNumber = orderNumber;
            return this;
        }

        public Builder setCourseTitle(String courseTitle) {
            this.courseTitle = courseTitle;
            return this;
        }

        public Builder setInstitution(String institution) {
            this.institution = institution;
            return this;
        }

        public Builder setIsOnline(Boolean isOnline) {
            this.isOnline = isOnline;
            return this;
        }

        public Builder setCity(String city) {
            this.city = city;
            return this;
        }

        public Builder setCountry(String country) {
            this.country = country;
            return this;
        }

        public Builder setStartDate(LocalDate startDate) {
            this.startDate = startDate;
            return this;
        }

        public Builder setEndDate(LocalDate endDate) {
            this.endDate = endDate;
            return this;
        }

        public Builder setDescription(String description) {
            this.description = description;
            return this;
        }

        public Builder setCertificateFilePath(String certificateFilePath) {
            this.certificateFilePath = certificateFilePath;
            return this;
        }

        public Builder setVerificationAddress(String verificationAddress) {
            this.verificationAddress = verificationAddress;
            return this;
        }


        public CourseEntity build() {
            return new CourseEntity(this);
        }
    }
}
