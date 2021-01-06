package com.yss.student.dao;

import com.yss.student.entity.StudentInformation;
import com.yss.student.entity.StudentInformationExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface StudentInformationMapper {
    int countByExample(StudentInformationExample example);

    int deleteByExample(StudentInformationExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(StudentInformation record);

    int insertSelective(StudentInformation record);

    List<StudentInformation> selectByExample(StudentInformationExample example);

    StudentInformation selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") StudentInformation record, @Param("example") StudentInformationExample example);

    int updateByExample(@Param("record") StudentInformation record, @Param("example") StudentInformationExample example);

    int updateByPrimaryKeySelective(StudentInformation record);

    int updateByPrimaryKey(StudentInformation record);
}