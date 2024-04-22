package com.intellibucket.lib.payload.event.command.delete;

import com.intellibucket.lib.payload.event.abstracts.AbstractStartDomainEvent;

import java.util.UUID;

public class EducationDeletedEvent extends AbstractStartDomainEvent<UUID> {
    public EducationDeletedEvent() {
    }

    private EducationDeletedEvent(UUID root) {
        super(root);
    }


    public static EducationDeletedEvent of(UUID root) {
        return new EducationDeletedEvent(root);
    }


}
