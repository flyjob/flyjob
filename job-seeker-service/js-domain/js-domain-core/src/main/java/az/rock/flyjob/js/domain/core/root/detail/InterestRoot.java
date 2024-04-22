package az.rock.flyjob.js.domain.core.root.detail;

import az.rock.lib.domain.AggregateRoot;
import az.rock.lib.domain.id.js.InterestID;
import az.rock.lib.domain.id.js.ResumeID;
import az.rock.lib.valueObject.AccessModifier;
import az.rock.lib.valueObject.ProcessStatus;
import az.rock.lib.valueObject.RowStatus;
import az.rock.lib.valueObject.Version;

import java.time.ZonedDateTime;
import java.util.Objects;

public class InterestRoot extends AggregateRoot<InterestID> {
    private ResumeID resume;
    private AccessModifier accessModifier;
    private Integer orderNumber;
    private Boolean isHobby;
    private String name;
    private String description;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof InterestRoot that)) return false;
        return Objects.equals(isHobby, that.isHobby) && Objects.equals(name, that.name) && Objects.equals(description, that.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), isHobby, name, description);
    }

    private InterestRoot(Builder builder) {
        super(builder.id, builder.version, builder.processStatus, builder.rowStatus, builder.createdDate, builder.lastModifiedDate);
        this.accessModifier = builder.accessModifier;
        this.resume = builder.resume;
        this.orderNumber = builder.orderNumber;
        this.isHobby = builder.isHobby;
        this.name = builder.name;
        this.description = builder.description;
    }

    public InterestRoot changeName(String name) {
        if (!name.isBlank()) {
            this.name = name;
        }
        return this;

    }

    public InterestRoot changeHobby(Boolean isHobby) {

        this.isHobby = isHobby;

        return this;
    }

    public InterestRoot changeDescription(String description) {
        this.description = description;

        return this;
    }

    public InterestRoot changeOrderNumber(Integer newNumber) {
        this.orderNumber = newNumber;
        return this;
    }


    public ResumeID getResume() {
        return resume;
    }

    public Integer getOrderNumber() {
        return orderNumber;
    }

    public Boolean getHobby() {
        return isHobby;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public AccessModifier getAccessModifier() {
        return accessModifier;
    }

    public static final class Builder {

        private InterestID id;
        private Long version;
        private ProcessStatus processStatus;
        private RowStatus rowStatus;
        private ZonedDateTime createdDate;
        private ZonedDateTime lastModifiedDate;


        private ResumeID resume;
        private AccessModifier accessModifier;
        private Integer orderNumber;
        private Boolean isHobby;
        private String name;
        private String description;

        private Builder() {
        }

        public static Builder builder() {
            return new Builder();
        }

        public Builder id(InterestID val) {
            id = val;
            return this;
        }

        public Builder version(Version version) {
            this.version = version.value();
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

        public Builder orderNumber(Integer val) {
            orderNumber = val;
            return this;
        }

        public Builder accessModifier(AccessModifier accessModifier) {
            this.accessModifier = accessModifier;
            return this;
        }

        public Builder isHobby(Boolean val) {
            isHobby = val;
            return this;
        }

        public Builder name(String val) {
            name = val;
            return this;
        }

        public Builder description(String val) {
            description = val;
            return this;
        }


        public InterestRoot build() {
            return new InterestRoot(this);
        }
    }
}
