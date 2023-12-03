package com.example.testweb.listener.context;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class CustomServletContextListener implements ServletContextListener {

    private final static Logger log = LoggerFactory.getLogger(CustomServletContextListener.class);

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ServletContext ctx = sce.getServletContext();
        ctx.setAttribute("myData", "這是一個大家都可以用的東西，大家都應該可以看到");
        log.info("web demo 啟動 :{}" , sce.getServletContext());

    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        log.info("web demo 關閉 :{}" , sce.getServletContext());
        ServletContextListener.super.contextDestroyed(sce);
    }
}
