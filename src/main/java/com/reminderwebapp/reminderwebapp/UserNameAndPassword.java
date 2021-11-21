package com.reminderwebapp.reminderwebapp;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.reminderwebapp.reminderwebapp.allsql.SessionStore;
import com.reminderwebapp.reminderwebapp.allsql.Unap;

import org.springframework.beans.factory.annotation.Autowired;

@Entity
public class UserNameAndPassword {
    @Id
    private String username;
    private String password;
    
    public UserNameAndPassword(){}
    public UserNameAndPassword(String username, String password) {
        this.username = username;
        this.password = password;
    }


    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    public static Boolean authenticate(UserNameAndPassword user, Unap un)
    {
        UserNameAndPassword newUs = un.findById(user.getUsername()).orElse(null);
        
        if(newUs==null || !newUs.getPassword().equals(user.getPassword()))
        {
            return false;
        }
        return true;
    }
    public static Boolean checkLogin(String SessionId, SessionStore store)
    {
        SessionMapper newSes=store.findById(SessionId).orElse(null);
        if(newSes==null)
        {
            return false;
        }
        return true;
    }
}
