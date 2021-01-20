package com.yss.demothymeleaf.service;
/****************************************************
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


import com.yss.demothymeleaf.dao.StudentInformationMapper;
import com.yss.demothymeleaf.entity.StudentInformation;
import com.yss.demothymeleaf.entity.StudentInformationExample;
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
            if (studentInformationMapper.selectByExample(studentExample) == null) {
                System.out.println("=============");
                return null;
            } else {
                return studentInformationMapper.selectByExample(studentExample);
            }
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
            if(studentInformationMapper.selectByExample(studentExample)==null){
                return  null;
            }
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
            if (studentInformationMapper.selectByExample(studentExample)==null){
                return null;
            }
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
            if (studentInformationMapper.selectByExample(studentExample)==null){
                return null;
            }
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
    public int deleteStudent(int id) {
        try {
            studentExample.createCriteria().andIdEqualTo(id);

            StudentInformation studentInformation = selectStudentById(id).get(0);

            studentInformation.setDeleteFlag(0L);

            return updateStudentByName(studentInformation);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            studentExample.clear();
        }
        return 0;
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
    private int updateStudentByName(StudentInformation studentInformation) {
        LocalDateTime localDateTime = LocalDateTime.now();
        studentInformation.setUpdateTime(localDateTime.toDate());

        return studentInformationMapper.updateByPrimaryKey(studentInformation);
    }

    /**
     * @param studentName
     * @param
     * @return
     * @throws @author: shiwei1
     * @Title: upadateStudentByName
     * @Description: 更改学生信息
     * @return: int
     * @Date: 2020年12月30日/上午9:36:52
     */
    public int upadateStudentByName(String studentName, int age, int id) {
        try {
            LocalDateTime localDateTime = LocalDateTime.now();
            StudentInformation student = selectStudentById(id).get(0);
            if (student == null) {
                return 0;
            } else {
                student.setStudentName(studentName);
                student.setStudentAge(age);
                student.setUpdateTime(localDateTime.toDate());

                return studentInformationMapper.updateByPrimaryKey(student);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
        }
        return 0;
    }


    /**
     * @param studentName
     * @param
     * @throws
     * @Title:
     * @Description: 插入学生信息
     * @return: int
     * @author: shiwei1
     * @date: 2020/12/31/14:04
     */
    public int insert(String studentName, Integer age) {
        LocalDateTime localDateTime = LocalDateTime.now();
        StudentInformation student = new StudentInformation();
        student.setCreateTime(localDateTime.toDate());
        student.setCreateUserId("1");
        student.setUpdateUserId("1");
        student.setUpdateTime(localDateTime.toDate());
        student.setDeleteFlag(1L);
        student.setStudentName(studentName);
        student.setStudentAge(age);

        return studentInformationMapper.insert(student);
    }
}
