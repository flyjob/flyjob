package az.rock.lib.domain.id.auth;

import az.rock.lib.domain.RootID;
import az.rock.lib.domain.id.IdReference;

import java.util.UUID;

public class PhoneNumberID  extends RootID<UUID> implements IdReference<UUID> {
    protected PhoneNumberID(UUID value) {
        super(value);
    }

    @Override
    public UUID getAbsoluteID() {
        return super.getRootID();
    }

    public static PhoneNumberID of(UUID value) {
        return new PhoneNumberID(value);
    }


}
