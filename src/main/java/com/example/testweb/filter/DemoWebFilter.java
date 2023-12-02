package com.example.testweb.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import javax.servlet.*;
import java.io.IOException;


public class DemoWebFilter implements Filter {

    private final static Logger log = LoggerFactory.getLogger(DemoWebFilter.class);
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        log.info("DemoWebFilter init");
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        // 在請求之前執行的代碼
        long startTime = System.currentTimeMillis();

        filterChain.doFilter(request, response); // 繼續執行其他的Filter和目標資源

        // 在請求之後執行的代碼
        long endTime = System.currentTimeMillis();
        log.info("請求處理時間: {} 毫秒",(endTime - startTime) );

    }

    @Override
    public void destroy() {
        log.info("DemoWebFilter destroy");
        Filter.super.destroy();
    }
}
