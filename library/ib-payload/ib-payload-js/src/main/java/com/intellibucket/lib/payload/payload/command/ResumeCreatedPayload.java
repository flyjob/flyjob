package com.intellibucket.lib.payload.payload.command;


import com.intellibucket.lib.payload.payload.Payload;

import java.util.UUID;

public class ResumeCreatedPayload extends Payload {
    private UUID resumeId;

    public ResumeCreatedPayload(UUID resumeId) {
        this.resumeId = resumeId;
    }

    public ResumeCreatedPayload(){}

    public UUID getResumeId() {
        return resumeId;
    }

    public void setResumeId(UUID resumeId) {
        this.resumeId = resumeId;
    }

    public static ResumeCreatedPayload of(UUID resumeId) {
        return new ResumeCreatedPayload(resumeId);
    }
}
