package com.yss.student.dao;

import com.yss.student.entity.StudentInformation;
import com.yss.student.entity.StudentInformationExample;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface StudentInformationMapper {
    /**
     * 返回符合Example的数据条数
     *
     * @param example
     * @throws
     * @Title:
     * @return: int
     * @author: shiwei1
     * @date: 2021/1/20/10:52
     */
    int countByExample(StudentInformationExample example);

    /**
     * 删除符合Example的数据
     *
     * @param example
     * @throws
     * @Title:
     * @return: int
     * @author: shiwei1
     * @date: 2021/1/20/10:52
     */
    int deleteByExample(StudentInformationExample example);

    /**
     * 根据主键删除数据
     *
     * @param id
     * @throws
     * @Title:
     * @return: int
     * @author: shiwei1
     * @date: 2021/1/20/10:54
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * 插入数据
     *
     * @param record
     * @throws
     * @Title:
     * @return: int
     * @author: shiwei1
     * @date: 2021/1/20/10:55
     */
    int insert(StudentInformation record);

    /**
     * 插入数据（会对插入的数据非空判断，只插入有值的字段）
     *
     * @param record
     * @throws
     * @Title:
     * @return: int
     * @author: shiwei1
     * @date: 2021/1/20/10:55
     */
    int insertSelective(StudentInformation record);

    /**
     * 根据Example查询数据
     *
     * @param example
     * @throws
     * @Title:
     * @return: java.util.List<com.yss.student.entity.StudentInformation>
     * @author: shiwei1
     * @date: 2021/1/20/10:55
     */
    List<StudentInformation> selectByExample(StudentInformationExample example);

    /**
     * 根据主键查询数据
     *
     * @param id
     * @throws
     * @Title:
     * @return: com.yss.student.entity.StudentInformation
     * @author: shiwei1
     * @date: 2021/1/20/10:55
     */
    StudentInformation selectByPrimaryKey(Integer id);

    /**
     * 根据Example更新数据（只对某些属性进行修改）
     *
     * @param record
     * @param example
     * @throws
     * @Title:
     * @return: int
     * @author: shiwei1
     * @date: 2021/1/20/10:56
     */
    int updateByExampleSelective(@Param("record") StudentInformation record, @Param("example") StudentInformationExample example);

    /**
     * 根据Example修改数据
     *
     * @param record
     * @param example
     * @throws
     * @Title:
     * @return: int
     * @author: shiwei1
     * @date: 2021/1/20/10:56
     */
    int updateByExample(@Param("record") StudentInformation record, @Param("example") StudentInformationExample example);

    /**
     * 根据主键修改数据（可以只修改部分数据）
     *
     * @param record
     * @throws
     * @Title:
     * @return: int
     * @author: shiwei1
     * @date: 2021/1/20/10:57
     */
    int updateByPrimaryKeySelective(StudentInformation record);

    /**
     * 根据主键修改数据
     *
     * @param record
     * @throws
     * @Title:
     * @return: int
     * @author: shiwei1
     * @date: 2021/1/20/10:59
     */
    int updateByPrimaryKey(StudentInformation record);

    /**
     * 查找学生及其班级信息
     *
     * @param classId
     * @throws
     * @Title:
     * @return: java.util.List<com.yss.student.entity.StudentInformation>
     * @author: shiwei1
     * @date: 2021/1/20/10:59
     */
    List<StudentInformation> selectStudentAndClass(Integer classId);

    /**
     * 根据学生姓名查找学生
     *
     * @param studentName
     * @throws
     * @Title:
     * @return: java.util.List<com.yss.student.entity.StudentInformation>
     * @author: shiwei1
     * @date: 2021/1/20/11:00
     */
    List<StudentInformation> selectStudentByName(String studentName);

    /**
     * 根据学生姓名模糊查找学生
     *
     * @param studentName
     * @throws
     * @Title:
     * @return: java.util.List<com.yss.student.entity.StudentInformation>
     * @author: shiwei1
     * @date: 2021/1/20/11:01
     */
    List<StudentInformation> selectStudentByNameLike(@Param(value = "studentName") String studentName);
}