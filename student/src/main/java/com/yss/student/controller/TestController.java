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
import com.yss.student.service.StudentClassService;
import com.yss.student.service.TestService;
import com.yss.student.vo.StudentClassAddVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
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


    @Resource
    private TestService testService;

    @Resource
    private StudentClassService studentClassService;

    @PostMapping
    @ApiOperation("查找所有老师")
    public List<Teacher> selectAllTeacher(){
        return testService.selectAllTeacher();
    }

    @PostMapping("/student")
    @ApiOperation("查找所有学生及班级信息")
    public List<StudentInformation> selectStudentAndClass(){
        return testService.selectStudentAndClass();
    }

    @PostMapping("/teacher")
    @ApiOperation("查找所有老师及班级")
    public List<StudentInformation> selectTeacherAndStudent(){
        return testService.selectTeacherAndStudent();
    }

    @PostMapping("/insert")
    @ApiOperation("添加学生班级信息")
    public String insert(@RequestBody @ApiParam StudentClassAddVO studentClassAddVO){
        return studentClassService.insertStudentClass(studentClassAddVO.valueOfStudentClass());
    }


}
