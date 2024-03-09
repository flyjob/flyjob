package az.rock.flyjob.js.domain.core.root.detail;

import az.rock.lib.domain.AggregateRoot;
import az.rock.lib.domain.id.js.EducationID;
import az.rock.lib.domain.id.js.ResumeID;
import az.rock.lib.valueObject.AccessModifier;
import az.rock.lib.valueObject.ProcessStatus;
import az.rock.lib.valueObject.RowStatus;
import az.rock.lib.valueObject.Version;
import az.rock.lib.valueObject.js.EducationDegree;
import az.rock.lib.valueObject.js.EducationState;

import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.function.Function;
import java.util.stream.Collectors;


public class EducationRoot extends AggregateRoot<EducationID> {
    private final ResumeID resumeID;
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


    private EducationRoot(Builder builder) {
        super(builder.id, builder.version, builder.processStatus, builder.rowStatus, builder.createdDate, builder.lastModifiedDate);
        this.accessModifier = builder.accessModifier;
        this.resumeID = builder.resume;
        this.orderNumber = builder.orderNumber;
        this.degree = builder.degree;
        this.state = builder.state;
        this.link = builder.link;
        this.establishmentUUID = builder.establishmentUUID;
        this.establishmentName = builder.establishmentName;
        this.cityId = builder.cityId;
        this.startDate = builder.startDate;
        this.endDate = builder.endDate;
        this.description = builder.description;
    }

    public static Map<EducationID, EducationRoot> groupByPhoneNumberID(List<EducationRoot> educationRoots) {
        return educationRoots.stream().collect(Collectors.toMap(EducationRoot::getRootID, Function.identity()));
    }

    public void setEducationDegree(EducationDegree educationDegree) {
        this.degree = educationDegree;
    }

    public void setEducationState(EducationState educationState) {
        this.state = educationState;

    }

    public void setLink(String link) {
        this.link = link;
    }

    public void setEstablishmentName(String establishmentName) {
        this.establishmentName = establishmentName;
    }

    public void setEducationDescription(String description) {
        this.description = description;
    }

    public void setEducationStartDate(LocalDate educationStartDate) {
        this.startDate = educationStartDate;

    }

    public void setEducationEndDate(LocalDate educationEndDate) {
        this.startDate = educationEndDate;
    }


    public ResumeID getResumeID() {
        return resumeID;
    }

    public AccessModifier getAccessModifier() {
        return accessModifier;
    }

    public Integer getOrderNumber() {
        return orderNumber;
    }

    public EducationDegree getDegree() {
        return degree;
    }

    public EducationState getState() {
        return state;
    }

    public String getLink() {
        return link;
    }

    public UUID getEstablishmentUUID() {
        return establishmentUUID;
    }

    public String getEstablishmentName() {
        return establishmentName;
    }

    public UUID getCityId() {
        return cityId;
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

    public static final class Builder {
        private EducationID id;
        private Version version;
        private ProcessStatus processStatus;
        private RowStatus rowStatus;
        private ZonedDateTime createdDate;
        private ZonedDateTime lastModifiedDate;

        private ResumeID resume;
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

        private Builder() {
        }

        public static Builder builder() {
            return new Builder();
        }

        public Builder uuid(EducationID val) {
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

        public EducationRoot build() {
            return new EducationRoot(this);
        }
    }
}
