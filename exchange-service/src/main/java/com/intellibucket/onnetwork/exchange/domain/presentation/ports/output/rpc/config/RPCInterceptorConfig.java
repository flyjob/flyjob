package com.intellibucket.onnetwork.exchange.domain.presentation.ports.output.rpc.config;

import net.devh.boot.grpc.client.interceptor.GrpcGlobalClientInterceptor;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RPCInterceptorConfig {
    @GrpcGlobalClientInterceptor
    public GlobalRPCInterceptor logClientInterceptor() {
        return new GlobalRPCInterceptor();
    }
}
