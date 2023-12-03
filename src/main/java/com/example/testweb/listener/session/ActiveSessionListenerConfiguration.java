package com.example.testweb.listener.session;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.http.HttpSessionListener;

@Configuration
public class ActiveSessionListenerConfiguration {

    @Bean
    public HttpSessionListener httpSessionListener() {
        return new ActiveSessionListener();
    }
}
