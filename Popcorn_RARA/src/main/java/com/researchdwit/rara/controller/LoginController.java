package com.researchdwit.rara.controller;

import com.researchdwit.rara.config.authenticationdetails.CustomWebAuthenticationDetails;
import com.researchdwit.rara.config.authenticationtoken.TicketNumberAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by saneel on 10/26/15.
 */
@Controller
public class LoginController {

    @RequestMapping("/")
    String index( ModelAndView model) {
        return "login/login";
    }

    @RequestMapping(value = "/login",method = {RequestMethod.GET,RequestMethod.POST})
    public String login() {
        return "login/login";
    }

    @RequestMapping("/user")
    public String user() {
        return "dashboard/userdashboard";
    }

    @RequestMapping("/admin")
    public String admin() {
        return "dashboard/admindashboard";
    }

    @RequestMapping("/ticket")
    public String ticket(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if(authentication instanceof TicketNumberAuthenticationToken){
            String ticketNumber = ((CustomWebAuthenticationDetails)authentication.getDetails()).getTicketNumber();
            model.addAttribute("ticket",ticketNumber);
        }
        return "dashboard/ticketdashboard";
    }

    @RequestMapping("/manager")
    public String manager() {
        return "dashboard/managerdashboard";
    }

    @RequestMapping("/clerk")
    public String clerk() {
        return "dashboard/clerkdashboard";
    }



}
