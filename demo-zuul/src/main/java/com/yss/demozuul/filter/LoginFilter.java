package com.yss.demozuul.filter;/****************************************************
 * 创建人：     @author shiwei1    
 * 创建时间: 2021/1/6/11:07
 * 项目名称：  demo-thymeleaf
 * 文件名称: null.java
 * 文件描述: @Description: (用一句话描述该文件做什么)
 *
 * All rights Reserved, Designed By 投资交易团队
 * @Copyright:2016-2021
 *
 ********************************************************/


import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import io.micrometer.core.instrument.util.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * 包名称：com.yss.demozuul.filter
 * 类名称：ZuulFilter
 * 类描述：
 * 创建人：@author shiwei1
 * 创建时间：2021/1/6/11:07
 */
@Component
public class LoginFilter extends ZuulFilter {


    private static Logger log = LoggerFactory.getLogger(LoginFilter.class);


    @Override
    public String filterType() {
        return "pre ";
    }

    @Override
    public int filterOrder() {
        return 0;
    }


    /**
     * @param
     * @throws
     * @Title:
     * @Description: 过滤器是否生效
     * @return: boolean  false不过滤 true过滤
     * @author: shiwei1
     * @date: 2021/1/6/11:11
     */
    @Override
    public boolean shouldFilter() {

        /*RequestContext requestContext = RequestContext.getCurrentContext();
        HttpServletRequest request = requestContext.getRequest();

        System.out.println(request.getRequestURI());
        System.out.println(request.getRequestURL());

        //当项目大的时候，URI多的时候，可以使用ACL来存储URI然后读取进行判断
        if ("/api-a/user/dc".equalsIgnoreCase(request.getRequestURI())) {
            return true;
        }*/

        return true;
    }

    /**
     * @param
     * @throws
     * @Title:
     * @Description: 业务逻辑
     * @return: java.lang.Object
     * @author: shiwei1
     * @date: 2021/1/6/11:12
     */
    @Override
    public Object run() throws ZuulException {

        RequestContext requestContext =  RequestContext.getCurrentContext();
        HttpServletRequest request = requestContext.getRequest();


        log.info(String.format("%s >>> %s", request.getMethod(), request.getRequestURL().toString()));



        //从请求头里获取token对象
        String token = request.getHeader("token");
        //从请求参数里获取token对象

        if(StringUtils.isBlank((token))){

            token  = request.getParameter("token");
        }
        //登录校验逻辑  根据公司情况自定义 JWT
        if (StringUtils.isBlank(token)) {
            log.warn("token is empty");
            requestContext.setSendZuulResponse(false);
            requestContext.setResponseStatusCode(401);
        }

        return null;
    }
}
