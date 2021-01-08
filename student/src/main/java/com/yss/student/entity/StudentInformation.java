package com.yss.student.entity;

import com.yss.student.vo.StudentUpdateVO;
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

    private Class studentClass;

    private static final long serialVersionUID = 1L;

    public StudentInformation(Integer id,String studentName, Integer studentAge, String grade) {
        this.id=id;
        this.studentName = studentName;
        this.studentAge = studentAge;
        this.grade = grade;
    }

    public StudentInformation() {
    }

    public StudentInformation(Integer id, Long deleteFlag, String createUserId, Date createTime, String updateUserId, Date updateTime, String studentName, Integer studentAge, String grade, Class studentClass) {
        this.id = id;
        this.deleteFlag = deleteFlag;
        this.createUserId = createUserId;
        this.createTime = createTime;
        this.updateUserId = updateUserId;
        this.updateTime = updateTime;
        this.studentName = studentName;
        this.studentAge = studentAge;
        this.studentClass = studentClass;
        this.grade = grade;
    }


    public void                                                                                                                                                                                                                              valueOfStudentUpdateVO(StudentUpdateVO studentUpdateVO){

        this.studentName=studentUpdateVO.getStudentName();
        this.studentAge=studentUpdateVO.getStudentAge();

        this.grade=studentUpdateVO.getGrade();

    }
}