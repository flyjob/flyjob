package az.rock.lib.domain.id.js;

import az.rock.lib.domain.RootID;
import az.rock.lib.domain.id.IdReference;

import java.util.UUID;

public class ContactID extends RootID<UUID> implements IdReference<UUID> {

    public static final ContactID NULL = new ContactID(null);
    protected ContactID(UUID value) {
        super(value);
    }

    @Override
    public UUID getAbsoluteID() {
        return super.getRootID();
    }

    public static ContactID of(UUID value){
        return new ContactID(value);
    }

//    @Override
//    public boolean equals(Object o) {
//        if (o == null) return false;
//        if (this == o) return true;
//        if (!(o instanceof ContactID)) return false;
//        return this.getAbsoluteID().equals(((ContactID)o).getAbsoluteID());
//    }
}
