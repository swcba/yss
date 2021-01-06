package com.yss.student.controller;/****************************************************
 * 创建人：     @author shiwei1    
 * 创建时间: 2020/12/30/17:25
 * 项目名称：  IDEA_workspace
 * 文件名称: null.java
 * 文件描述: @Description: (用一句话描述该文件做什么)
 *
 * All rights Reserved, Designed By 投资交易团队
 * @Copyright:2016-2020
 *
 ********************************************************/


import com.yss.student.entity.StudentInformation;
import com.yss.student.entity.Teacher;
import com.yss.student.service.StudentService;
import com.yss.student.service.TestService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 包名称：com.yss.student.controller
 * 类名称：TestController
 * 类描述：
 * 创建人：@author shiwei1
 * 创建时间：2020/12/30/17:25
 */
@RestController
@Api("测试接口")
@RequestMapping("test")
public class TestController {

    @Autowired
    private StudentService studentService;

    @Autowired
    private TestService testService;

    public List<StudentInformation> selectAllStudent(){

        return studentService.selectAllStudent();
    }

    @PostMapping
    @ApiOperation("测试方法")
    public List<Teacher> selectAllTeacher(){

        return testService.selectAllTeacher();
    }

}
