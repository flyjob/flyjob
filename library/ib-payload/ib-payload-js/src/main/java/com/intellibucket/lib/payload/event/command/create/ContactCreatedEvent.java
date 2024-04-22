package com.intellibucket.lib.payload.event.create;

import com.intellibucket.lib.payload.event.abstracts.AbstractStartDomainEvent;
import com.intellibucket.lib.payload.event.abstracts.Event;
import com.intellibucket.lib.payload.payload.ContactPayload;
import com.intellibucket.lib.payload.payload.ResumeCreatedPayload;
@Event
public class ContactCreatedEvent extends AbstractStartDomainEvent<ContactPayload> {
    public ContactCreatedEvent(ContactPayload payload) {
        super(payload);
    }
    public static ContactCreatedEvent of(ContactPayload payload){
        return new ContactCreatedEvent(payload);
    }

}
