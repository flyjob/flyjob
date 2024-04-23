package com.intellibucket.lib.payload.event.command.create;

import com.intellibucket.lib.payload.event.abstracts.AbstractDomainEvent;
import com.intellibucket.lib.payload.payload.command.ProjectPayload;

public class ProjectMergeEvent extends AbstractDomainEvent<ProjectPayload> {
    protected ProjectMergeEvent(ProjectPayload payload){super(payload);}
    public static ProjectMergeEvent of(ProjectPayload payload){return  new ProjectMergeEvent(payload);}
}
