package com.intellibucket.onnetwork.exchange.domain.presentation.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;

@Configuration
@EnableAsync
@Slf4j
public class AsyncConfig {
    {
        log.info("AsyncConfig initialized");
    }
}
