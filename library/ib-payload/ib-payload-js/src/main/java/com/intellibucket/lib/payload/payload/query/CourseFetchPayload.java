package com.intellibucket.lib.payload.payload.query;

import com.intellibucket.lib.payload.payload.Payload;

public class CourseFetchPayload<T> extends Payload {
    private T payload;

    public CourseFetchPayload(T payload) {
        this.payload = payload;
    }

    public CourseFetchPayload() {
    }

    public T getPayload() {
        return payload;
    }

    public void setPayload(T payload) {
        this.payload = payload;
    }

    public static CourseFetchPayload of(Object payload) {
        return new CourseFetchPayload(payload);
    }
}
