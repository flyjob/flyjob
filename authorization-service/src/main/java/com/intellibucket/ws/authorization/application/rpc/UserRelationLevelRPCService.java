package com.intellibucket.ws.authorization.application.rpc;

import com.intellibucket.lib.proto.UserRelationLevelRequest;
import com.intellibucket.lib.proto.UserRelationLevelResponse;
import com.intellibucket.lib.proto.UserRelationLevelServiceGrpc;
import io.grpc.stub.StreamObserver;
import lombok.extern.slf4j.Slf4j;
import net.devh.boot.grpc.server.service.GrpcService;

@Slf4j
@GrpcService
public class UserRelationLevelRPCService extends UserRelationLevelServiceGrpc.UserRelationLevelServiceImplBase {
    @Override
    public void fetchUserRelationLevel(UserRelationLevelRequest request, StreamObserver<UserRelationLevelResponse> responseObserver) {
        log.info("fetchUserRelationLevel request: {}", request);
        UserRelationLevelResponse response = UserRelationLevelResponse.newBuilder().setRelationLevel("PUBLIC").build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}
