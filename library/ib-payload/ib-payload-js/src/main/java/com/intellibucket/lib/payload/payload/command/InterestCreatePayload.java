package com.intellibucket.lib.payload.payload.command;

import az.rock.lib.valueObject.AccessModifier;
import com.intellibucket.lib.payload.payload.Payload;

import java.util.UUID;

public class InterestCreatePayload extends Payload {


    private UUID interestId;

    private final UUID resumeId;

    private AccessModifier accessModifier;

    private Integer orderNumber;

    private Boolean isHobby;

    private String name;

    private String description;

    private InterestCreatePayload(Builder builder) {
        setInterestId(builder.interestId);
        resumeId = builder.resumeId;
        setAccessModifier(builder.accessModifier);
        setOrderNumber(builder.orderNumber);
        isHobby = builder.isHobby;
        setName(builder.name);
        setDescription(builder.description);
    }

    public UUID getInterestId() {
        return interestId;
    }

    public void setInterestId(UUID interestId) {
        this.interestId = interestId;
    }

    public UUID getResumeId() {
        return resumeId;
    }

    public Integer getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(Integer orderNumber) {
        this.orderNumber = orderNumber;
    }

    public Boolean getHobby() {
        return isHobby;
    }

    public void setHobby(Boolean hobby) {
        isHobby = hobby;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public static InterestCreatePayload of(UUID interestId) {
        return new InterestCreatePayload(interestId);
    }

    public InterestCreatePayload(UUID resumeId) {
        this.resumeId = resumeId;
    }

    public AccessModifier getAccessModifier() {
        return accessModifier;
    }

    public void setAccessModifier(AccessModifier accessModifier) {
        this.accessModifier = accessModifier;
    }

    public InterestCreatePayload(UUID interestId, UUID resumeId, AccessModifier accessModifier, Integer orderNumber, Boolean isHobby, String name, String description) {
        this.interestId = interestId;
        this.resumeId = resumeId;
        this.accessModifier = accessModifier;
        this.orderNumber = orderNumber;
        this.isHobby = isHobby;
        this.name = name;
        this.description = description;
    }

    public static final class Builder {
        private UUID interestId;
        private UUID resumeId;
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

        public Builder interestId(UUID val) {
            interestId = val;
            return this;
        }

        public Builder resumeId(UUID val) {
            resumeId = val;
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

        public InterestCreatePayload build() {
            return new InterestCreatePayload(this);
        }
    }
}
