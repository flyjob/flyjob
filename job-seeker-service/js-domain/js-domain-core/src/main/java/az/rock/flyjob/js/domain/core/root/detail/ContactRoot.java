package az.rock.flyjob.js.domain.core.root.detail;

import az.rock.lib.domain.AggregateRoot;
import az.rock.lib.domain.id.js.ContactID;
import az.rock.lib.domain.id.js.ResumeID;
import az.rock.lib.valueObject.*;

import java.time.ZonedDateTime;
import java.util.Objects;


public class ContactRoot extends AggregateRoot<ContactID> {
    private ResumeID resume;
    private AccessModifier accessModifier;
    private Integer orderNumber;
    private ContactFormatType formatType;
    private ContactLiveType liveType;
    private String data;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        ContactRoot that = (ContactRoot) o;
        return Objects.equals(resume, that.resume) && formatType == that.formatType && liveType == that.liveType && Objects.equals(data, that.data);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), resume, formatType, liveType, data);
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

    public ContactRoot changeOrderNumber(Integer orderNumber){
        this.orderNumber=orderNumber;
        return this;
    }
    public ContactRoot changeData(String data){
        this.data=data;
        return this;
    }
    public ContactRoot changeFormatType(ContactFormatType formatType){
        this.formatType=formatType;
        return this;
    }
    public ContactRoot changeLiveType(ContactLiveType contactLiveType){
        this.liveType=contactLiveType;
        return this;
    }
    public Boolean isValid() {
        return Objects.nonNull(this.formatType) && Objects.nonNull(this.data) && Objects.nonNull(this.liveType);
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
        public Builder version(Long val) {
            version =  Version.of(val);
            return this;
        }

        public ContactID getId() {
            return id;
        }

        public void setId(ContactID id) {
            this.id = id;
        }

        public Version getVersion() {
            return version;
        }

        public void setVersion(Version version) {
            this.version = version;
        }

        public ProcessStatus getProcessStatus() {
            return processStatus;
        }

        public void setProcessStatus(ProcessStatus processStatus) {
            this.processStatus = processStatus;
        }

        public RowStatus getRowStatus() {
            return rowStatus;
        }

        public void setRowStatus(RowStatus rowStatus) {
            this.rowStatus = rowStatus;
        }

        public ZonedDateTime getCreatedDate() {
            return createdDate;
        }

        public void setCreatedDate(ZonedDateTime createdDate) {
            this.createdDate = createdDate;
        }

        public ZonedDateTime getLastModifiedDate() {
            return lastModifiedDate;
        }

        public void setLastModifiedDate(ZonedDateTime lastModifiedDate) {
            this.lastModifiedDate = lastModifiedDate;
        }

        public ResumeID getResume() {
            return resume;
        }

        public void setResume(ResumeID resume) {
            this.resume = resume;
        }

        public AccessModifier getAccessModifier() {
            return accessModifier;
        }

        public void setAccessModifier(AccessModifier accessModifier) {
            this.accessModifier = accessModifier;
        }

        public Integer getOrderNumber() {
            return orderNumber;
        }

        public void setOrderNumber(Integer orderNumber) {
            this.orderNumber = orderNumber;
        }

        public ContactFormatType getFormatType() {
            return formatType;
        }

        public void setFormatType(ContactFormatType formatType) {
            this.formatType = formatType;
        }

        public ContactLiveType getLiveType() {
            return liveType;
        }

        public void setLiveType(ContactLiveType liveType) {
            this.liveType = liveType;
        }

        public String getData() {
            return data;
        }

        public void setData(String data) {
            this.data = data;
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
