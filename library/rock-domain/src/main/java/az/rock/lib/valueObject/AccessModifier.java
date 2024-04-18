package az.rock.lib.valueObject;

import az.rock.lib.annotation.ValueObject;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Arrays;
import java.util.List;

@ValueObject
public enum AccessModifier {
    PUBLIC(0),
    AUTHENTICATED(1),
    ONLY_FOLLOWERS(2),
    ONLY_FOLLOWERS_AND_NETWORK(3),
    ONLY_NETWORK(4),
    PRIVATE(5),
    UNKNOWN(6);
    private final Integer senstivity;

    private AccessModifier(Integer senstivity) {
        this.senstivity = senstivity;
    }


    @JsonIgnore
    public Integer getSenstivity() {
        return senstivity;
    }

    public static List<AccessModifier> fetchAll() {
        return Arrays.asList(AccessModifier.PUBLIC, AccessModifier.AUTHENTICATED, AccessModifier.ONLY_FOLLOWERS_AND_NETWORK, AccessModifier.ONLY_NETWORK, AccessModifier.PRIVATE);
    }
    public static AccessModifier find(Integer senstivity) {
        return Arrays.stream(AccessModifier.values())
                .filter(accessModifier -> accessModifier.getSenstivity().equals(senstivity))
                .findFirst()
                .orElse(UNKNOWN);
    }

    @JsonIgnore
    public boolean isPublic() {
        return this == PUBLIC;
    }

    @JsonIgnore
    public boolean isAuthenticated() {
        return this == AUTHENTICATED;
    }

    @JsonIgnore
    public boolean isOnlyNetwork() {
        return this == ONLY_NETWORK;
    }

    @JsonIgnore
    public boolean isOnlyFollowersAndNetworks() {
        return this == ONLY_FOLLOWERS_AND_NETWORK;
    }

    @JsonIgnore
    public boolean isPrivate() {
        return this == PRIVATE;
    }

    @JsonIgnore
    public boolean isUnknown() {
        return this == UNKNOWN;
    }


}
