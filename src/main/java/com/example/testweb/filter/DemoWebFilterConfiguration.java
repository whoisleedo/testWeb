package com.example.testweb.filter;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DemoWebFilterConfiguration {
    @Bean
    public FilterRegistrationBean<DemoWebFilter> myFilterRegistration() {
        FilterRegistrationBean<DemoWebFilter> registration = new FilterRegistrationBean<>();
        registration.setFilter(new DemoWebFilter());
        registration.addUrlPatterns("/*");
        return registration;
    }
}
