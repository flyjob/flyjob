package az.rock.lib.domain.id.exchange;

import az.rock.lib.domain.RootID;
import az.rock.lib.domain.id.IdReference;

import java.util.UUID;

public class ExchangeID extends RootID<UUID> implements IdReference<UUID> {
    protected ExchangeID(UUID value) {
        super(value);
    }

    @Override
    public UUID getAbsoluteID() {
        return super.getRootID();
    }
}
