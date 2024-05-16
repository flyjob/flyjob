package com.intellibucket.lib.payload.payload;

import java.util.UUID;

public class ContactMergePayload extends Payload{
    private UUID contactid;
    public ContactMergePayload(UUID contactid){
        this.contactid = contactid;
    }
    public ContactMergePayload(){}
    public UUID getContactid() {
        return contactid;
    }
    public void setContactid(UUID contactid) {
        this.contactid = contactid;
    }

    public static ContactMergePayload of(UUID contactid) {
        return new ContactMergePayload(contactid);
    }
}
