package com.example.testweb.listener.context;

import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.ServletContextListener;

@Configuration
public class CustomServletContextListenerConfiguration {

    @Bean
    public ServletListenerRegistrationBean<ServletContextListener> servletListener() {
        return new ServletListenerRegistrationBean<>(new CustomServletContextListener());
    }
}
