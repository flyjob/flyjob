package com.intellibucket.onnetwork;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class FileSystemServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(FileSystemServiceApplication.class, args);
    }
}