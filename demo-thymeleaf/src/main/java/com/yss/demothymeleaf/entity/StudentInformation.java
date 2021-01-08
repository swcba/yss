package com.yss.demothymeleaf.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class StudentInformation implements Serializable {
    private Integer id;

    private Long deleteFlag;

    private String createUserId;

    private Date createTime;

    private String updateUserId;

    private Date updateTime;

    private String studentName;

    private Integer studentAge;

    private String grade;

    private static final long serialVersionUID = 1L;


}