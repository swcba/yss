package com.yss.student.vo;/****************************************************
 * 创建人：     @author shiwei1    
 * 创建时间: 2021/1/8/9:58
 * 项目名称：  demo-gateway
 * 文件名称: null.java
 * 文件描述: @Description: (用一句话描述该文件做什么)
 *
 * All rights Reserved, Designed By 投资交易团队
 * @Copyright:2016-2021
 *
 ********************************************************/


import com.yss.student.entity.StudentClass;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 包名称：com.yss.student.vo
 * 类名称：StudentClassAddVO
 * 类描述：
 * 创建人：@author shiwei1
 * 创建时间：2021/1/8/9:58
 */

@Data
@ApiModel("添加学生班级信息")
public class StudentClassAddVO {

    @ApiModelProperty(name = "id", hidden = true)
    private Integer id;

    @ApiModelProperty(name = "学生Id")
    private Integer studentId;

    @ApiModelProperty(name = "班级ID")
    private Integer classId;

    /**
     * @Description: 将StudentClassVO转换成StudentClass
     * @return: com.yss.student.entity.StudentClass
     * @throws
     * @author: shiwei1
     * @date:  2021/1/8/10:10
     */
    public StudentClass valueOfStudentClass(){
        StudentClass studentClass = new StudentClass(null,studentId,classId);
        return studentClass;
    }
}
