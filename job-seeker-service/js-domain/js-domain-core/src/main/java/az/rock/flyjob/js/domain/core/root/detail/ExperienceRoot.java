package az.rock.flyjob.js.domain.core.root.detail;

import az.rock.lib.domain.AggregateRoot;
import az.rock.lib.domain.id.js.ExperienceID;
import az.rock.lib.domain.id.js.ResumeID;
import az.rock.lib.valueObject.*;

import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.util.UUID;


public class ExperienceRoot extends AggregateRoot<ExperienceID> {
    private ResumeID resume;
    private AccessModifier accessModifier;
    private Integer orderNumber;
    private String employer;
    private String link;
    private String jobTitle;
    private UUID cityId;
    private WorkingType workingType;
    private WorkingTimeLineType workingTimeLine;
    private String description;
    private LocalDate startDate;
    private LocalDate endDate;

    private ExperienceRoot(Builder builder) {
        super(builder.id,builder.version,  builder.processStatus, builder.rowStatus, builder.createdDate, builder.lastModifiedDate);
        this.accessModifier = builder.accessModifier;
        this.resume = builder.resume;
        this.orderNumber = builder.orderNumber;
        this.employer = builder.employer;
        this.link = builder.link;
        this.jobTitle = builder.jobTitle;
        this.cityId = builder.cityId;
        this.workingType = builder.workingType;
        this.workingTimeLine = builder.workingTimeLine;
        this.description = builder.description;
        this.startDate = builder.startDate;
        this.endDate = builder.endDate;
    }

    public ExperienceRoot changeOrderNumber(Integer orderNumber){
        this.orderNumber=orderNumber;
        return this;
    }

    public ExperienceRoot changeEmployer(String employer){
        this.employer=employer;
        return this;
    }
    public ExperienceRoot changeLink(String link){
        this.link=link;
        return this;
    }
    public ExperienceRoot changeJobTitle(String jobTitle){
        this.jobTitle=jobTitle;
        return this;
    }
    public ExperienceRoot changeCityId(UUID cityId){
        this.cityId=cityId;
        return this;
    }
    public  ExperienceRoot changeWorkingType(WorkingType workingType){
        this.workingType=workingType;
        return this;
    }
    public ExperienceRoot changeWorkingTimeLineType(WorkingTimeLineType workingTimeLineType){
        this.workingTimeLine=workingTimeLineType;
        return this;
    }
    public ExperienceRoot changeStartDate(LocalDate startDate){
        this.startDate=startDate;
        return this;
    }
    public ExperienceRoot changeEndDate(LocalDate endDate){
        this.startDate=endDate;
        return this;
    }
    public ExperienceRoot changeDescription(String description){
        this.description=description;
        return  this;
    }
    public ResumeID getResume() {
        return resume;
    }

    public Integer getOrderNumber() {
        return orderNumber;
    }

    public String getEmployer() {
        return employer;
    }

    public String getLink() {
        return link;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public UUID getCityId() {
        return cityId;
    }

    public WorkingType getWorkingType() {
        return workingType;
    }

    public WorkingTimeLineType getWorkingTimeType() {
        return workingTimeLine;
    }

    public String getDescription() {
        return description;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public AccessModifier getAccessModifier() {
        return accessModifier;
    }

    public static final class Builder {
        private ExperienceID id;
        private Version version;
        private ProcessStatus processStatus;
        private RowStatus rowStatus;
        private ZonedDateTime createdDate;
        private ZonedDateTime lastModifiedDate;

        private ResumeID resume;
        private AccessModifier accessModifier;
        private Integer orderNumber;
        private String employer;
        private String link;
        private String jobTitle;
        private UUID cityId;
        private WorkingType workingType;
        private WorkingTimeLineType workingTimeLine;
        private String description;
        private LocalDate startDate;
        private LocalDate endDate;

        private Builder() {
        }

        public static Builder builder() {
            return new Builder();
        }

        public Builder id(ExperienceID val) {
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

        public Builder resume(ResumeID val) {
            resume = val;
            return this;
        }

        public Builder accessModifier(AccessModifier accessModifier){
            this.accessModifier = accessModifier;
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
            workingTimeLine = val;
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

        public ExperienceRoot build() {
            return new ExperienceRoot(this);
        }
    }
}
