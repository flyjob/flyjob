package az.rock.lib.domain.id.mail;

import az.rock.lib.domain.RootID;
import az.rock.lib.domain.id.IdReference;

import java.util.UUID;

public class MailContentID extends RootID<UUID> implements IdReference<UUID> {
    protected MailContentID(UUID value) {
        super(value);
    }

    @Override
    public UUID getAbsoluteID() {
        return super.getRootID();
    }
}
