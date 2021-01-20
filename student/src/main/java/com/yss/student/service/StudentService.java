package com.yss.student.service;
/****************************************************
 * 创建人：     @author shiwei1
 * 创建时间: 2020/12/31/12:28
 * 项目名称：  IDEA_workspace
 * 文件名称: StudentService.java
 * 文件描述: @Description: (用一句话描述该文件做什么)
 *
 * All rights Reserved, Designed By 投资交易团队
 * @Copyright:2016-2020
 *
 ********************************************************/


import com.yss.student.dao.StudentInformationMapper;
import com.yss.student.entity.Class;
import com.yss.student.entity.StudentClass;
import com.yss.student.entity.StudentInformation;
import com.yss.student.entity.StudentInformationExample;
import com.yss.student.vo.StudentAddVO;
import com.yss.student.vo.StudentUpdateVO;
import io.swagger.annotations.ApiOperation;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.*;
import org.joda.time.LocalDateTime;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;
import org.springframework.web.bind.annotation.PostMapping;

import javax.annotation.Resource;

import java.io.InputStream;
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

    @Resource
    private StudentInformationMapper studentInformationMapper;

    @Resource
    private StudentInformationExample studentExample;

    @Resource
    private ClassService classService;

    @Resource
    private StudentClassService studentClassService;

    @Resource
    private TestService testService;

    @Resource
    private DataSourceTransactionManager transactionManager;


    /**
     * @param studentInformationList
     * @throws
     * @Title:
     * @Description: 为学生类添加班级信息
     * @return: java.util.List<com.yss.student.entity.StudentInformation>
     * @author: shiwei1
     * @date: 2021/1/18/15:17
     */
    private List<StudentInformation> addClassInformation(List<StudentInformation> studentInformationList) {

        for (StudentInformation student : studentInformationList) {
            //通过学生班级信息表获取班级信息
            int classId = studentClassService.selectStudentClass(student.getId()).getClassId();
            Class studentClass = classService.selectClassById(classId);

            student.setStudentClass(studentClass);

        }
        return studentInformationList;
    }

    /**
     * @Description: 查询所有学生
     * @return: java.util.List<com.yss.student.entity.StudentInformation>
     * @author: shiwei1
     * @date: 2020/12/31/13:10
     */
    @PostMapping("/student")
    @ApiOperation("查找所有学生及班级信息")
    public List<StudentInformation> selectStudentAndClass() {
        return testService.selectStudentAndClass();
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

            return addClassInformation(studentInformationMapper.selectByExample(studentExample));

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

            return addClassInformation(studentInformationMapper.selectByExample(studentExample));
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
            if (studentInformationMapper.selectStudentByName(name).isEmpty()) {

                return null;
            }

            return addClassInformation(studentInformationMapper.selectStudentByName(name));
        } catch (Exception e) {
            e.printStackTrace();
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
            studentExample.createCriteria().andStudentNameLike( name + "%")
                    .andDeleteFlagEqualTo(1L);
            if (studentInformationMapper.selectByExample(studentExample).isEmpty()) {
                return null;
            }
            return addClassInformation(studentInformationMapper.selectByExample(studentExample));
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

            if (studentInformationList.isEmpty()) {
                return "删除失败,学生不存在";
            }
            StudentInformation studentInformation = studentInformationList.get(0);
            studentInformation.setDeleteFlag(0L);
            studentInformationMapper.updateByPrimaryKey(updateStudentTool(studentInformation));

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
     * @Description: 设置学生数据创建更新的信息
     * @return: int
     * @author: shiwei1
     * @date: 2020/12/31/14:00
     */
    private StudentInformation updateStudentTool(StudentInformation studentInformation) {
        LocalDateTime localDateTime = LocalDateTime.now();

        if (studentInformation.getCreateUserId() == null) {
            studentInformation.setDeleteFlag(1L);
            studentInformation.setCreateUserId("1");
            studentInformation.setCreateTime(localDateTime.toDate());
        }
        studentInformation.setUpdateTime(localDateTime.toDate());
        studentInformation.setUpdateUserId("1");
        return studentInformation;
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
    public String updateStudent(StudentUpdateVO studentUpdateVO) {
        try {
            StudentInformation student = selectStudentById(studentUpdateVO.getId()).get(0);

            if (student == null) {
                return "更新失败，学生不存在";
            }
            student.valueOfStudentUpdateVO(studentUpdateVO);
            studentInformationMapper.updateByPrimaryKey(updateStudentTool(student));

            return "更改成功！";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "系统繁忙，稍后再试";
    }


    /**
     * @param studentAddVO
     * @param
     * @throws
     * @Title:
     * @Description: 添加学生
     * @return: int
     * @author: shiwei1
     * @date: 2020/12/31/14:04
     */
    public String insert(StudentAddVO studentAddVO) {
        // 2.获取事务定义
        DefaultTransactionDefinition def = new DefaultTransactionDefinition();
        // 3.设置事务隔离级别，开启新事务
        def.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRES_NEW);
        // 4.获得事务状态
        TransactionStatus status = transactionManager.getTransaction(def);


        try {
            String resource = "mybatis-config.xml";
            InputStream is = Resources.getResourceAsStream(resource);
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
            //关闭mybatis自动提交
            sqlSessionFactory.openSession(false);


            studentInformationMapper.insert(updateStudentTool(studentAddVO.valueOfStudentInformation()));
            int classId = classService.selectClassByName(studentAddVO.getClassName())
                    .get(0)
                    .getClassId();
            int studentId = selectStudentAndClass().size() + 1;

            StudentClass studentClass = new StudentClass(null, studentId, classId);
            studentClassService.insertStudentClass(studentClass);

            transactionManager.commit(status);
            return "成功";
        } catch (Exception e) {
            transactionManager.rollback(status);
            throw new RuntimeException(e.getMessage());

        }


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
    public List<StudentInformation> selectStudentByClassName(String className) {
        //根据班级名称获取班级id
        if (classService.selectClassByName(className) == null) {
            return null;
        }
        Integer classId = classService.selectClassByName(className).get(0).getClassId();

        return studentInformationMapper.selectStudentAndClass(classId);

    }

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
        try {
            studentExample.createCriteria().andStudentAgeBetween(startAge, endAge);
            return addClassInformation(studentInformationMapper.selectByExample(studentExample));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            studentExample.clear();
        }
        return null;
    }
}
