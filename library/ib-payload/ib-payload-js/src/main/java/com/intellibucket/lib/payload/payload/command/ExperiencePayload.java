package com.intellibucket.lib.payload.payload.command;

import az.rock.lib.domain.id.js.ResumeID;
import az.rock.lib.valueObject.AccessModifier;
import az.rock.lib.valueObject.WorkingTimeLineType;
import az.rock.lib.valueObject.WorkingType;

import java.time.ZonedDateTime;
import java.util.UUID;

public class ExperiencePayload {
    private final ResumeID resume;
    private final AccessModifier accessModifier;
    private final Integer orderNumber;
    private final  String employer;
    private final  String link;
    private final String jobTitle;
    private final UUID cityId;
    private final WorkingType workingType;
    private final WorkingTimeLineType workingTimeLine;
    private final String description;
    private final ZonedDateTime startDate;
    private final ZonedDateTime endDate;

    public ExperiencePayload(ResumeID resume
            , AccessModifier accessModifier
            , Integer orderNumber
            , String employer
            , String link
            , String jobTitle
            , UUID cityId, WorkingType workingType
            , WorkingTimeLineType workingTimeLine
            , String description
            , ZonedDateTime startDate
            , ZonedDateTime endDate) {
        this.resume = resume;
        this.accessModifier = accessModifier;
        this.orderNumber = orderNumber;
        this.employer = employer;
        this.link = link;
        this.jobTitle = jobTitle;
        this.cityId = cityId;
        this.workingType = workingType;
        this.workingTimeLine = workingTimeLine;
        this.description = description;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    private ExperiencePayload(Builder builder) {
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
        private final ResumeID resume;
        private final AccessModifier accessModifier;
        private final Integer orderNumber;
        private final String employer;
        private final String link;
        private final String jobTitle;
        private final UUID cityId;
        private final WorkingType workingType;
        private final WorkingTimeLineType workingTimeLine;
        private final String description;
        private final ZonedDateTime startDate;
        private final ZonedDateTime endDate;

        private Builder(ResumeID resume, AccessModifier accessModifier, Integer orderNumber, String employer, String link, String jobTitle, UUID cityId, WorkingType workingType, WorkingTimeLineType workingTimeLine, String description, ZonedDateTime startDate, ZonedDateTime endDate) {
            this.resume = resume;
            this.accessModifier = accessModifier;
            this.orderNumber = orderNumber;
            this.employer = employer;
            this.link = link;
            this.jobTitle = jobTitle;
            this.cityId = cityId;
            this.workingType = workingType;
            this.workingTimeLine = workingTimeLine;
            this.description = description;
            this.startDate = startDate;
            this.endDate = endDate;
        }

        public static Builder builder(ResumeID resume, AccessModifier accessModifier, Integer orderNumber, String employer, String link, String jobTitle, UUID cityId, WorkingType workingType, WorkingTimeLineType workingTimeLine, String description, ZonedDateTime startDate, ZonedDateTime endDate) {
            return new Builder(resume, accessModifier, orderNumber, employer, link, jobTitle, cityId, workingType, workingTimeLine, description, startDate, endDate);
        }

        public ExperiencePayload build() {
            return new ExperiencePayload(this);
        }
    }
}
