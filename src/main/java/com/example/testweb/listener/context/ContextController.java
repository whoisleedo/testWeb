package com.example.testweb.listener.context;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletContext;

@Controller
public class ContextController {
    @Autowired
    private ServletContext servletContext;

    @GetMapping("/getMyData")
    @ResponseBody
    public String getMyData() {
        // 從 ServletContext 中獲取數據
        String data = (String) servletContext.getAttribute("myData");
        return "獲取的數據: " + data;
    }
}
