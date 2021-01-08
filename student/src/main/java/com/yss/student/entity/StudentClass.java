package com.yss.student.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class StudentClass implements Serializable {
    private Integer id;

    private Integer studentId;

    private Integer classId;

    private Integer createId;

    private Date createTime;

    private Integer updateId;

    private Date updateTime;

    private Long deleteFlag;

    private static final long serialVersionUID = 1L;

    public StudentClass() {
    }

    public StudentClass(Integer id, Integer studentId, Integer classId, Integer createId, Date createTime, Integer updateId, Date updateTime, Long deleteFlag) {
        this.id = id;
        this.studentId = studentId;
        this.classId = classId;
        this.createId = createId;
        this.createTime = createTime;
        this.updateId = updateId;
        this.updateTime = updateTime;
        this.deleteFlag = deleteFlag;
    }

    public StudentClass(Integer id, Integer studentId, Integer classId) {
        this.id = id;
        this.studentId = studentId;
        this.classId = classId;
    }

}