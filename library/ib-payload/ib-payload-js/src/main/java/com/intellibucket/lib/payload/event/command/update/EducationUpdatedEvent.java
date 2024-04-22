package com.intellibucket.lib.payload.event.command.update;

import com.intellibucket.lib.payload.event.abstracts.AbstractStartDomainEvent;
import com.intellibucket.lib.payload.payload.command.EducationPayload;

public class EducationUpdatedEvent extends AbstractStartDomainEvent<EducationPayload> {

    public EducationUpdatedEvent() {

    }

    private EducationUpdatedEvent(EducationPayload root) {
        super(root);
    }

    public static EducationUpdatedEvent of(EducationPayload root) {
        return new EducationUpdatedEvent(root);
    }
}
