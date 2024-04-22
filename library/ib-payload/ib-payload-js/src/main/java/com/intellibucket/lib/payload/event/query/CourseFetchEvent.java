package com.intellibucket.lib.payload.event.query;

import com.intellibucket.lib.payload.event.abstracts.AbstractSuccessDomainEvent;
import com.intellibucket.lib.payload.event.abstracts.Event;
import com.intellibucket.lib.payload.payload.query.CourseFetchPayload;


@Event
public class CourseFetchEvent extends AbstractSuccessDomainEvent<CourseFetchPayload> {
    public CourseFetchEvent() {}

    public CourseFetchEvent(CourseFetchPayload root) {
        super(root);
    }

    public static CourseFetchEvent of(CourseFetchPayload payload){
        return new CourseFetchEvent(payload);
    }
}
