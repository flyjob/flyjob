package az.rock.flyjob.js.domain.core.root.detail;

import az.rock.lib.domain.AggregateRoot;
import az.rock.lib.domain.id.js.ProjectID;
import az.rock.lib.domain.id.js.ResumeID;
import az.rock.lib.valueObject.AccessModifier;
import az.rock.lib.valueObject.ProcessStatus;
import az.rock.lib.valueObject.RowStatus;
import az.rock.lib.valueObject.Version;

import java.time.LocalDate;
import java.time.ZonedDateTime;

public class ProjectRoot extends AggregateRoot<ProjectID> {
    private ResumeID resume;
    private AccessModifier accessModifier;
    private Integer orderNumber;
    private String title;
    private String subtitle;
    private String link;
    private LocalDate startDate;
    private LocalDate endDate;
    private String description;

    private ProjectRoot(Builder builder) {
        super(builder.id, builder.version, builder.processStatus, builder.rowStatus, builder.createdDate, builder.lastModifiedDate);
        this.accessModifier = builder.accessModifier;
        this.resume = builder.resume;
        this.orderNumber = builder.orderNumber;
        this.title = builder.title;
        this.subtitle = builder.subtitle;
        this.link = builder.link;
        this.startDate = builder.startDate;
        this.endDate = builder.endDate;
        this.description = builder.description;
    }

    public ProjectRoot changeTitle(String title) {
        this.title = title;
        return this;
    }

    public ProjectRoot changeSubTitle(String subtitle) {
        this.subtitle = subtitle;
        return this;
    }

    public ProjectRoot changeLink(String link) {
        this.link = link;
        return this;
    }

    public ProjectRoot changeDescription(String description) {
        this.description = description;
        return this;
    }

    public ProjectRoot changeStartDate(LocalDate startDate) {
        this.startDate = startDate;
        return this;
    }

    public ProjectRoot changeEndDate(LocalDate endDate) {
        this.endDate = endDate;
        return this;
    }
   public ProjectRoot changeOrderNumber(Integer orderNumber){
        this.orderNumber=orderNumber;
        return this;
   }

    public ResumeID getResume() {
        return resume;
    }

    public Integer getOrderNumber() {
        return orderNumber;
    }

    public String getTitle() {
        return title;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public String getLink() {
        return link;
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

    public AccessModifier getAccessModifier() {
        return accessModifier;
    }

    public static final class Builder {

        private ProjectID id;
        private Version version;
        private ProcessStatus processStatus;
        private RowStatus rowStatus;
        private ZonedDateTime createdDate;
        private ZonedDateTime lastModifiedDate;
        private ResumeID resume;
        private AccessModifier accessModifier;
        private Integer orderNumber;
        private String title;
        private String subtitle;
        private String link;
        private LocalDate startDate;
        private LocalDate endDate;
        private String description;

        private Builder() {
        }

        public static Builder builder() {
            return new Builder();
        }

        public Builder id(ProjectID val) {
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

        public Builder accessModifier(AccessModifier accessModifier) {
            this.accessModifier = accessModifier;
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


        public ProjectRoot build() {
            return new ProjectRoot(this);
        }
    }
}
