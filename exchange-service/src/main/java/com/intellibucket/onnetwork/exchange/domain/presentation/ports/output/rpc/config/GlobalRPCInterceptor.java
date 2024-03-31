package com.intellibucket.onnetwork.exchange.domain.presentation.ports.output.rpc.config;

import io.grpc.*;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class GlobalRPCInterceptor implements ClientInterceptor {
    @Override
    public <ReqT, RespT> ClientCall<ReqT, RespT> interceptCall(MethodDescriptor<ReqT, RespT> method, CallOptions callOptions, Channel next) {
        log.info("Intercepted call to method: {}", method.getFullMethodName());
        return next.newCall(method, callOptions);
    }
}
