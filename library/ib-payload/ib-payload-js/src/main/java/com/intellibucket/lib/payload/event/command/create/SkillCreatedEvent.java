package com.intellibucket.lib.payload.event.command.create;

import com.intellibucket.lib.payload.event.abstracts.AbstractStartDomainEvent;
import com.intellibucket.lib.payload.payload.command.SkillPayload;

public class SkillCreatedEvent extends AbstractStartDomainEvent<SkillPayload> {
    public SkillCreatedEvent(SkillPayload payload) {
        super(payload);
    }

    public static SkillCreatedEvent of(SkillPayload payload) {
        return new SkillCreatedEvent(payload);
    }
}
