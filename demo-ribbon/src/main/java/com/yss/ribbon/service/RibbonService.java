package com.yss.ribbon.service;/****************************************************
 * 创建人：     @author shiwei1    
 * 创建时间: 2021/1/6/14:49
 * 项目名称：  demo-thymeleaf
 * 文件名称: null.java
 * 文件描述: @Description: (用一句话描述该文件做什么)
 *
 * All rights Reserved, Designed By 投资交易团队
 * @Copyright:2016-2021
 *
 ********************************************************/


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * 包名称：com.yss.ribbon.service
 * 类名称：RibbonService
 * 类描述：
 * 创建人：@author shiwei1
 * 创建时间：2021/1/6/14:49
 */
@Service
public class RibbonService implements IRibbonService{
    @Autowired
    RestTemplate restTemplate;

    @Autowired
    LoadBalancerClient loadBalancerClient;

    public String port() {
        this.loadBalancerClient.choose("demo-client01");
        String info = restTemplate.getForObject("http://demo-client01/getInfo/port", String.class);
        return restTemplate.getForObject("http://demo-client01/getInfo/port", String.class);
    }

}
