package com.gg.proj.webapp;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class BasicController {

    @RequestMapping(value = {"/index", "/home", "/"})
    public String index() {
        return "index";
    }

    @RequestMapping(value= "/login")
    public String login(@RequestParam(value = "error", required = false) String error,
                        @RequestParam(value = "logout", required = false) String logout,
                        Model model){
        String errorMessage = null;
        String logoutMessage = null;
        if(error != null) {
            errorMessage = "Invalid credentials !";
        }
        if(logout != null) {
            logoutMessage = "You have been successfully logged out";
        }
        model.addAttribute("errorMessage", errorMessage);
        model.addAttribute("logoutMessage", logoutMessage);
        return "login";
    }


    @RequestMapping(value="/perform_logout")
    public String logout() {
        return "index";
    }

}
