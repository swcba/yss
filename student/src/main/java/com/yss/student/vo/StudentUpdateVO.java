package com.yss.student.vo;/****************************************************
 * 创建人：     @author shiwei1    
 * 创建时间: 2021/1/7/14:08
 * 项目名称：  demo-gateway
 * 文件名称: null.java
 * 文件描述: @Description: (用一句话描述该文件做什么)
 *
 * All rights Reserved, Designed By 投资交易团队
 * @Copyright:2016-2021
 *
 ********************************************************/


import com.yss.student.entity.StudentInformation;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * 包名称：com.yss.student.vo
 * 类名称：StudentUpdateVO
 * 类描述：
 * 创建人：@author shiwei1
 * 创建时间：2021/1/7/14:08
 */

@Data
@ApiModel("更改学生信息")
public class StudentUpdateVO implements Serializable {

    @ApiModelProperty("学生id")
    private  Integer id;

    @ApiModelProperty(value = "学生姓名",name = "学生姓名")
    private  String studentName;

    @ApiModelProperty(value = "学生年龄")
    private  Integer studentAge;



    @ApiModelProperty(value = "成绩")
    private  String grade;

    private static final long serialVersionUID = 1L;

    /**
     * @Description: 将studentVO转换成StudentInformation
     * @return: com.yss.student.entity.StudentInformation
     * @throws
     * @author: shiwei1
     * @date:  2021/1/7/13:39
     */
    public StudentInformation valueOfStudentInformation(){
        StudentInformation studentInformation = new StudentInformation(id,studentName,studentAge,grade);
        return studentInformation;
    }

}
