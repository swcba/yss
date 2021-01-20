package com.yss.student.service;
/****************************************************
 * 创建人：     @author shiwei1    
 * 创建时间: 2021/1/20/11:57
 * 项目名称：  demo-thymeleaf
 * 文件名称: null.java
 * 文件描述: @Description: 提供基本的增删改查功能
 *
 * All rights Reserved, Designed By 投资交易团队
 * @Copyright:2016-2021
 *
 ********************************************************/


import com.yss.student.entity.StudentInformation;
import com.yss.student.vo.StudentAddVO;
import com.yss.student.vo.StudentUpdateVO;

import java.util.List;

/**
 * 包名称：com.yss.student.service
 * 接口名称：BaseService
 * 接口描述：提供基本的增删改查功能
 * 创建人：@author shiwei1
 * 创建时间：2021/1/20/11:57
 */
public interface IStudentService {

    /**
     * 查询所有学生
     *
     * @param
     * @throws
     * @Title:
     * @return: java.util.List<com.yss.student.entity.StudentInformation>
     * @author: shiwei1
     * @date: 2021/1/20/12:00
     */
    List<StudentInformation> selectStudentAndClass();

    /**
     * 查询未被删除的学生
     *
     * @param
     * @throws
     * @Title:
     * @return: java.util.List<com.yss.student.entity.StudentInformation>
     * @author: shiwei1
     * @date: 2021/1/20/13:16
     */
    List<StudentInformation> selectStudentByDeleteFlag();

    /**
     * 根据id查找学生
     *
     * @param id
     * @throws
     * @Title:
     * @return: java.util.List<com.yss.student.entity.StudentInformation>
     * @author: shiwei1
     * @date: 2021/1/20/13:16
     */
    List<StudentInformation> selectStudentById(int id);

    /**
     * 根据学生姓名查找学生
     *
     * @param name
     * @throws
     * @Title:
     * @return: java.util.List<com.yss.student.entity.StudentInformation>
     * @author: shiwei1
     * @date: 2021/1/20/13:17
     */
    List<StudentInformation> selectStudentByName(String name);

    /**
     * 根据学生姓名模糊查找学生
     *
     * @param name
     * @throws
     * @Title:
     * @return: java.util.List<com.yss.student.entity.StudentInformation>
     * @author: shiwei1
     * @date: 2021/1/20/13:17
     */
    List<StudentInformation> selectStudentNameByLike(String name);

    /**
     * 更改deleteFlag删除学生
     *
     * @param id
     * @throws
     * @Title:
     * @return: java.lang.String
     * @author: shiwei1
     * @date: 2021/1/20/13:18
     */
    String deleteStudent(int id);

    /**
     * 更改学生信息
     *
     * @param studentUpdateVO
     * @throws
     * @Title:
     * @return: java.lang.String
     * @author: shiwei1
     * @date: 2021/1/20/13:19
     */
    String updateStudent(StudentUpdateVO studentUpdateVO);

    /**
     * 添加学生
     *
     * @param studentAddVO
     * @throws
     * @Title:
     * @return: java.lang.String
     * @author: shiwei1
     * @date: 2021/1/20/13:20
     */
    String insert(StudentAddVO studentAddVO);

    /**
     * 根据班级查找学生
     *
     * @param className
     * @throws
     * @Title:
     * @return: java.util.List<com.yss.student.entity.StudentInformation>
     * @author: shiwei1
     * @date: 2021/1/20/13:20
     */
    List<StudentInformation> selectStudentByClassName(String className);

    /**
     * 查找某个年龄段的学生
     *
     * @param startAge
     * @param endAge
     * @throws
     * @Title:
     * @return: java.util.List<com.yss.student.entity.StudentInformation>
     * @author: shiwei1
     * @date: 2021/1/20/13:21
     */
    List<StudentInformation> selectStudentAgeBetween(int startAge, int endAge);
}
