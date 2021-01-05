package com.yss.demothymeleaf.controller;/****************************************************
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


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yss.demothymeleaf.entity.StudentInformation;
import com.yss.demothymeleaf.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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

    @Autowired
    private StudentService service;

    @RequestMapping("/index")
    public String index(Model model, @RequestParam(defaultValue = "1") Integer page){
        PageHelper.startPage(page,3);
        List<StudentInformation> student = service.selectAllStudent();
        PageInfo<StudentInformation> stuPageInfo = new PageInfo<StudentInformation>(student);
        model.addAttribute("students", student);
        model.addAttribute("stuPageInfo", stuPageInfo);
        return "index";
    }


}
