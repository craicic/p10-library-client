package com.gg.proj.webapp;

import com.gg.proj.authentication.UserInfo;
import com.gg.proj.business.UserManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class BasicController {

    private UserManager userManager;

    public BasicController() {
    }

    @Autowired
    public BasicController(UserManager userManager) {
        this.userManager = userManager;
    }

    @RequestMapping(value = {"/index", "/home", "/"})
    public String index() {
        return "index";
    }

    @RequestMapping(value = "/login")
    public String login(@RequestParam(value = "error", required = false) String error,
                        @RequestParam(value = "logout", required = false) String logout,
                        Model model) {
        String errorMessage = null;
        String logoutMessage = null;
        if (error != null) {
            errorMessage = "Invalid credentials !";
        }
        if (logout != null) {
            logoutMessage = "You have been successfully logged out";
        }
        model.addAttribute("errorMessage", errorMessage);
        model.addAttribute("logoutMessage", logoutMessage);
        return "login";
    }


    @RequestMapping(value = "/perform_logout")
    public String logout() {
        UserInfo userInfo = (UserInfo) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        System.out.println(userManager.logoutUser(userInfo.getTokenUUID()));
        return "index";
    }

}
