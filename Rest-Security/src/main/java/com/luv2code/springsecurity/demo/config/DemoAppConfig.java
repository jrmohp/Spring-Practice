package com.jrm.springsecurity.prac.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = " com.jrm.springsecurity.prac")
public class DemoAppConfig {
    //define bean for view resolver

    @Bean
    public ViewResolver viewResolver()
    {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB_INF/view");
        viewResolver.setSuffix(".jsp");

        return viewResolver;
    }
}