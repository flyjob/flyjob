package com.intellibucket.lib.payload.event.command.delete;

import com.intellibucket.lib.payload.event.abstracts.AbstractDomainEvent;
import com.intellibucket.lib.payload.event.command.create.ExperienceMergeEvent;
import com.intellibucket.lib.payload.payload.command.ExperiencePayload;

import java.util.UUID;

public class ExperienceDeleteEvent extends AbstractDomainEvent<UUID> {
    public ExperienceDeleteEvent(UUID root) {
        super(root);
    }
    public static ExperienceDeleteEvent of(UUID root){
        return new ExperienceDeleteEvent(root);
    }
}
