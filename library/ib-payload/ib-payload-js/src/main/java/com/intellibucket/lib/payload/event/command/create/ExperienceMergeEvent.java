package com.intellibucket.lib.payload.event.command.create;

import com.intellibucket.lib.payload.event.abstracts.AbstractDomainEvent;
import com.intellibucket.lib.payload.payload.command.ExperiencePayload;

public class ExperienceMergeEvent extends AbstractDomainEvent<ExperiencePayload> {

    public ExperienceMergeEvent(ExperiencePayload payload) {
        super(payload);
    }
    public static ExperienceMergeEvent of(ExperiencePayload root){
        return new ExperienceMergeEvent(root);
    }
}
