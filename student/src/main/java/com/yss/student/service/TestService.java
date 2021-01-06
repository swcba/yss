package com.yss.student.service;/****************************************************
 * 创建人：     @author shiwei1    
 * 创建时间: 2021/1/6/9:38
 * 项目名称：  demo-thymeleaf
 * 文件名称: null.java
 * 文件描述: @Description: (用一句话描述该文件做什么)
 *
 * All rights Reserved, Designed By 投资交易团队
 * @Copyright:2016-2021
 *
 ********************************************************/


import com.yss.student.dao.TestMapper;
import com.yss.student.entity.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 包名称：com.yss.student.service
 * 类名称：TestService
 * 类描述：
 * 创建人：@author shiwei1
 * 创建时间：2021/1/6/9:38
 */

@Service
public class TestService {

    @Autowired
    private TestMapper testMapper;

    public List<Teacher> selectAllTeacher(){

        return testMapper.selectAllTeacher();
    }

}