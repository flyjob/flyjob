package com.intellibucket.lib.payload.payload.command;

import com.intellibucket.lib.payload.payload.Payload;

import java.util.UUID;

public class CourseMergePayload extends Payload {
    private UUID courseId;

    public CourseMergePayload(UUID courseId) {
        this.courseId = courseId;
    }

    public CourseMergePayload() {
    }

    public UUID getCourseId() {
        return courseId;
    }

    public void setCourseId(UUID courseId) {
        this.courseId = courseId;
    }

    public static CourseMergePayload of(UUID courseId) {
        return new CourseMergePayload(courseId);
    }
}
