package com.intellibucket.lib.payload.payload.command;

import az.rock.lib.domain.id.js.ResumeID;
import az.rock.lib.valueObject.AccessModifier;

import java.time.ZonedDateTime;
import java.util.UUID;

public class ProjectPayload {
    private UUID id;
    private UUID resume;
    private AccessModifier accessModifier;
    private Integer orderNumber;
    private String title;
    private String subtitle;
    private String link;
    private ZonedDateTime startDate;
    private ZonedDateTime endDate;
    private String description;

    private ProjectPayload(Builder builder) {
        id = builder.id;
        resume = builder.resume;
        accessModifier = builder.accessModifier;
        orderNumber = builder.orderNumber;
        title = builder.title;
        subtitle = builder.subtitle;
        link = builder.link;
        startDate = builder.startDate;
        endDate = builder.endDate;
        description = builder.description;
    }


    public static final class Builder {
        private UUID id;
        private UUID resume;
        private AccessModifier accessModifier;
        private Integer orderNumber;
        private String title;
        private String subtitle;
        private String link;
        private ZonedDateTime startDate;
        private ZonedDateTime endDate;
        private String description;

        private Builder() {
        }

        public static Builder builder() {
            return new Builder();
        }

        public Builder id(UUID val) {
            id = val;
            return this;
        }

        public Builder resume(UUID val) {
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

        public Builder title(String val) {
            title = val;
            return this;
        }

        public Builder subtitle(String val) {
            subtitle = val;
            return this;
        }

        public Builder link(String val) {
            link = val;
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

        public Builder description(String val) {
            description = val;
            return this;
        }

        public ProjectPayload build() {
            return new ProjectPayload(this);
        }
    }
}
