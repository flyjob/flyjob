package com.intellibucket.lib.payload.event.command.update;


import az.rock.flyjob.js.domain.core.root.detail.PersonalSummaryRoot;
import com.intellibucket.lib.payload.event.abstracts.AbstractStartDomainEvent;
import com.intellibucket.lib.payload.payload.command.SummaryChangePayload;

public class PersonalSummaryChangedEvent extends AbstractStartDomainEvent<SummaryChangePayload> {
    public PersonalSummaryChangedEvent(SummaryChangePayload root) {
        super(root);
    }
    public static PersonalSummaryChangedEvent of(SummaryChangePayload root){
        return new PersonalSummaryChangedEvent(root);
    }
}
