package com.yss.ribbon.controller;/****************************************************
 * 创建人：     @author shiwei1    
 * 创建时间: 2021/1/6/14:52
 * 项目名称：  demo-thymeleaf
 * 文件名称: null.java
 * 文件描述: @Description: (用一句话描述该文件做什么)
 *
 * All rights Reserved, Designed By 投资交易团队
 * @Copyright:2016-2021
 *
 ********************************************************/


import com.yss.ribbon.service.RibbonService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 包名称：com.yss.ribbon.controller
 * 类名称：Controller
 * 类描述：
 * 创建人：@author shiwei1
 * 创建时间：2021/1/6/14:52
 */

@RestController
@RequestMapping("/getInfo")
public class Controller {

    @Autowired
    RibbonService ribbonService;

    private static final Logger logger = LoggerFactory.getLogger(Controller.class);


    @Value("${server.port}")
    String port;

    @Value("${spring.application.name}")
    String serviceName;

    @RequestMapping("/show")
    public String getInfo(){
        return "I'm form service:"+serviceName+",port:"+port;
    }

    @RequestMapping("/hellol")
    public String showInfol(){
        System.out.println("find port");
        logger.info("find port");
        return ribbonService.port();

    }

}
