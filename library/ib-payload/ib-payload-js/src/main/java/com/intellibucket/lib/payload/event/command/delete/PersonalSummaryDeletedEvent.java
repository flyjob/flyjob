package com.intellibucket.lib.payload.event.command.delete;

import com.intellibucket.lib.payload.event.abstracts.AbstractStartDomainEvent;
import com.intellibucket.lib.payload.event.abstracts.Event;
import com.intellibucket.lib.payload.payload.command.SummaryDeletePayload;

@Event
public class PersonalSummaryDeletedEvent extends AbstractStartDomainEvent<SummaryDeletePayload> {

    public PersonalSummaryDeletedEvent(SummaryDeletePayload payload) {
        super(payload);
    }

    public static PersonalSummaryDeletedEvent of(SummaryDeletePayload payload) {
        return new PersonalSummaryDeletedEvent(payload);
    }


}
