package az.rock.lib.valueObject;

import az.rock.lib.annotation.ValueObject;

import java.util.UUID;

@ValueObject
public class SimpleContext {
    private UUID targetId;
    private String context;
}
