package az.rock.flyjob.js.dataaccess.model.compose.interest;

import az.rock.flyjob.js.dataaccess.model.compose.BaseCompose;
import az.rock.lib.valueObject.AccessModifier;
import az.rock.lib.valueObject.ProcessStatus;
import az.rock.lib.valueObject.RowStatus;

import java.sql.Timestamp;
import java.util.UUID;


public class InterestCompose extends BaseCompose {

    private String name;
    private String description;
    private Integer orderNumber;
    private Boolean isHobby;

    private AccessModifier accessModifier;

    private InterestCompose(Builder builder) {
        setUuid(builder.uuid);
        setParentId(builder.parentId);
        setVersion(builder.version);
        setProcessStatus(builder.processStatus);
        setRowStatus(builder.rowStatus);
        setCreatedDate(builder.createdDate);
        setLastModifiedDate(builder.lastModifiedDate);
        name = builder.name;
        description = builder.description;
        orderNumber = builder.orderNumber;
        isHobby = builder.isHobby;
        accessModifier = builder.accessModifier;
    }


    public static final class Builder {
        private UUID uuid;
        private UUID parentId;
        private Long version;
        private ProcessStatus processStatus;
        private RowStatus rowStatus;
        private Timestamp createdDate;
        private Timestamp lastModifiedDate;
        private String name;
        private String description;
        private Integer orderNumber;
        private Boolean isHobby;
        private AccessModifier accessModifier;

        public Builder() {
        }

        public Builder uuid(UUID val) {
            uuid = val;
            return this;
        }

        public Builder parentId(UUID val) {
            parentId = val;
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

        public Builder name(String val) {
            name = val;
            return this;
        }

        public Builder description(String val) {
            description = val;
            return this;
        }

        public Builder orderNumber(Integer val) {
            orderNumber = val;
            return this;
        }

        public Builder isHobby(Boolean val) {
            isHobby = val;
            return this;
        }

        public Builder accessModifier(AccessModifier val) {
            accessModifier = val;
            return this;
        }

        public InterestCompose build() {
            return new InterestCompose(this);
        }
    }
}

