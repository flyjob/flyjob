package com.intellibucket.lib.payload.event.command.create;

import com.intellibucket.lib.payload.event.abstracts.AbstractStartDomainEvent;
import com.intellibucket.lib.payload.event.abstracts.Event;
import com.intellibucket.lib.payload.payload.command.CourseFilePayload;


@Event
public class CourseCertificateUploadedEvent extends AbstractStartDomainEvent<CourseFilePayload> {
    public CourseCertificateUploadedEvent() {}

    public CourseCertificateUploadedEvent(CourseFilePayload root) {
        super(root);
    }

    public static CourseCertificateUploadedEvent of(CourseFilePayload payload){
        return new CourseCertificateUploadedEvent(payload);
    }
}
