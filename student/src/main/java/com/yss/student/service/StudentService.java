package com.yss.student.service;/****************************************************
 * 创建人：     @author shiwei1    
 * 创建时间: 2020/12/31/12:28
 * 项目名称：  IDEA_workspace
 * 文件名称: null.java
 * 文件描述: @Description: (用一句话描述该文件做什么)
 *
 * All rights Reserved, Designed By 投资交易团队
 * @Copyright:2016-2020
 *
 ********************************************************/


import com.yss.student.dao.StudentInformationMapper;
import com.yss.student.entity.StudentInformation;
import com.yss.student.entity.StudentInformationExample;
import com.yss.student.vo.StudentUpdateVO;
import org.joda.time.LocalDateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 包名称：com.yss.student.service
 * 类名称：StudentService
 * 类描述：
 * 创建人：@author shiwei1
 * 创建时间：2020/12/31/12:28
 */
@Service
public class StudentService {

    @Autowired
    private StudentInformationMapper studentInformationMapper;

    @Autowired
    private StudentInformationExample studentExample;


    /**
     * @Description: 查询所有学生
     * @return: java.util.List<com.yss.student.entity.StudentInformation>
     * @author: shiwei1
     * @date: 2020/12/31/13:10
     */
    public List<StudentInformation> selectAllStudent() {

        return studentInformationMapper.selectByExample(null);
    }


    /**
     * @param
     * @throws
     * @Title:
     * @Description: 查询未被删除的学生
     * @return: java.util.List<com.yss.student.entity.StudentInformation>
     * @author: shiwei1
     * @date: 2020/12/31/13:10
     */
    public List<StudentInformation> selectStudentByDeleteFlag() {
        try {
            studentExample.createCriteria().andDeleteFlagEqualTo(1L);

            return studentInformationMapper.selectByExample(studentExample);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            studentExample.clear();
        }
        return null;
    }


    /**
     * @param id
     * @throws
     * @Title:
     * @Description: 根据id查找学生
     * @return: java.util.List<com.yss.student.entity.StudentInformation>
     * @author: shiwei1
     * @date: 2020/12/31/13:10
     */
    public List<StudentInformation> selectStudentById(int id) {

        try {
            studentExample.createCriteria().andIdEqualTo(id)
                    .andDeleteFlagEqualTo(1L);

            return studentInformationMapper.selectByExample(studentExample);

        } catch (Exception e) {

            e.printStackTrace();
        } finally {
            studentExample.clear();

        }
        return null;
    }


    /**
     * @param name
     * @return
     * @throws @author: shiwei1
     * @Title: selectStudentByName
     * @Description: 根据学生姓名查找学生
     * @return: List<StudentInformation>
     * @Date: 2020年12月30日/上午9:18:47
     */
    public List<StudentInformation> selectStudentByName(String name) {
        try {
            studentExample.createCriteria().andStudentNameEqualTo(name);

            return studentInformationMapper.selectByExample(studentExample);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            studentExample.clear();
        }
        return null;
    }

    /**
     * @param name
     * @return
     * @throws @author: shiwei1
     * @Title: selectStudentByLike
     * @Description: 根据学生姓名模糊查找学生
     * @return: List<StudentInformation>
     * @Date: 2020年12月30日/上午9:20:04
     */
    public List<StudentInformation> selectStudentNameByLike(String name) {
        try {
            studentExample.createCriteria().andStudentNameLike(name + "%");

            return studentInformationMapper.selectByExample(studentExample);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            studentExample.clear();
        }
        return null;
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
    public String deleteStudent(int id) {
        try {
            studentExample.createCriteria().andIdEqualTo(id);
            List<StudentInformation> studentInformationList = selectStudentById(id);

            if (studentInformationList==null){
                return "删除失败,id不存在";
            }
                StudentInformation studentInformation = selectStudentById(id).get(0);

                studentInformation.setDeleteFlag(0L);

                upadateStudentByName(studentInformation);
                return "删除成功";

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            studentExample.clear();
        }
        return "服务繁忙!，请重试";
    }


    /**
     * @param studentInformation
     * @param
     * @throws
     * @Title:
     * @Description: ${todo}(这里用一句话描述这个方法的作用)
     * @return: int
     * @author: shiwei1
     * @date: 2020/12/31/14:00
     */
    private int upadateStudentByName(StudentInformation studentInformation) {


        LocalDateTime localDateTime = LocalDateTime.now();
        studentInformation.setUpdateTime(localDateTime.toDate());

        return studentInformationMapper.updateByPrimaryKey(studentInformation);
    }

    /**
     * @param studentUpdateVO
     * @param
     * @return
     * @throws @author: shiwei1
     * @Title: upadateStudentByName
     * @Description: 更改学生信息
     * @return: int
     * @Date: 2020年12月30日/上午9:36:52
     */
    public String upadateStudent(StudentUpdateVO studentUpdateVO) {
        try {
            LocalDateTime localDateTime = LocalDateTime.now();
            StudentInformation student = selectStudentById(studentUpdateVO.getId()).get(0);

            if (student == null) {
                return "更新失败，学生不存在";
            } else {
                student.valueOfStudentUpdateVO(studentUpdateVO);
                student.setUpdateTime(localDateTime.toDate());
                studentInformationMapper.updateByPrimaryKey(student);
                return "更改成功！";
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
        }
        return "系统繁忙，稍后再试";
    }


    /**
     * @param student
     * @param
     * @throws
     * @Title:
     * @Description: 添加学生
     * @return: int
     * @author: shiwei1
     * @date: 2020/12/31/14:04
     */
    public int insert(StudentInformation student) {


        LocalDateTime localDateTime = LocalDateTime.now();
        student.setCreateTime(localDateTime.toDate());
        student.setCreateUserId("1");
        student.setUpdateUserId("1");
        student.setUpdateTime(localDateTime.toDate());
        student.setDeleteFlag(1L);


        return studentInformationMapper.insert(student);
    }


    /**
     * @param className
     * @throws
     * @Title:
     * @Description: 根据班级查找学生
     * @return: java.util.List<com.yss.student.entity.StudentInformation>
     * @author: shiwei1
     * @date: 2021/1/4/11:53
     */
    /*public List<StudentInformation> selectStudentByClassName(String className) {
        studentExample.createCriteria().andClassNameEqualTo(className);
        return studentInformationMapper.selectByExample(studentExample);

    }*/

    /**
     * @param startAge
     * @param endAge
     * @throws
     * @Title:
     * @Description: 查找某个年龄段的学生
     * @return: java.util.List<com.yss.student.entity.StudentInformation>
     * @author: shiwei1
     * @date: 2021/1/4/11:59
     */
    public List<StudentInformation> selectStudentAgeBetween(int startAge, int endAge) {
        studentExample.createCriteria().andStudentAgeBetween(startAge, endAge);
        return studentInformationMapper.selectByExample(studentExample);

    }
}
