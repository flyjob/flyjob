package com.intellibucket.lib.payload.event.reorder;

import com.intellibucket.lib.payload.event.abstracts.AbstractStartDomainEvent;
import com.intellibucket.lib.payload.event.abstracts.Event;
import com.intellibucket.lib.payload.event.delete.ContactDeleteEvent;
import com.intellibucket.lib.payload.event.update.ContactUpdateEvent;
import com.intellibucket.lib.payload.payload.ContactDeletePayload;
import com.intellibucket.lib.payload.payload.ContactPayload;

@Event
public class ContactReorderEvent extends AbstractStartDomainEvent<ContactPayload> {
    public ContactReorderEvent(ContactPayload payload) {
        super(payload);
    }
    public static ContactReorderEvent of(ContactPayload payload){
        return new ContactReorderEvent(payload);
    }
}
