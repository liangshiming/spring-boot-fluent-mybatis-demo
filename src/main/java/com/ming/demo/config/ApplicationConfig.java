package com.ming.demo.config;

import cn.org.atool.fluent.mybatis.spring.MapperFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfig {

  // 定义fluent mybatis的MapperFactory
  @Bean
  public MapperFactory mapperFactory() {
    return new MapperFactory();
  }
}
