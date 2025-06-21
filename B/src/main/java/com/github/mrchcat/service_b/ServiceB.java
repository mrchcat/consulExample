package com.github.mrchcat.service_b;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ServiceB {
    public static void main(String[] args) {
        SpringApplication.run(ServiceB.class, args);
    }
}
