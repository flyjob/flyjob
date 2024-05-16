package com.intellibucket.lib.payload.payload;

import java.util.UUID;

public class ContactUpdatePayload extends Payload{
    private UUID courseId;
    public ContactUpdatePayload(UUID courseId){
        this.courseId = courseId;
    }
    public ContactUpdatePayload(){}
    public UUID getCourseId() {
        return courseId;
    }
    public void setCourseId(UUID courseId) {
        this.courseId = courseId;
    }

    public static ContactUpdatePayload of(UUID courseId) {
        return new ContactUpdatePayload(courseId);
    }
}
