package com.yss.student.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author shiwei1
 */
@Data
public class StudentTeacher implements Serializable {
    private Integer id;

    private Integer studentId;

    private Integer teacherId;

    private Integer createId;

    private Date createTime;

    private Integer updateId;

    private Date updateTime;

    private Long deleteFlag;

    private static final long serialVersionUID = 1L;

}