package com.intellibucket.lib.payload.payload.command;

import com.intellibucket.lib.payload.payload.Payload;

import java.util.UUID;

public class SummaryChangePayload extends Payload {
    private UUID summaryId;
    public SummaryChangePayload(UUID  summaryId) {
        this.summaryId = summaryId;
    }

    public SummaryChangePayload() {
    }

    public UUID getSummaryId() {
        return summaryId;
    }

    public void setSummaryId(UUID summaryId) {
        this.summaryId = summaryId;
    }
    public static SummaryChangePayload of(UUID summaryId){
        return new SummaryChangePayload(summaryId);
    }
}
