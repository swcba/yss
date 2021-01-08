package com.yss.democlient01;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication(scanBasePackages = "com.yss.democlient01")
@EnableDiscoveryClient
public class DemoClient01Application {

    public static void main(String[] args) {
        SpringApplication.run(DemoClient01Application.class, args);
    }

}
