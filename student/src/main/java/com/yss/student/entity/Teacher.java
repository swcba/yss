package com.yss.student.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @author shiwei1
 */
@Data
public class Teacher implements Serializable {
    private Integer teacherId;

    private Long deleteFlag;

    private Integer createId;

    private Date createTime;

    private Integer updateId;

    private Date updateTime;

    private String teacherName;

    private String teacherSubject;

    private List<StudentInformation> studentInformationList;

    private static final long serialVersionUID = 1L;

    public Teacher() {
    }

    public Teacher(Integer teacherId, Long deleteFlag, Integer createId, Date createTime, Integer updateId, Date updateTime, String teacherName, String teacherSubject, List<StudentInformation> studentInformationList) {
        this.teacherId = teacherId;
        this.deleteFlag = deleteFlag;
        this.createId = createId;
        this.createTime = createTime;
        this.updateId = updateId;
        this.updateTime = updateTime;
        this.teacherName = teacherName;
        this.teacherSubject = teacherSubject;
        this.studentInformationList = studentInformationList;
    }
}