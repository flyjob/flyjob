package az.rock.flyjob.js.dataaccess.repository.abstracts.query.criteria;

import az.rock.lib.domain.id.js.ResumeID;
import az.rock.lib.valueObject.AccessModifier;
import az.rock.lib.valueObject.ContactFormatType;
import az.rock.lib.valueObject.ContactLiveType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ContactCriteria {
    private ResumeID resume;
    public AccessModifier accessModifier;
    private Integer orderNumber;
    private ContactFormatType formatType;
    private ContactLiveType liveType;
    private String data;


    private ContactCriteria(Builder builder) {
        resume = builder.resume;
        accessModifier = builder.accessModifier;
        orderNumber = builder.orderNumber;
        formatType = builder.formatType;
        liveType = builder.liveType;
        data = builder.data;
    }


    public static final class Builder {
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

        public Builder resume(ResumeID val) {
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

        public ContactCriteria build() {
            return new ContactCriteria(this);
        }
    }
}
