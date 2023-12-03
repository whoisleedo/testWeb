package com.example.testweb.session;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import javax.servlet.http.HttpSession;

@Controller
public class SessionController {

    private final static Logger log = LoggerFactory.getLogger(SessionController.class);

    @GetMapping("/setName")
    public String setName(@RequestParam(value = "name", required = false) String name, HttpSession session) {
       log.info("setName:{} , sessionId:{}",name,session.getId());
        session.setAttribute("name", name);
        return "nameSet";
    }

    @GetMapping("/getName")
    public String getName(HttpSession session, Model model) {
        String name = (String) session.getAttribute("name");
        log.info("getName:{} , sessionId:{}" , name , session.getId());
        if (name != null) {
            model.addAttribute("name", name);
        } else {
            model.addAttribute("name", "Unknown");
        }
        return "showName";
    }
}
