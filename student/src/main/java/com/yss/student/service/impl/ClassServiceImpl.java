package com.yss.student.service.impl;/****************************************************
 * 创建人：     @author shiwei1    
 * 创建时间: 2021/1/8/14:45
 * 项目名称：  demo-gateway
 * 文件名称: null.java
 * 文件描述: @Description: (用一句话描述该文件做什么)
 *
 * All rights Reserved, Designed By 投资交易团队
 * @Copyright:2016-2021
 *
 ********************************************************/


import com.yss.student.dao.ClassMapper;
import com.yss.student.entity.Class;
import com.yss.student.entity.ClassExample;
import com.yss.student.service.IClassService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 包名称：com.yss.student.service
 * 类名称：ClassService
 * 类描述：
 * 创建人：@author shiwei1
 * 创建时间：2021/1/8/14:45
 */
@Service
public class ClassServiceImpl implements IClassService {

    @Resource
    private ClassExample classExample;

    @Resource
    private ClassMapper classMapper;


    @Override
    public List<Class> selectClassByName(String className){
        try {
            classExample.createCriteria().andClassNameEqualTo(className);
            if (classMapper.selectByExample(classExample).isEmpty()){
                return null;
            }

            return classMapper.selectByExample(classExample);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            classExample.clear();
        }
        return null;
    }


    @Override
    public Class selectClassById(Integer classId){
        try {

            if (classMapper.selectByPrimaryKey(classId)==null){
                return null;
            }

            return classMapper.selectByPrimaryKey(classId);
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
