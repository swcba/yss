package com.yss.student.service;/****************************************************
 * 创建人：     @author shiwei1    
 * 创建时间: 2021/1/7/17:35
 * 项目名称：  demo-gateway
 * 文件名称: null.java
 * 文件描述: @Description: (用一句话描述该文件做什么)
 *
 * All rights Reserved, Designed By 投资交易团队
 * @Copyright:2016-2021
 *
 ********************************************************/


import com.yss.student.dao.ClassMapper;
import com.yss.student.dao.StudentClassMapper;
import com.yss.student.dao.StudentInformationMapper;
import com.yss.student.entity.*;
import org.joda.time.LocalDateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;

/**
 * 包名称：com.yss.student.service
 * 类名称：ClassService
 * 类描述：
 * 创建人：@author shiwei1
 * 创建时间：2021/1/7/17:35
 */

@Service
public class StudentClassService {

    @Autowired
    private StudentClassExample studentClassExample;

    @Autowired
    private StudentInformationExample studentInformationExample;

    @Autowired
    private ClassExample classExample;

    @Resource
    private StudentInformationMapper studentInformationMapper;

    @Resource
    private ClassMapper classMapper;

    @Resource
    private StudentClassMapper studentClassMapper;
    /**
     * @throws
     * @Description: 插入学生班级信息
     * @return: int
     * @author: shiwei1
     * @date: 2021/1/7/17:42
     */
    public String insertStudentClass(StudentClass studentClass) {
        try {
            studentClassExample.createCriteria().andStudentIdEqualTo(studentClass.getStudentId())
                    .andClassIdEqualTo(studentClass.getClassId()).andDeleteFlagEqualTo(1L);

            studentInformationExample.createCriteria().andIdEqualTo(studentClass.getStudentId())
                    .andDeleteFlagEqualTo(1L);

            classExample.createCriteria().andClassIdEqualTo(studentClass.getClassId())
                    .andDeleteFlagEqualTo(1L);

            //判断学生与班级信息是否存在
            if (studentInformationMapper.selectByExample(studentInformationExample).isEmpty()
                    || classMapper.selectByExample(classExample).isEmpty() ) {
                return "添加失败,学生或班级不存在";
            }else if (!studentClassMapper.selectByExample(studentClassExample).isEmpty()){
                //判断该数据是否已经存在
                return "添加失败，该学生信息已存在";
            }

            studentClassMapper.insert(updateStudentClass(studentClass));
            return  "添加成功";
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            studentClassExample.clear();
            classExample.clear();
            studentInformationExample.clear();
        }

        return "系统繁忙";
    }

    /**
     * @Description: 删除学生的班级信息
     * @return:
     * @throws
     * @author: shiwei1
     * @date:  2021/1/7/17:55
     */
    public String deleteStudentAndClass(StudentInformation studentInformation){
        studentClassExample.createCriteria().andStudentIdEqualTo(studentInformation.getId()).andDeleteFlagEqualTo(1L);
        try {
            if (studentClassMapper.selectByExample(studentClassExample).isEmpty()) {
                return "该学生不存在";
            }
            StudentClass studentClass = studentClassMapper.selectByExample(studentClassExample).get(0);
            studentClass.setDeleteFlag(0L);
            studentClassMapper.updateByPrimaryKey(updateStudentClass(studentClass));

            return "删除成功";
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            studentClassExample.clear();
        }
        return "系统繁忙";
    }


    /**
     * @Description: 设置生成时间与更新时间的信息
     * @return: com.yss.student.entity.StudentClass
     * @throws
     * @author: shiwei1
     * @date:  2021/1/8/11:31
     */
    public StudentClass updateStudentClass(StudentClass studentClass){
        LocalDateTime localDateTime = LocalDateTime.now();

        if(studentClass.getCreateId()==null){
            studentClass.setDeleteFlag(1L);
            studentClass.setCreateId(1);
            studentClass.setCreateTime(localDateTime.toDate());
        }
        studentClass.setUpdateId(1);
        studentClass.setUpdateTime(localDateTime.toDate());
        return studentClass;
    }
}
