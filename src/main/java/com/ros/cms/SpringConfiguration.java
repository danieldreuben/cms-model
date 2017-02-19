package com.ros.cms;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableMBeanExport;

@Configuration
//@EnableMBeanExport
public class SpringConfiguration {
   @Bean
   protected IJmxTestBean countingHttpInterceptor() {
      return new AnnotationTestBean();
   }
}