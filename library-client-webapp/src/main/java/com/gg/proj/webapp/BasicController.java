package com.gg.proj.webapp;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BasicController {

    @RequestMapping(value = {"/index", "/home", "/"})
    public String index() {
        return "index";
    }

    @RequestMapping(value= "/login")
    public String login() {
        return "login";
    }

    // Login form with error
    @RequestMapping("/login-error")
    public String loginError(Model model) {
        model.addAttribute("loginError", true);
        return "login";
    }

    @RequestMapping(value="/perform_logout")
    public String logout() {
        return "index";
    }

}
