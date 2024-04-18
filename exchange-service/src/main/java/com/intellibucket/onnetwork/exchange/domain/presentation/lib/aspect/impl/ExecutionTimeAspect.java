package com.intellibucket.onnetwork.exchange.domain.presentation.lib.aspect.impl;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class ExecutionTimeAspect {

    @Around("@annotation(com.intellibucket.onnetwork.exchange.domain.presentation.lib.aspect.annotations.JExecutionTime)")
    public Object logExecutionTime(ProceedingJoinPoint proceedingJoinPoint) {
        log.info("Execution time aspect is called for {}", proceedingJoinPoint.getSignature().getName());
        long start = System.currentTimeMillis();
        Object proceed = null;
        try {
            proceed = proceedingJoinPoint.proceed();
        } catch (Throwable throwable) {
            log.error("Error in execution time aspect for {}, {}", throwable, proceedingJoinPoint.getSignature().getName());
        }
        long executionTime = System.currentTimeMillis() - start;
        log.info("{} executed in {} ms", proceedingJoinPoint.getSignature().getName(), executionTime);
        log.info("Execution time aspect is completed for {}", proceedingJoinPoint.getSignature().getName());
        return proceed;
    }

}
