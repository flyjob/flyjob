package com.intellibucket.lib.payload.event.command.update;

import com.intellibucket.lib.payload.event.abstracts.AbstractStartDomainEvent;

import java.util.UUID;

public class InterestReorderEvent extends AbstractStartDomainEvent<UUID> {
    private InterestReorderEvent(UUID root) {
        super(root);
    }

    public static InterestReorderEvent of(UUID root) {
        return new InterestReorderEvent(root);
    }
}