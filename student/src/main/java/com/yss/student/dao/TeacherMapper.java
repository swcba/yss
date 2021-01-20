package com.yss.student.dao;

import com.yss.student.entity.Teacher;
import com.yss.student.entity.TeacherExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 * @author shiwei1
 */
public interface TeacherMapper {
    /**
     *返回符合Example的数据条数
     *
     * @Title:
     * @param example
     *
     * @return: int
     * @throws
     * @author: shiwei1
     * @date:  2021/1/20/11:04
     */
    int countByExample(TeacherExample example);

    /**
     *删除符合Example的数据
     *
     * @Title:
     * @param example
     *
     * @return: int
     * @throws
     * @author: shiwei1
     * @date:  2021/1/20/11:04
     */
    int deleteByExample(TeacherExample example);

    /**
     *根据主键删除数据
     *
     * @Title:
     * @param teacherId
     *
     * @return: int
     * @throws
     * @author: shiwei1
     * @date:  2021/1/20/11:04
     */
    int deleteByPrimaryKey(Integer teacherId);

    /**
     *插入数据
     *
     * @Title:
     * @param record
     *
     * @return: int
     * @throws
     * @author: shiwei1
     * @date:  2021/1/20/11:04
     */
    int insert(Teacher record);

    /**
     *插入数据（会对插入的数据非空判断，只插入有值的字段）
     *
     * @Title:
     * @param record
     *
     * @return: int
     * @throws
     * @author: shiwei1
     * @date:  2021/1/20/11:05
     */
    int insertSelective(Teacher record);

    /**
     *根据Example查询数据
     *
     * @Title:
     * @param example
     *
     * @return: java.util.List<com.yss.student.entity.Teacher>
     * @throws
     * @author: shiwei1
     * @date:  2021/1/20/11:05
     */
    List<Teacher> selectByExample(TeacherExample example);

    /**
     *根据主键查询数据
     *
     * @Title:
     * @param teacherId
     *
     * @return: com.yss.student.entity.Teacher
     * @throws
     * @author: shiwei1
     * @date:  2021/1/20/11:05
     */
    Teacher selectByPrimaryKey(Integer teacherId);

    /**
     *根据Example更新数据（只对某些属性进行修改）
     *
     * @Title:
     * @param record
    	 * @param example
     *
     * @return: int
     * @throws
     * @author: shiwei1
     * @date:  2021/1/20/11:05
     */
    int updateByExampleSelective(@Param("record") Teacher record, @Param("example") TeacherExample example);

    /**
     *方根据Example修改数据
     *
     * @Title:
     * @param record
    	 * @param example
     *
     * @return: int
     * @throws
     * @author: shiwei1
     * @date:  2021/1/20/11:05
     */
    int updateByExample(@Param("record") Teacher record, @Param("example") TeacherExample example);

    /**
     *根据主键修改数据（可以只修改部分数据）
     *
     * @Title:
     * @param record
     *
     * @return: int
     * @throws
     * @author: shiwei1
     * @date:  2021/1/20/11:05
     */
    int updateByPrimaryKeySelective(Teacher record);

    /**
     *根据主键修改数据
     *
     * @Title:
     * @param record
     *
     * @return: int
     * @throws
     * @author: shiwei1
     * @date:  2021/1/20/11:05
     */
    int updateByPrimaryKey(Teacher record);
}