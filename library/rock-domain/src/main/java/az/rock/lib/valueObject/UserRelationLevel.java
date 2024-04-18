package az.rock.lib.valueObject;

import java.util.List;

public enum UserRelationLevel {
    NONE(List.of(AccessModifier.UNKNOWN)),
    BLOCKED(List.of(AccessModifier.UNKNOWN)),
    NETWORK(List.of(AccessModifier.PUBLIC, AccessModifier.AUTHENTICATED, AccessModifier.ONLY_NETWORK, AccessModifier.ONLY_FOLLOWERS_AND_NETWORK)),
    ONLY_FOLLOWING(List.of(AccessModifier.PUBLIC, AccessModifier.AUTHENTICATED, AccessModifier.ONLY_FOLLOWERS)),
    MUTUAL_FOLLOWING(List.of(AccessModifier.PUBLIC, AccessModifier.AUTHENTICATED, AccessModifier.ONLY_FOLLOWERS));

    private final List<AccessModifier> accessModifiers;

    UserRelationLevel(List<AccessModifier> accessModifiers) {
        this.accessModifiers = accessModifiers;
    }

    public List<AccessModifier> accessModifiers() {
        return accessModifiers;
    }
}
