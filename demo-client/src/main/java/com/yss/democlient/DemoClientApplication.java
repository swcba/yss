package com.yss.democlient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author shiwei
 * @date 2020/12/22
 */


@EnableDiscoveryClient
@SpringBootApplication(scanBasePackages = "com.yss.democlient")
public class DemoClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoClientApplication.class, args);
    }

}
