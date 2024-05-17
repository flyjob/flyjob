package com.intellibucket.lib.payload.payload;

import java.math.BigInteger;
import java.time.ZonedDateTime;
import java.util.UUID;

public class ContactPayload {
    private UUID resumeId;
    private Integer orderNumber;
    private String data;

    public ContactPayload(UUID resumeId, Integer orderNumber, String data) {
        this.resumeId = resumeId;
        this.orderNumber = orderNumber;
        this.data = data;
    }

    private ContactPayload(Builder builder){
        resumeId=builder.resumeId;
        orderNumber= builder.orderNumber;
        data= builder.data;


    }

    public static final class Builder {
        private UUID resumeId;
        private Integer orderNumber;

        private String data;

        private Builder() {
        }

        public static Builder builder() {
            return new Builder();
        }

        public Builder id(UUID val) {
            resumeId = val;
            return this;
        }

        public Builder orderNumber(Integer val){
            orderNumber=val;
            return this;
        }

        public Builder data(String val){
            data=val;
            return this;
        }

        public ContactPayload build() { return new ContactPayload(this);
        }
    }
}

