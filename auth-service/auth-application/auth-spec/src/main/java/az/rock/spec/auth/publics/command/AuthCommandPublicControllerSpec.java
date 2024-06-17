package az.rock.spec.auth.publics.command;

import az.rock.auth.domain.presentation.dto.request.CreateUserCommand;
import az.rock.auth.domain.presentation.dto.response.CreateUserResponse;
import az.rock.lib.jresponse.response.success.JSuccessDataResponse;
import az.rock.lib.jresponse.response.success.JSuccessResponse;
import org.springframework.http.ResponseEntity;


public interface AuthCommandPublicControllerSpec {
    ResponseEntity<JSuccessResponse> live();

    ResponseEntity<JSuccessResponse> userRegistry(CreateUserCommand credentials);

    ResponseEntity<JSuccessResponse> companyRegistry(CreateUserCommand credentials);

    ResponseEntity<JSuccessDataResponse<?>> forgotPassword(String email);
}