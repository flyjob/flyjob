package az.rock.flyjob.js.domain.core.root.detail;

import az.rock.lib.domain.AggregateRoot;
import az.rock.lib.domain.id.js.CourseID;
import az.rock.lib.domain.id.js.ResumeID;
import az.rock.lib.valueObject.AccessModifier;
import az.rock.lib.valueObject.ProcessStatus;
import az.rock.lib.valueObject.RowStatus;
import az.rock.lib.valueObject.Version;

import java.time.LocalDate;
import java.time.ZonedDateTime;


public class CourseRoot extends AggregateRoot<CourseID> {
    private ResumeID resume;
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

    public Boolean isVerified() {
        return verificationAddress != null;
    }

    private CourseRoot(Builder builder) {
        super(builder.id, builder.version, builder.processStatus, builder.rowStatus, builder.createdDate, builder.lastModifiedDate);
        this.accessModifier = builder.accessModifier;
        this.resume = builder.resume;
        this.orderNumber = builder.orderNumber;
        this.courseTitle = builder.courseTitle;
        this.institution = builder.institution;
        this.isOnline = builder.isOnline;
        this.city = builder.city;
        this.country = builder.country;
        this.startDate = builder.startDate;
        this.endDate = builder.endDate;
        this.description = builder.description;
        this.certificateFilePath = builder.certificateFilePath;
        this.verificationAddress = builder.verificationAddress;
    }

    public ResumeID getResume() {
        return resume;
    }

    public Integer getOrderNumber() {
        return orderNumber;
    }

    public String getCourseTitle() {
        return courseTitle;
    }

    public String getInstitution() {
        return institution;
    }

    public Boolean getOnline() {
        return isOnline;
    }

    public String getCity() {
        return city;
    }

    public String getCountry() {
        return country;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public String getDescription() {
        return description;
    }

    public String getCertificateFilePath() {
        return certificateFilePath;
    }

    public String getVerificationAddress() {
        return verificationAddress;
    }

    public AccessModifier getAccessModifier() {
        return accessModifier;
    }

    public CourseRoot changeCertificateFilePath(String certificateFilePath){
        this.certificateFilePath=certificateFilePath;
        return this;
    }

    public CourseRoot changeOrderNumber(Integer orderNumber){
        this.orderNumber = orderNumber;
        return this;
    }

    public static final class Builder {
        private CourseID id;
        private Version version;
        private ProcessStatus processStatus;
        private RowStatus rowStatus;
        private ZonedDateTime createdDate;
        private ZonedDateTime lastModifiedDate;

        private ResumeID resume;
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

        private Builder() {
        }

        public static Builder builder() {
            return new Builder();
        }

        public Builder id(CourseID val) {
            id = val;
            return this;
        }

        public Builder version(Version val) {
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

        public Builder createdDate(ZonedDateTime val) {
            createdDate = val;
            return this;
        }

        public Builder lastModifiedDate(ZonedDateTime val) {
            lastModifiedDate = val;
            return this;
        }

        public Builder accessModifier(AccessModifier accessModifier){
            this.accessModifier = accessModifier;
            return this;
        }


        public Builder resume(ResumeID val) {
            resume = val;
            return this;
        }

        public Builder orderNumber(Integer val) {
            orderNumber = val;
            return this;
        }

        public Builder courseTitle(String val) {
            courseTitle = val;
            return this;
        }

        public Builder institution(String val) {
            institution = val;
            return this;
        }

        public Builder isOnline(Boolean val) {
            isOnline = val;
            return this;
        }

        public Builder city(String val) {
            city = val;
            return this;
        }

        public Builder country(String val) {
            country = val;
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

        public Builder certificateFilePath(String val) {
            certificateFilePath = val;
            return this;
        }

        public Builder verificationAddress(String val) {
            verificationAddress = val;
            return this;
        }

        public CourseRoot build() {
            return new CourseRoot(this);
        }
    }


}
