package com.yss.student;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author: shiwei1
 * @date: 2021/1/7/9:06
 */
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@MapperScan("com.yss.student")
@EnableSwagger2
public class DemoStudentApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoStudentApplication.class, args);
	}

}
