package com.intellibucket.lib.payload.payload.command;

import com.intellibucket.lib.payload.payload.Payload;

import java.util.UUID;

public class SummaryCreatePayload  extends Payload {

    private UUID summaryId;

    private UUID resumeId;

    private String context;





    private SummaryCreatePayload(Builder builder) {
        setSummaryId(builder.summaryId);
        setResumeId(builder.resumeId);
        setContext(builder.context);
    }

    public UUID getSummaryId() {
        return summaryId;
    }

    public void setSummaryId(UUID summaryId) {
        this.summaryId = summaryId;
    }

    public UUID getResumeId() {
        return resumeId;
    }

    public void setResumeId(UUID resumeId) {
        this.resumeId = resumeId;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public static final class Builder {
        private UUID summaryId;
        private UUID resumeId;
        private String context;

        private Builder() {
        }

        public static Builder builder() {
            return new Builder();
        }

        public Builder summaryId(UUID val) {
            summaryId = val;
            return this;
        }

        public Builder resumeId(UUID val) {
            resumeId = val;
            return this;
        }

        public Builder context(String val) {
            context = val;
            return this;
        }

        public SummaryCreatePayload build() {
            return new SummaryCreatePayload(this);
        }
    }
}
