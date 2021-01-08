package com.yss.demothymeleaf;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author shiwei1
 */
@SpringBootApplication
@MapperScan("com.yss.demothymeleaf")
public class DemoThymeleafApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoThymeleafApplication.class, args);
	}

}
