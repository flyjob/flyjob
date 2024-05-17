package com.intellibucket.lib.payload.payload;

import java.util.UUID;

public class ContactDeletePayload extends Payload{
    private UUID Id;
    public ContactDeletePayload(UUID Id){
        this.Id = Id;
    }
    public ContactDeletePayload(){}
    public UUID getContactId() {
        return Id;
    }
    public void setContactId(UUID courseId) {
        this.Id = courseId;
    }

    public static ContactDeletePayload of(UUID Id) {
        return new ContactDeletePayload(Id);
    }
}
