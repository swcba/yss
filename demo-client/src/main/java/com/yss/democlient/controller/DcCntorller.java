package com.yss.democlient.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author shiwei
 * @date 2020/12/22
 */

@RestController
@RequestMapping("/user")
public class DcCntorller {

    @Autowired
    DiscoveryClient discoveryClient;

    @GetMapping("/dc")
    public String dc() {
        String services = "Services:" + discoveryClient.getServices();
        System.out.println(services);
        return services;
    }

    @GetMapping("/hello")
    public String Test() {

        return "Hello";
    }
}
