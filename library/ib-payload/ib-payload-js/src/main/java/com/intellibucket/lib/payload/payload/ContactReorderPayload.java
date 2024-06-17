package com.intellibucket.lib.payload.payload;

import java.util.UUID;

public class ContactReorderPayload extends Payload{
    private UUID contactid;
    public ContactReorderPayload(UUID contactid){
        this.contactid = contactid;
    }
    public ContactReorderPayload(){}
    public UUID getContactid() {
        return contactid;
    }
    public void setContactid(UUID contactid) {
        this.contactid = contactid;
    }
    public static ContactReorderPayload of(UUID contactid) {
        return new ContactReorderPayload(contactid);
    }
}
