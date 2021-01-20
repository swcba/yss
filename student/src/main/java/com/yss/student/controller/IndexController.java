package com.yss.student.controller;/****************************************************
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


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 * 包名称：com.yss.student.controller
 * 类名称：IndexController
 * 类描述：index页面
 * 创建人：@author shiwei1
 * 创建时间：2020/12/31/16:27
 */

@Controller
public class IndexController {

    @RequestMapping("/index")
    public String index(){

        return "index";
    }
}
