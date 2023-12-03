package com.example.testweb.cookie;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@Controller
public class CookieController {

    private final static Logger log = LoggerFactory.getLogger(CookieController.class);

    @GetMapping("/setTheme")
    public String setTheme(@RequestParam(value = "theme" , required = false , defaultValue = "default") String theme,
                           HttpServletResponse response) {

        log.info("setTheme color:{}" , theme);
        Cookie cookie = new Cookie("theme", theme);
        cookie.setMaxAge(5 * 60); // 保存5 min
        cookie.setHttpOnly(true); // 設置 HttpOnly 標誌
        response.addCookie(cookie);
        return "redirect:/getTheme";
    }

    @GetMapping("/getTheme")
    public String getTheme(HttpServletRequest request, Model model) {
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if ("theme".equals(cookie.getName())) {
                    String theme = cookie.getValue();
                    log.info("getTheme color:{}" , theme);
                    model.addAttribute("theme", theme);
                    model.addAttribute("themeClass" , getCssClassForTheme(theme));
                    break;
                }
            }
        }
        return "showTheme";
    }

    private String getCssClassForTheme(String theme) {
        switch (theme){
            case "light":
                return "light-theme";
            case "dark":
                return  "dark-theme";
            default:
                return "default-theme";
        }
        
    }


}
