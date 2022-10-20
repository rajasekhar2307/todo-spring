package com.rajasekhar.app.todo.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("name")
public class HomeController {

    @RequestMapping("/")
    public static String homeView(ModelMap model){
        model.put("name", getLoggedInUsername());
        return "welcome";
    }

    private static String getLoggedInUsername() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        return authentication.getName();
    }
}
