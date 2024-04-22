package com.intellibucket.lib.payload.payload.command;



import az.rock.lib.valueObject.AccessModifier;
import az.rock.lib.valueObject.js.EducationDegree;
import az.rock.lib.valueObject.js.EducationState;

import java.sql.Timestamp;
import java.util.UUID;

public class EducationPayload {
    private final UUID id;
    private final UUID resumeId;
    private final AccessModifier accessModifier;
    private final Integer orderNumber;
    private final EducationDegree degree;
    private final EducationState state;
    private final String link;
    private final UUID establishmentUUID;
    private final String establishmentName;
    private final UUID cityId;
    private final Timestamp startDate;
    private final Timestamp endDate;
    private final String description;

    private EducationPayload(Builder builder) {
        id = builder.id;
        resumeId = builder.resumeId;
        accessModifier = builder.accessModifier;
        orderNumber = builder.orderNumber;
        degree = builder.degree;
        state = builder.state;
        link = builder.link;
        establishmentUUID = builder.establishmentUUID;
        establishmentName = builder.establishmentName;
        cityId = builder.cityId;
        startDate = builder.startDate;
        endDate = builder.endDate;
        description = builder.description;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static final class Builder {
        private UUID id;
        private UUID resumeId;
        private AccessModifier accessModifier;
        private Integer orderNumber;
        private EducationDegree degree;
        private EducationState state;
        private String link;
        private UUID establishmentUUID;
        private String establishmentName;
        private UUID cityId;
        private Timestamp startDate;
        private Timestamp endDate;
        private String description;

        private Builder() {
        }

        public Builder id(UUID val) {
            id = val;
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

        public Builder startDate(Timestamp val) {
            startDate = val;
            return this;
        }

        public Builder endDate(Timestamp val) {
            endDate = val;
            return this;
        }

        public Builder description(String val) {
            description = val;
            return this;
        }

        public EducationPayload build() {
            return new EducationPayload(this);
        }
    }
}

