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
import com.yss.student.entity.StudentClass;
import com.yss.student.entity.StudentClassExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 包名称：com.yss.student.service
 * 类名称：ClassService
 * 类描述：
 * 创建人：@author shiwei1
 * 创建时间：2021/1/7/17:35
 */

@Service
public class StudentClassService {

    private StudentClassMapper studentClassMapper;

    @Autowired
    private StudentClassExample studentClassExample;

    private StudentInformationMapper studentInformationMapper;

    private ClassMapper classMapper;


    /**
     * @throws
     * @Description: 插入学生班级信息
     * @return: int
     * @author: shiwei1
     * @date: 2021/1/7/17:42
     */
    public String insertStudentClass(StudentClass studentClass) {

        try {

            if (studentInformationMapper.selectByPrimaryKey(studentClass.getStudentId()) == null
                    && classMapper.selectByPrimaryKey(studentClass.getClassId()) == null) {

                return "添加失败";
            }
            studentClassMapper.insert(studentClass);
        } catch (Exception e) {
            e.printStackTrace();
        }


        return "添加成功";
    }

    /**
     * @Description: 删除学生的班级信息
     * @return:
     * @throws
     * @author: shiwei1
     * @date:  2021/1/7/17:55
     */


}
