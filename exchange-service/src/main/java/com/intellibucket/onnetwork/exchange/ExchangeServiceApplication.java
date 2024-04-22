package com.intellibucket.onnetwork.exchange;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableDiscoveryClient
@SpringBootApplication
@EnableFeignClients
@EntityScan(basePackages = "com/intellibucket/onnetwork/exchange/dataaccess/model/entity")
public class ExchangeServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(ExchangeServiceApplication.class, args);
    }
}