package az.rock.spec.auth.privates.command;

import az.rock.lib.jresponse.response.success.JSuccessResponse;
import org.springframework.http.ResponseEntity;

import java.util.UUID;

public interface FollowCommandPrivateSpec {
    ResponseEntity<JSuccessResponse> follow(UUID userID);
    ResponseEntity<JSuccessResponse> unfollow(UUID userID);

}
