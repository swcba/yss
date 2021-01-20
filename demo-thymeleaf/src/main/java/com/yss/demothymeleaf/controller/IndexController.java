package com.yss.demothymeleaf.controller;
/****************************************************
 * 创建人：     @author shiwei1    
 * 创建时间: 2020/12/31/16:27
 * 项目名称：  IDEA_workspace
 * 文件名称: null.java
 * 文件描述: @Description: index页面(用一句话描述该文件做什么)
 *
 * All rights Reserved, Designed By 投资交易团队
 * @Copyright:2016-2020
 *
 ********************************************************/


import com.yss.demothymeleaf.entity.StudentInformation;
import com.yss.demothymeleaf.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.List;

/**
 * 包名称：com.yss.student.controller
 * 类名称：IndexController
 * 类描述：index页面
 * 创建人：@author shiwei1
 * 创建时间：2020/12/31/16:27
 */

@Controller
public class IndexController {

    @Resource
    private StudentService service;

    @RequestMapping("/index")
    public String index(Model model){
        List<StudentInformation> student = service.selectAllStudent();
        model.addAttribute("students", student);

        return "index";
    }


}
