package com.yss.demothymeleaf.config;/****************************************************
 * 创建人：     @author shiwei1    
 * 创建时间: 2020/12/30/16:59
 * 项目名称：  IDEA_workspace
 * 文件名称: null.java
 * 文件描述: @Description: (用一句话描述该文件做什么)
 *
 * All rights Reserved, Designed By 投资交易团队
 * @Copyright:2016-2020
 *
 ********************************************************/


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * 包名称：com.yss.student.config
 * 类名称：SwaggerConfig
 * 类描述：
 * 创建人：@author shiwei1
 * 创建时间：2020/12/30/16:59
 */

@EnableSwagger2
@Configuration
public class SwaggerConfig {

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .pathMapping("/")
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.yss.demothymeleaf.controller"))
                .paths(PathSelectors.any())
                .build().apiInfo(new ApiInfoBuilder()
                        .title("学生信息")
                        .description("学生信息表的增删改查")
                        .version("1.0")
                        .build());
    }

}
