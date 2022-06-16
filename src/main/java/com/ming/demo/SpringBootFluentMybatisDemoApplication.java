package com.ming.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan({"com.ming.demo.fluent.mapper"})
public class SpringBootFluentMybatisDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootFluentMybatisDemoApplication.class, args);
	}

}
