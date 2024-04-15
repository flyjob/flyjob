package com.intellibucket.lib.payload.event.command.create;

import com.intellibucket.lib.payload.event.abstracts.AbstractStartDomainEvent;
import com.intellibucket.lib.payload.event.abstracts.Event;
import com.intellibucket.lib.payload.payload.command.SummaryCreatePayload;

@Event
public class PersonalSummaryCreatedEvent extends AbstractStartDomainEvent<SummaryCreatePayload> {
    public PersonalSummaryCreatedEvent(SummaryCreatePayload payload) {
        super(payload);
    }

    public static PersonalSummaryCreatedEvent of(SummaryCreatePayload payload) {
        return new PersonalSummaryCreatedEvent(payload);
    }
}
