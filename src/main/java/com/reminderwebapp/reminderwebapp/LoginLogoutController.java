package com.reminderwebapp.reminderwebapp;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.reminderwebapp.reminderwebapp.allsql.SessionStore;
import com.reminderwebapp.reminderwebapp.allsql.ToDoStore;
import com.reminderwebapp.reminderwebapp.allsql.Unap;
import com.reminderwebapp.reminderwebapp.entityclasses.SessionMapper;
import com.reminderwebapp.reminderwebapp.entityclasses.ToDoItem;
import com.reminderwebapp.reminderwebapp.entityclasses.UserNameAndPassword;

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
    @Autowired
    ToDoStore todo;
    
    @RequestMapping("/")
    public String displayWebPage() {
        return "login_n.jsp";
    }

    @RequestMapping("/loginUser")
    public String login(UserNameAndPassword us, HttpSession session) {
        SessionMapper newses = new SessionMapper();
        
        session.setAttribute("SessionId", session.getId());
        newses.setSessionId(session.getId());
        newses.setUsername(us.getUsername());

        System.out.println(session.getId());
        

        if(UserNameAndPassword.authenticate(us, this.un))
        {
            store.save(newses);
            return "redirect:/home";
        }
        return "redirect:/";
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
