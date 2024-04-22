package com.intellibucket.lib.payload.event.command.update;

import com.intellibucket.lib.payload.event.abstracts.AbstractStartDomainEvent;

import java.util.UUID;

public class InterestDeleteEvent  extends AbstractStartDomainEvent<UUID> {
    private InterestDeleteEvent(UUID root) {
        super(root);
    }

    public static InterestDeleteEvent of(UUID root) {
        return new InterestDeleteEvent(root);
    }
}
