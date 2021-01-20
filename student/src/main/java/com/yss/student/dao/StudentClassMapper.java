package com.yss.student.dao;

import com.yss.student.entity.StudentClass;
import com.yss.student.entity.StudentClassExample;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface StudentClassMapper {

    /**
     * 返回符合Example的数据条数
     *
     * @param example
     * @throws
     * @Title:
     * @return: int
     * @author: shiwei1
     * @date: 2021/1/20/10:01
     */
    int countByExample(StudentClassExample example);


    /**
     * 删除符合Example的数据
     *
     * @param example
     * @throws
     * @Title:
     * @return: int
     * @author: shiwei1
     * @date: 2021/1/20/10:30
     */
    int deleteByExample(StudentClassExample example);


    /**
     * 根据主键删除数据
     *
     * @param id
     * @throws
     * @Title:
     * @return: int
     * @author: shiwei1
     * @date: 2021/1/20/10:30
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
     * @date: 2021/1/20/10:31
     */
    int insert(StudentClass record);


    /**
     * 插入数据（会对插入的数据非空判断，只插入有值的字段）
     *
     * @param record
     * @throws
     * @Title:
     * @return: int
     * @author: shiwei1
     * @date: 2021/1/20/10:39
     */
    int insertSelective(StudentClass record);

    /**
     * 根据Example查询数据
     *
     * @param example
     * @throws
     * @Title:
     * @return: java.util.List<com.yss.student.entity.StudentClass>
     * @author: shiwei1
     * @date: 2021/1/20/10:40
     */
    List<StudentClass> selectByExample(StudentClassExample example);

    /**
     * 根据主键查询数据
     *
     * @param id
     * @throws
     * @Title:
     * @return: com.yss.student.entity.StudentClass
     * @author: shiwei1
     * @date: 2021/1/20/10:40
     */
    StudentClass selectByPrimaryKey(Integer id);

    /**
     * 根据Example更新数据（只对某些属性进行修改）
     *
     * @param record
     * @param example
     * @throws
     * @Title:
     * @return: int
     * @author: shiwei1
     * @date: 2021/1/20/10:41
     */
    int updateByExampleSelective(@Param("record") StudentClass record, @Param("example") StudentClassExample example);

    /**
     * 根据Example修改数据
     *
     * @param record
     * @param example
     * @throws
     * @Title:
     * @return: int
     * @author: shiwei1
     * @date: 2021/1/20/10:41
     */
    int updateByExample(@Param("record") StudentClass record, @Param("example") StudentClassExample example);

    /**
     *根据主键修改数据（可以只修改部分数据）
     *
     * @Title:
     * @param record
     *
     * @return: int
     * @throws
     * @author: shiwei1
     * @date:  2021/1/20/10:42
     */
    int updateByPrimaryKeySelective(StudentClass record);

    /**
     *根据主键修改数据
     *
     * @Title:
     * @param record
     *
     * @return: int
     * @throws
     * @author: shiwei1
     * @date:  2021/1/20/10:42
     */
    int updateByPrimaryKey(StudentClass record);
}