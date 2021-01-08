package com.yss.student.vo;/****************************************************
 * 创建人：     @author shiwei1    
 * 创建时间: 2021/1/7/10:25
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


/**
 * 包名称：com.yss.student.vo
 * 类名称：StudentAddVO
 * 类描述：
 * 创建人：@author shiwei1
 * 创建时间：2021/1/7/10:25
 */
@Data
@ApiModel(value = "学生")
public class StudentAddVO {

    @ApiModelProperty(value = "学生姓名",name = "学生姓名")
    private  String studentName;

    @ApiModelProperty(value = "学生年龄")
    private  Integer studentAge;


    @ApiModelProperty(value = "成绩")
    private  String grade;

    /**
     * @Description: 将studentVO转换成StudentInformation
     * @return: com.yss.student.entity.StudentInformation
     * @throws
     * @author: shiwei1
     * @date:  2021/1/7/13:39
     */
    public  StudentInformation valueOfStudentInformation(){
        StudentInformation studentInformation = new StudentInformation(null,studentName,studentAge,grade);
        return studentInformation;
    }
    
}
