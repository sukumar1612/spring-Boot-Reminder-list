package com.reminderwebapp.reminderwebapp;

import com.reminderwebapp.reminderwebapp.allsql.Unap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RegisterController {
    @Autowired
    Unap un; // unap = UserNameAndPassword

    @RequestMapping("/register")
    public String register() {
        return "register_n.jsp";  
    }
    @RequestMapping("/register_n")
    public String register_n(UserNameAndPassword us) {
        un.save(us);
        return "redirect:/";      
    }
}
