package com.reminderwebapp.reminderwebapp;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.reminderwebapp.reminderwebapp.allsql.SessionStore;
import com.reminderwebapp.reminderwebapp.allsql.Unap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginLogoutController {
    @Autowired
    Unap un; // unap = UserNameAndPassword
    @Autowired
    SessionStore store; // session store

    @RequestMapping("/")
    public String displayWebPage() {
        return "login_n.jsp";
    }

    @RequestMapping("/home")
    public String home(HttpServletRequest req) {
        HttpSession session = req.getSession();
        // remove later
        System.out.println(session.getAttribute("UserName"));
        System.out.println("Logged in :"+UserNameAndPassword.checkLogin(session.getId(), store));
        //
        return "front.jsp";
    }

    @RequestMapping("/loginUser")
    public String login(UserNameAndPassword us, HttpSession session) {
        SessionMapper newses = new SessionMapper();
        newses.setSessionId(session.getId());
        newses.setUsername(us.getUsername());
        store.save(newses);
        // remove later
        session.setAttribute("UserName", session.getId());
        System.out.println(session.getId());
        //
        System.out.println("Valid user : "+UserNameAndPassword.authenticate(us, un));
        return "redirect:/home";
    }

    @RequestMapping("/logout")
    public String logout(HttpSession session) {
        SessionMapper newses = store.findById(session.getId()).orElse(null);
        if(newses!=null) 
        {
            store.delete(newses);
        }
        // remove later
        System.out.println("Logged in :"+UserNameAndPassword.checkLogin(session.getId(), store));
        //
        return "login_n.jsp";
    }
}
