package com.intellibucket.lib.payload.payload.command;

import com.intellibucket.lib.payload.payload.Payload;

import java.util.UUID;

public class SummaryDeletePayload  extends Payload {

    private UUID summaryId;

    public UUID getSummaryId() {
        return summaryId;
    }

    public void setSummaryId(UUID summaryId) {
        this.summaryId = summaryId;
    }

    public SummaryDeletePayload(UUID summaryId) {
        this.summaryId = summaryId;
    }
    public static SummaryDeletePayload of(UUID summaryId){
        return new SummaryDeletePayload(summaryId);
    }
}
