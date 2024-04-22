package com.intellibucket.lib.payload.payload.command;

import com.intellibucket.lib.payload.payload.Payload;

import java.util.UUID;

public class InterestUpdatePayload extends Payload {
    private UUID interestId;

    public InterestUpdatePayload(UUID interestId) {
        this.interestId = interestId;
    }

    public InterestUpdatePayload() {
    }

    public UUID getInterestId() {
        return interestId;
    }

    public void setInterestId(UUID interestId) {
        this.interestId = interestId;
    }

    public static InterestUpdatePayload of(UUID interestId) {
        return new InterestUpdatePayload(interestId);
    }
}
