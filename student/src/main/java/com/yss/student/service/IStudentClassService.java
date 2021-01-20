package com.yss.student.service;/****************************************************
 * 创建人：     @author shiwei1    
 * 创建时间: 2021/1/20/13:31
 * 项目名称：  demo-thymeleaf
 * 文件名称: null.java
 * 文件描述: @Description: 学生班级信息功能接口(用一句话描述该文件做什么)
 *
 * All rights Reserved, Designed By 投资交易团队
 * @Copyright:2016-2021
 *
 ********************************************************/


import com.yss.student.entity.StudentClass;
import com.yss.student.entity.StudentInformation;

/**
 * 包名称：com.yss.student.service
 * 接口名称：IStudentClassService
 * 接口描述：学生班级信息功能接口
 * 创建人：@author shiwei1
 * 创建时间：2021/1/20/13:31
 */
public interface IStudentClassService {

    /**
     * @throws
     * @Description: 插入学生班级信息
     * @return: int
     * @author: shiwei1
     * @date: 2021/1/7/17:42
     */
     String insertStudentClass(StudentClass studentClass);



    /**
     * @throws
     * @Description: 删除学生的班级信息
     * @return:
     * @author: shiwei1
     * @date: 2021/1/7/17:55
     */
     String deleteStudentAndClass(StudentInformation studentInformation);



    /**
     * @param studentId
     * @throws
     * @Title:
     * @Description: 查找班级与学生的关系
     * @return: com.yss.student.entity.StudentClass
     * @author: shiwei1
     * @date: 2021/1/18/15:10
     */
     StudentClass selectStudentClass(Integer studentId);
}
