package com.intellibucket.lib.payload.event.command.create;


import com.intellibucket.lib.payload.event.abstracts.AbstractStartDomainEvent;
import com.intellibucket.lib.payload.event.abstracts.Event;
import com.intellibucket.lib.payload.payload.command.InterestCreatePayload;

@Event
public class InterestCreateEvent extends AbstractStartDomainEvent<InterestCreatePayload> {
    protected InterestCreateEvent(InterestCreatePayload payload) {
        super(payload);
    }

    public static InterestCreateEvent of(InterestCreatePayload payload) {
        return new InterestCreateEvent(payload);
    }
}
