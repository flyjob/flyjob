package com.intellibucket.lib.payload.event.command.delete;

import com.intellibucket.lib.payload.event.abstracts.AbstractDomainEvent;

import java.util.UUID;

public class ProjectDeleteEvent extends AbstractDomainEvent<UUID> {
    private ProjectDeleteEvent(UUID root) {
        super(root);
    }

    public static ProjectDeleteEvent of(UUID root) {
        return new ProjectDeleteEvent(root);
    }
}
