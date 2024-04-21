package com.intellibucket.lib.payload.payload.command;

import az.rock.lib.domain.id.js.ResumeID;
import az.rock.lib.valueObject.AccessModifier;
import az.rock.lib.valueObject.WorkingTimeLineType;
import az.rock.lib.valueObject.WorkingType;
import com.intellibucket.lib.payload.payload.Payload;

import java.time.ZonedDateTime;
import java.util.UUID;

public class ExperiencePayload extends Payload {
    private  UUID id;
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
    private ZonedDateTime startDate;
    private ZonedDateTime endDate;

    private ExperiencePayload(Builder builder) {
        id = builder.id;
        resume = builder.resume;
        accessModifier = builder.accessModifier;
        orderNumber = builder.orderNumber;
        employer = builder.employer;
        link = builder.link;
        jobTitle = builder.jobTitle;
        cityId = builder.cityId;
        workingType = builder.workingType;
        workingTimeLine = builder.workingTimeLine;
        description = builder.description;
        startDate = builder.startDate;
        endDate = builder.endDate;
    }


    public static final class Builder {
        private UUID id;
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
        private ZonedDateTime startDate;
        private ZonedDateTime endDate;

        private Builder() {
        }

        public static Builder builder() {
            return new Builder();
        }

        public Builder id(UUID val) {
            id = val;
            return this;
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

        public Builder workingTimeLine(WorkingTimeLineType val) {
            workingTimeLine = val;
            return this;
        }

        public Builder description(String val) {
            description = val;
            return this;
        }

        public Builder startDate(ZonedDateTime val) {
            startDate = val;
            return this;
        }

        public Builder endDate(ZonedDateTime val) {
            endDate = val;
            return this;
        }

        public ExperiencePayload build() {
            return new ExperiencePayload(this);
        }
    }
}
