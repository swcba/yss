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


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yss.student.entity.StudentInformation;
import io.swagger.annotations.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.yss.student.service.StudentService;

import org.springframework.web.bind.annotation.*;

/**
 * 包名称： com.yss.student.controller 类名称：StuController 类描述：TODO 创建人：@author
 * shiwei1 创建时间：2020年12月30日/上午8:55:49
 */
@Service
@Api(tags = "学生信息接口")
@RestController
@RequestMapping("/user")
@CrossOrigin(origins = {"http://localhost:3000"},allowCredentials = "true",allowedHeaders = {"X-Custom-Header"},
        maxAge = 3600L, methods={RequestMethod.GET,RequestMethod.POST,RequestMethod.HEAD})
public class StuController {

    @Autowired
    private StudentService service;


    /**
     * @return
     * @throws @author: shiwei1
     * @Title: selectAllStudent
     * @Description: TODO(这里用一句话描述这个方法的作用)
     * @return: List<StudentInformation>
     * @Date: 2020年12月30日/上午9:11:59
     */
    @ApiOperation("查找所有学生接口")
    @GetMapping("/all")
    public List<StudentInformation> selectAllStudent() {

        return service.selectAllStudent();
    }



    /**
     * @return
     * @throws @author: shiwei1
     * @Title: selectStudentByID
     * @Description: 查询未被删除的学生
     * @return: List<StudentInformation>
     * @Date: 2020年12月30日/上午9:12:03
     */
    @ApiOperation("查询未被刪除学生接口")
    @PostMapping("/allStudent")
    public List<StudentInformation> selectStudentByDeleteFlag() {
        return service.selectStudentByDeleteFlag();
    }

    /**
     * @param id
     * @return
     * @throws @author: shiwei1
     * @Title: selectStudentByID
     * @Description: 根据id查找学生
     * @return: List<StudentInformation>
     * @Date: 2020年12月30日/上午9:15:19
     */
    @ApiOperation("根据id查找学生接口")
    @PostMapping("/id")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "学生id", defaultValue = "1")})
    public List<StudentInformation> selectStudentByID(@RequestParam String id) {

        return service.selectStudentByID(Integer.valueOf(id));
    }


    /**
     * @param studentName
     * @return
     * @throws @author: shiwei1
     * @Title: selectStudentByName
     * @Description: 根据学生姓名查找学生
     * @return: List<StudentInformation>
     * @Date: 2020年12月30日/上午9:18:47
     */
    @ApiOperation("根据姓名查找学生接口")
    @PostMapping("/name")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "studentName", value = "姓名", defaultValue = " ")})
    public List<StudentInformation> selectStudentByName(@RequestParam String studentName) {


        return service.selectStudentByName(studentName);

    }

    /**
     * @param studentName
     * @return
     * @throws @author: shiwei1
     * @Title: selectStudentByLike
     * @Description: 根据学生姓名模糊查找学生
     * @return: List<StudentInformation>
     * @Date: 2020年12月30日/上午9:20:04
     */
    @ApiOperation("根据姓名模糊查找学生接口")
    @PostMapping("/namelike")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "studentName", value = "姓名", defaultValue = " ")})
    public List<StudentInformation> selectStudentNameByLike(@RequestParam String studentName) {

        return service.selectStudentNameByLike(studentName);

    }

    /**
     * @param id
     * @return
     * @throws @author: shiwei1
     * @Title: deleteStudent
     * @Description: 更改deleteFlag删除学生
     * @return: int
     * @Date: 2020年12月30日/上午9:27:07
     */
    @ApiOperation("根据id删除学生接口")
    @PostMapping("/deleteid")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "学生id", defaultValue = "1")})
    public int deleteStudent(@RequestParam String id) {


        return service.deleteStudent(Integer.valueOf(id));

    }

    /**
     * @param studentName
     * @param id
     * @return
     * @throws @author: shiwei1
     * @Title: upadateStudentByName
     * @Description: 更改学生信息
     * @return: int
     * @Date: 2020年12月30日/上午9:36:52
     */
    @ApiOperation("更改学生信息接口")
    @PostMapping("/update")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "studentName", value = "学生姓名")
            , @ApiImplicitParam(name = "age", value = "学生年龄")
            , @ApiImplicitParam(name = "id", value = "学生id")})
    public int upadateStudentByName(@RequestParam String studentName, @RequestParam String age, @RequestParam String id) {
        System.out.println(id + "==============");
        return service.upadateStudentByName(studentName, Integer.valueOf(age), Integer.valueOf(id));

    }


    /**
     * @param studentName
     * @param age
     * @throws
     * @Title:
     * @Description: ${todo}(这里用一句话描述这个方法的作用)
     * @return: int
     * @author: shiwei1
     * @date: 2020/12/31/14:02
     */
    @ApiOperation("添加学生信息接口")
    @PostMapping("/insert")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "studentName", value = "学生姓名"),
            @ApiImplicitParam(name = "age", value = "学生年龄", dataType = "Integer"),
            @ApiImplicitParam(name = "teacher", value = "老师姓名"),
            @ApiImplicitParam(name = "grade", value = "成绩")})
    public int insertStudent(@RequestParam String studentName, @RequestParam Integer age,
                             @RequestParam String teacherName, @RequestParam String grade) {


        return service.insert(studentName, age, teacherName, grade);

    }


    /**
     * @param startAge
     * @param endAge
     * @throws
     * @Title:
     * @Description: 查找某年龄段的学生
     * @return: java.util.List<com.yss.student.entity.StudentInformation>
     * @author: shiwei1
     * @date: 2021/1/4/13:11
     */
    @ApiOperation("查找某年龄段的学生")
    @PostMapping("/agebetween")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "startAge", value = "起始年龄", defaultValue = "1", dataType = "Integer"),
            @ApiImplicitParam(name = "endAge", value = "终止年龄", defaultValue = "1", dataType = "Integer")})
    public List<StudentInformation> selectStudentAgeBetween(@RequestParam Integer startAge, @RequestParam Integer endAge) {

        return service.selectStudentAgeBetween(startAge, endAge);
    }
}
