package com.yss.student.dao;

import com.yss.student.entity.StudentTeacher;
import com.yss.student.entity.StudentTeacherExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface StudentTeacherMapper {
    /**
     *返回符合Example的数据条数
     *
     * @Title:
     * @param example
     *
     * @return: int
     * @throws
     * @author: shiwei1
     * @date:  2021/1/20/11:01
     */
    int countByExample(StudentTeacherExample example);

    /**
     *删除符合Example的数据
     *
     * @Title:
     * @param example
     *
     * @return: int
     * @throws
     * @author: shiwei1
     * @date:  2021/1/20/11:01
     */
    int deleteByExample(StudentTeacherExample example);

    /**
     *根据主键删除数据
     *
     * @Title:
     * @param id
     *
     * @return: int
     * @throws
     * @author: shiwei1
     * @date:  2021/1/20/11:02
     */
    int deleteByPrimaryKey(Integer id);

    /**
     *插入数据
     *
     * @Title:
     * @param record
     *
     * @return: int
     * @throws
     * @author: shiwei1
     * @date:  2021/1/20/11:02
     */
    int insert(StudentTeacher record);

    /**
     *插入数据（会对插入的数据非空判断，只插入有值的字段）
     *
     * @Title:
     * @param record
     *
     * @return: int
     * @throws
     * @author: shiwei1
     * @date:  2021/1/20/11:02
     */
    int insertSelective(StudentTeacher record);

    /**
     *根据Example查询数据
     *
     * @Title:
     * @param example
     *
     * @return: java.util.List<com.yss.student.entity.StudentTeacher>
     * @throws
     * @author: shiwei1
     * @date:  2021/1/20/11:02
     */
    List<StudentTeacher> selectByExample(StudentTeacherExample example);

    /**
     *根据主键查询数据
     *
     * @Title:
     * @param id
     *
     * @return: com.yss.student.entity.StudentTeacher
     * @throws
     * @author: shiwei1
     * @date:  2021/1/20/11:02
     */
    StudentTeacher selectByPrimaryKey(Integer id);

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
     * @date:  2021/1/20/11:02
     */
    int updateByExampleSelective(@Param("record") StudentTeacher record, @Param("example") StudentTeacherExample example);

    /**
     *根据Example修改数据
     *
     * @Title:
     * @param record
    	 * @param example
     *
     * @return: int
     * @throws
     * @author: shiwei1
     * @date:  2021/1/20/11:02
     */
    int updateByExample(@Param("record") StudentTeacher record, @Param("example") StudentTeacherExample example);

    /**
     *根据主键修改数据（可以只修改部分数据）
     *
     * @Title:
     * @param record
     *
     * @return: int
     * @throws
     * @author: shiwei1
     * @date:  2021/1/20/11:02
     */
    int updateByPrimaryKeySelective(StudentTeacher record);

    /**
     *根据主键修改数据
     *
     * @Title:
     * @param record
     *
     * @return: int
     * @throws
     * @author: shiwei1
     * @date:  2021/1/20/11:02
     */
    int updateByPrimaryKey(StudentTeacher record);
}