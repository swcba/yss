package com.yss.student.dao;

import com.yss.student.entity.StudentTeacher;
import com.yss.student.entity.StudentTeacherExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface StudentTeacherMapper {
    int countByExample(StudentTeacherExample example);

    int deleteByExample(StudentTeacherExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(StudentTeacher record);

    int insertSelective(StudentTeacher record);

    List<StudentTeacher> selectByExample(StudentTeacherExample example);

    StudentTeacher selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") StudentTeacher record, @Param("example") StudentTeacherExample example);

    int updateByExample(@Param("record") StudentTeacher record, @Param("example") StudentTeacherExample example);

    int updateByPrimaryKeySelective(StudentTeacher record);

    int updateByPrimaryKey(StudentTeacher record);
}