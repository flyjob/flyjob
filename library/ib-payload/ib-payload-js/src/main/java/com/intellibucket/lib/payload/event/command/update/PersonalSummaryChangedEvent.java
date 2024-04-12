package com.intellibucket.lib.payload.event.command.update;


import az.rock.flyjob.js.domain.core.root.detail.PersonalSummaryRoot;
import com.intellibucket.lib.payload.event.abstracts.AbstractStartDomainEvent;

public class PersonalSummaryChangedEvent extends AbstractStartDomainEvent<PersonalSummaryRoot> {
    public PersonalSummaryChangedEvent(PersonalSummaryRoot root) {
        super(root);
    }
    public static PersonalSummaryChangedEvent of(PersonalSummaryRoot root){
        return new PersonalSummaryChangedEvent(root);
    }
}
