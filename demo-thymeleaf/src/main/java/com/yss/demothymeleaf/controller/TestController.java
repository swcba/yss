package com.yss.demothymeleaf.controller;/****************************************************
 * 创建人：     @author shiwei1    
 * 创建时间: 2021/1/4/15:10
 * 项目名称：  IDEA_workspace
 * 文件名称: null.java
 * 文件描述: @Description: (用一句话描述该文件做什么)
 *
 * All rights Reserved, Designed By 投资交易团队
 * @Copyright:2016-2021
 *
 ********************************************************/


import com.yss.demothymeleaf.entity.StudentInformation;
import com.yss.demothymeleaf.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 包名称：com.yss.demothymeleaf.controller
 * 类名称：TestController
 * 类描述：
 * 创建人：@author shiwei1
 * 创建时间：2021/1/4/15:10
 */

@RestController
@RequestMapping("/student")
@CrossOrigin(origins = {"http://localhost:3000"},allowCredentials = "true",allowedHeaders = {"X-Custom-Header"},
        maxAge = 3600L, methods={RequestMethod.GET,RequestMethod.POST,RequestMethod.HEAD})
public class TestController {
    @Autowired
    private StudentService service;

    @GetMapping
    public List<StudentInformation> selectAllStudent(){

        return service.selectAllStudent();
    }
}
