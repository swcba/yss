package com.yss.student.service;
/****************************************************
 * 创建人：     @author shiwei1    
 * 创建时间: 2021/1/6/9:38
 * 项目名称：  demo-thymeleaf
 * 文件名称: null.java
 * 文件描述: @Description: (用一句话描述该文件做什么)
 *
 * All rights Reserved, Designed By 投资交易团队
 * @Copyright:2016-2021
 *
 ********************************************************/


import com.yss.student.dao.TestMapper;
import com.yss.student.entity.StudentInformation;
import com.yss.student.entity.Teacher;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 包名称：com.yss.student.service
 * 类名称：TestService
 * 类描述：
 * 创建人：@author shiwei1
 * 创建时间：2021/1/6/9:38
 */

@Service
public class TestService {

    @Resource
    private TestMapper testMapper;

    public List<Teacher> selectAllTeacher(){

        return testMapper.selectAllTeacher();
    }


    /**
     * @Description: 查询所有学生及他们的班级信息
     * @return: java.util.List<com.yss.student.entity.StudentInformation>
     * @throws
     * @author: shiwei1
     * @date:  2021/1/7/16:35
     */
    public List<StudentInformation> selectStudentAndClass(){

        return testMapper.selectStudentAndClass();
    }
    /**
     * @Description: 查询所有老师及他们的学生信息
     * @return: java.util.List<com.yss.student.entity.StudentInformation>
     * @throws
     * @author: shiwei1
     * @date:  2021/1/7/16:35
     */
    public List<StudentInformation> selectTeacherAndStudent(){

        return testMapper.selectTeacherAndStudent();
    }
}
