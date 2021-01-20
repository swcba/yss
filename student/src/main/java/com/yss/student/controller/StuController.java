/****************************************************
 * 创建人：     @author shiwei1
 * 创建时间: 2020年12月30日/上午8:55:49
 * 项目名称：  student
 * 文件名称: StuController.java
 * 文件描述: @Description: TODO(用一句话描述该文件做什么)
 *
 * All rights Reserved, Designed By 投资交易团队
 * @Copyright:2016-2020
 *
 ********************************************************/

package com.yss.student.controller;


import java.util.List;

import com.yss.student.entity.StudentInformation;
import com.yss.student.vo.StudentAddVO;
import com.yss.student.vo.StudentUpdateVO;
import com.yss.student.service.StudentService;

import io.swagger.annotations.*;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 包名称： com.yss.student.controller 类名称：StuController 类描述：TODO 创建人：@author
 * shiwei1 创建时间：2020年12月30日/上午8:55:49
 */
@Service
@Api(tags = "学生信息接口")
@RestController
@RequestMapping("/user")
@CrossOrigin(origins = {"http://localhost:3000"}, allowCredentials = "true", allowedHeaders = {"X-Custom-Header"},
        maxAge = 3600L, methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.HEAD})
public class StuController {
    @Resource
    private StudentService service;

    @ApiOperation("查找所有学生接口")
    @GetMapping("/all")
    public List<StudentInformation> selectAllStudent() {
        return service.selectStudentAndClass();
    }

    @ApiOperation("查询未被刪除学生接口")
    @PostMapping("/allStudent")
    public List<StudentInformation> selectStudentByDeleteFlag() {
        return service.selectStudentByDeleteFlag();
    }

    @ApiOperation("根据id查找学生接口")
    @PostMapping("/id")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "学生id", defaultValue = "1")})
    public List<StudentInformation> selectStudentById(@RequestParam String id) {
        return service.selectStudentById(Integer.valueOf(id));
    }

    @ApiOperation("根据姓名查找学生接口")
    @PostMapping("/name")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "studentName", value = "姓名", defaultValue = " ")})
    public List<StudentInformation> selectStudentByName(@RequestParam String studentName) {
        return service.selectStudentByName(studentName);

    }

    @ApiOperation("根据姓名模糊查找学生接口")
    @PostMapping("/namelike")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "studentName", value = "姓名", defaultValue = " ")})
    public List<StudentInformation> selectStudentNameByLike(@RequestParam String studentName) {
        return service.selectStudentNameByLike(studentName);
    }

    @ApiOperation("根据姓名模糊查找学生接口2")
    @PostMapping("/namelike2")
    public List<StudentInformation> selectStudentNameByLike(@RequestBody @ApiParam(name = "StuentVO") StudentAddVO student) {
        return service.selectStudentNameByLike(student.getStudentName());
    }

    @ApiOperation("根据id删除学生接口")
    @PostMapping("/deleteid")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "学生id", defaultValue = "1")})
    public String deleteStudent(@RequestParam String id) {
        return service.deleteStudent(Integer.valueOf(id));
    }

    @ApiOperation("更改学生信息接口")
    @PostMapping("/update")
    public String upadateStudentByName(@RequestBody @ApiParam("更改学生信息") StudentUpdateVO studentUpdateVO) {
        return service.updateStudent(studentUpdateVO);
    }

    @ApiOperation("添加学生信息接口")
    @PostMapping("/insert")
    public String insertStudent(@RequestBody @ApiParam(value = "添加学生") StudentAddVO studentAddVO) {
        return  service.insert(studentAddVO);
    }

    @ApiOperation("查找某年龄段的学生")
    @PostMapping("/agebetween")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "startAge", value = "起始年龄", defaultValue = "1", dataType = "Integer"),
            @ApiImplicitParam(name = "endAge", value = "终止年龄", defaultValue = "1", dataType = "Integer")})
    public List<StudentInformation> selectStudentAgeBetween(@RequestParam Integer startAge, @RequestParam Integer endAge) {
        return service.selectStudentAgeBetween(startAge, endAge);
    }

    @ApiOperation("查找班级的学生信息")
    @PostMapping("/studentandclass")
    @ApiImplicitParam(name = "className", value = "班级名称", defaultValue = "1405", dataType = "String")
    public List<StudentInformation> selectStudentAndClass(@RequestParam String className){
        return service.selectStudentByClassName(className);
    }
}
