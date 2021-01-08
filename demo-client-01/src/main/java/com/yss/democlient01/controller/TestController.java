package com.yss.democlient01.controller;
/****************************************************
 * 创建人：     @author shiwei1    
 * 创建时间: 2021/1/6/13:44
 * 项目名称：  demo-thymeleaf
 * 文件名称: null.java
 * 文件描述: @Description: (用一句话描述该文件做什么)
 *
 * All rights Reserved, Designed By 投资交易团队
 * @Copyright:2016-2021
 *
 ********************************************************/


import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

/**
 * 包名称：com.yss.democlient.controller
 * 类名称：TestController
 * 类描述：
 * 创建人：@author shiwei1
 * 创建时间：2021/1/6/13:44
 */
@RestController
@RequestMapping("/getInfo")
public class TestController {

    @Value("${server.port}")
    String port;

    @Value("${spring.application.name}")
    String serviceName;

    @RequestMapping("/show")
    public String getInfo() {
        return "I'm form service:" + serviceName + ",port:" + port;
    }

    @RequestMapping(value = "no/{no}", method = RequestMethod.GET)
    public String getPolicyFileByPolicyNo(@PathVariable String no, HttpServletResponse httpServletResponse) {

        try {
            String result = "I'm form service:" + serviceName + ",port:" + port;
            if (result == null) {
                httpServletResponse.setStatus(HttpServletResponse.SC_NOT_FOUND);
                return null;
            } else {
                return result;
            }
        } catch (Exception e) {
            e.printStackTrace();
            httpServletResponse.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            return e.getMessage();
        }
    }

    @RequestMapping("/port")
    public String findInfo() {
        return "I'm form service:" + serviceName + ",port:" + port;
    }


}
