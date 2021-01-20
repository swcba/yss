package com.yss.student.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @author shiwei1
 */
@Data
public class Class implements Serializable {
    private Integer classId;

    private String className;

    private Integer createId;

    private Date createTime;

    private Integer updateId;

    private Date updateTime;

    private Long deleteFlag;



    private static final long serialVersionUID = 1L;

    public Class() {

    }

    public Class(Integer classId, String className, Integer createId, Date createTime, Integer updateId, Date updateTime, Long deleteFlag) {
        this.classId = classId;
        this.className = className;
        this.createId = createId;
        this.createTime = createTime;
        this.updateId = updateId;
        this.updateTime = updateTime;
        this.deleteFlag = deleteFlag;

    }

}