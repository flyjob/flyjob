package com.intellibucket.onnetwork.exchange.domain.presentation.ports.output.rpc.config;

import com.intellibucket.lib.proto.UserRelationLevelServiceGrpc;
import net.devh.boot.grpc.client.inject.GrpcClient;
import net.devh.boot.grpc.client.inject.GrpcClientBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@GrpcClientBean(
        clazz = UserRelationLevelServiceGrpc.UserRelationLevelServiceStub.class,
        beanName = "userRelationLevelServiceStub",
        client = @GrpcClient("authorization-rpc")
)
public class GRPCAuthorizationConfig {

    @Bean
    public UserRelationLevelServiceGrpc.UserRelationLevelServiceStub userRelationLevelServiceStub() {
        return null;
    }

}
