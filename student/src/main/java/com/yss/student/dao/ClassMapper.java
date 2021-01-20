package com.yss.student.dao;

import com.yss.student.entity.Class;
import com.yss.student.entity.ClassExample;

import java.util.List;

import org.apache.ibatis.annotations.Param;

/**
 * @author shiwei1
 */
public interface ClassMapper {

    /**
     * 返回符合Example的数据条数
     *
     * @param example
     * @throws
     * @Title:
     * @return: int
     * @author: shiwei1
     * @date: 2021/1/20/9:29
     */
    int countByExample(ClassExample example);

    /**
     * 删除符合Example的数据
     *
     * @param example
     * @throws
     * @Title:
     * @return: int
     * @author: shiwei1
     * @date: 2021/1/20/9:31
     */
    int deleteByExample(ClassExample example);

    /**
     * 根据主键删除数据
     *
     * @param classId
     * @throws
     * @Title:
     * @return: int
     * @author: shiwei1
     * @date: 2021/1/20/9:32
     */
    int deleteByPrimaryKey(Integer classId);

    /**
     * 插入数据
     *
     * @param record
     * @throws
     * @Title:
     * @return: int
     * @author: shiwei1
     * @date: 2021/1/20/9:43
     */
    int insert(Class record);

    /**
     * 插入数据（会对插入的数据非空判断，只插入有值的字段）
     *
     * @param record
     * @throws
     * @Title:
     * @return: int
     * @author: shiwei1
     * @date: 2021/1/20/9:44
     */
    int insertSelective(Class record);

    /**
     * 根据Example查询数据
     *
     * @param example
     * @throws
     * @Title:
     * @return: java.util.List<com.yss.student.entity.Class>
     * @author: shiwei1
     * @date: 2021/1/20/9:47
     */
    List<Class> selectByExample(ClassExample example);

    /**
     * 根据主键查询数据
     *
     * @param classId
     * @throws
     * @Title:
     * @return: com.yss.student.entity.Class
     * @author: shiwei1
     * @date: 2021/1/20/9:48
     */
    Class selectByPrimaryKey(Integer classId);

    /**
     * 根据Example更新数据（只对某些属性进行修改）
     *
     * @param record（修改后的数据）
     * @param example（需要修改的对象）
     * @throws
     * @Title:
     * @return: int
     * @author: shiwei1
     * @date: 2021/1/20/9:50
     */
    int updateByExampleSelective(@Param("record") Class record, @Param("example") ClassExample example);

    /**
     * 根据Example修改数据
     *
     * @param record
     * @param example
     * @throws
     * @Title:
     * @return: int
     * @author: shiwei1
     * @date: 2021/1/20/9:54
     */
    int updateByExample(@Param("record") Class record, @Param("example") ClassExample example);

    /**
     * 根据主键修改数据（可以只修改部分数据）
     *
     * @param record
     * @throws
     * @Title:
     * @return: int
     * @author: shiwei1
     * @date: 2021/1/20/9:56
     */
    int updateByPrimaryKeySelective(Class record);

    /**
     * 根据主键修改数据
     *
     * @param record
     * @throws
     * @Title:
     * @return: int
     * @author: shiwei1
     * @date: 2021/1/20/9:56
     */
    int updateByPrimaryKey(Class record);
}