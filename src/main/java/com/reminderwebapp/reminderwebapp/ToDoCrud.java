package com.reminderwebapp.reminderwebapp;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.reminderwebapp.reminderwebapp.allsql.SessionStore;
import com.reminderwebapp.reminderwebapp.allsql.ToDoStore;
import com.reminderwebapp.reminderwebapp.allsql.Unap;
import com.reminderwebapp.reminderwebapp.entityclasses.ToDoItem;
import com.reminderwebapp.reminderwebapp.entityclasses.UserNameAndPassword;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class ToDoCrud {
    @Autowired
    ToDoStore todo;
    @Autowired
    Unap un;
    @Autowired
    SessionStore store;

    @RequestMapping("/home")
    public ModelAndView home(HttpServletRequest req) {
        HttpSession session = req.getSession();
        ModelAndView mv=new ModelAndView();
        // remove later
        if (!UserNameAndPassword.checkLogin(session.getId(), this.store))
        {
            mv.setViewName("redirect:/");
            return mv;
        }
        String username = UserNameAndPassword.returnUsername(session.getId(), this.store);
        System.out.println(todo.findByUsername(username));
        
        List<ToDoItem> inf=todo.findByUsername(username);
        mv.setViewName("front.jsp");
        

        System.out.println(session);
        System.out.println("Logged in :"+UserNameAndPassword.checkLogin(session.getId(), this.store));
        
        return mv;
    }

    @RequestMapping(value = "/getData", method = RequestMethod.GET)
    @ResponseBody
    public List<ToDoItem> getData(HttpServletRequest req)
    {
        HttpSession session = req.getSession();
        String username = UserNameAndPassword.returnUsername(session.getId(), this.store);
        return todo.findByUsername(username);
    }

    @RequestMapping(value = "/insertData", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Long> insertData(@RequestBody Map<String, String> payload, HttpServletRequest req)
    {
        HttpSession session = req.getSession();
        String username = UserNameAndPassword.returnUsername(session.getId(), this.store);
        System.out.println(payload);

        ToDoItem td=new ToDoItem();
        td.setUsername(username);
        td.setDeadline();
        td.setItem(payload.get("item"));
        todo.save(td);
        Map<String, Long> mp=new HashMap<String, Long>();
        mp.put("id",td.getId());
        return mp;
    }

    @RequestMapping(value = "/deleteData", method = RequestMethod.POST)
    @ResponseBody
    public void deleteData(@RequestBody Map<String, Long> payload, HttpServletRequest req)
    {
        HttpSession session = req.getSession();
        todo.deleteById(payload.get("id"));
    }

}
