package com.intellibucket.lib.payload.event.command.delete;

import com.intellibucket.lib.payload.event.abstracts.AbstractSuccessDomainEvent;
import com.intellibucket.lib.payload.event.abstracts.Event;
import com.intellibucket.lib.payload.payload.command.CourseDeletedPayload;

@Event
public class CourseDeleteEvent extends AbstractSuccessDomainEvent<CourseDeletedPayload> {
    public CourseDeleteEvent(CourseDeletedPayload payload) {
        super(payload);
    }

    public static CourseDeleteEvent of(CourseDeletedPayload payload){
        return new CourseDeleteEvent(payload);
    }
}
