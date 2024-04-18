package az.rock.flyjob.js.domain.core.root.detail;

import az.rock.lib.domain.AggregateRoot;
import az.rock.lib.domain.id.js.ContactID;
import az.rock.lib.domain.id.js.ResumeID;
import az.rock.lib.valueObject.*;

import java.time.ZonedDateTime;


public class ContactRoot extends AggregateRoot<ContactID> {
    private ResumeID resume;
    private AccessModifier accessModifier;
    private Integer orderNumber;
    private ContactFormatType formatType;
    private ContactLiveType liveType;
    private String data;

    @Override
    public boolean equals(Object o) {
        return super.equals(o);
    }

    private ContactRoot(Builder builder) {
        super(builder.id, builder.version, builder.processStatus, builder.rowStatus, builder.createdDate, builder.lastModifiedDate);
        this.accessModifier = builder.accessModifier;
        this.resume = builder.resume;
        this.formatType = builder.formatType;
        this.liveType = builder.liveType;
        this.data = builder.data;
        this.orderNumber = builder.orderNumber;
    }

    public ResumeID getResume() {
        return resume;
    }

    public Integer getOrderNumber() {
        return orderNumber;
    }

    public ContactFormatType getFormatType() {
        return formatType;
    }

    public ContactLiveType getLiveType() {
        return liveType;
    }

    public String getData() {
        return data;
    }

    public AccessModifier getAccessModifier() {
        return accessModifier;
    }

    public static final class Builder {

        private ContactID id;
        private Version version;
        private ProcessStatus processStatus;
        private RowStatus rowStatus;
        private ZonedDateTime createdDate;
        private ZonedDateTime lastModifiedDate;


        private ResumeID resume;
        private AccessModifier accessModifier;
        private Integer orderNumber;
        private ContactFormatType formatType;
        private ContactLiveType liveType;
        private String data;

        private Builder() {
        }

        public static Builder builder() {
            return new Builder();
        }

        public Builder id(ContactID val) {
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

        public Builder formatType(ContactFormatType val) {
            formatType = val;
            return this;
        }

        public Builder liveType(ContactLiveType val) {
            liveType = val;
            return this;
        }

        public Builder data(String val) {
            data = val;
            return this;
        }


        public ContactRoot build() {
            return new ContactRoot(this);
        }
    }
}
