package az.rock.flyjob.js.domain.presentation.ports.input.services.command.concretes;

import az.rock.flyjob.js.domain.presentation.ports.input.services.command.abstracts.AbstractTestCommandDomainPresentationService;
import az.rock.lib.annotation.InputPort;
import com.intellibucket.lib.proto.UserRelationLevelResponse;
import com.intellibucket.lib.proto.UserRelationLevelServiceGrpc;
import io.grpc.stub.StreamObserver;
import lombok.extern.slf4j.Slf4j;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@InputPort
@Profile({"local", "develop", "pre-develop"})
@Slf4j
public class TestCommandDomainPresentationService implements AbstractTestCommandDomainPresentationService {

    @GrpcClient("authorization-rpc")
    private final UserRelationLevelServiceGrpc.UserRelationLevelServiceStub userRelationLevelServiceStub;

    public TestCommandDomainPresentationService(UserRelationLevelServiceGrpc.UserRelationLevelServiceStub userRelationLevelServiceStub) {
        this.userRelationLevelServiceStub = userRelationLevelServiceStub;
    }

    @Override
    public String testAuthorizationApiForRelation(UUID sourceUserId, UUID targetUserId) {
        var request = com.intellibucket.lib.proto.UserRelationLevelRequest.newBuilder()
                .setSourceUserId(sourceUserId.toString())
                .setTargetUserId(targetUserId.toString())
                .build();
        this.userRelationLevelServiceStub.fetchUserRelationLevel(request, new StreamObserver<UserRelationLevelResponse>() {
            @Override
            public void onNext(UserRelationLevelResponse value) {
                log.info("UserRelationLevelResponse: {}", value);
            }

            @Override
            public void onError(Throwable t) {
                log.error("Error: {}", t);
            }

            @Override
            public void onCompleted() {
                log.info("Completed");
            }
        });
        return "Okey";
    }
}
