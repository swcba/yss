package com.yss.student.service;/****************************************************
 * 创建人：     @author shiwei1    
 * 创建时间: 2021/1/20/13:40
 * 项目名称：  demo-thymeleaf
 * 文件名称: null.java
 * 文件描述: @Description: 班级信息基本操作(用一句话描述该文件做什么)
 *
 * All rights Reserved, Designed By 投资交易团队
 * @Copyright:2016-2021
 *
 ********************************************************/


import com.yss.student.entity.Class;

import java.util.List;

/**
 * 包名称：com.yss.student.service
 * 接口名称：IClassService
 * 接口描述：班级信息基本操作
 * 创建人：@author shiwei1
 * 创建时间：2021/1/20/13:40
 */
public interface IClassService {


    /**
     * 根据班级名称查找班级
     *
     * @param className
     * @throws
     * @Title:
     * @return: java.util.List<com.yss.student.entity.Class>
     * @author: shiwei1
     * @date: 2021/1/20/13:42
     */
    List<Class> selectClassByName(String className);


    /**
     * 根据id查找班级
     *
     * @param classId
     * @throws
     * @Title:
     * @return: com.yss.student.entity.Class
     * @author: shiwei1
     * @date: 2021/1/20/13:43
     */
    Class selectClassById(Integer classId);
}
