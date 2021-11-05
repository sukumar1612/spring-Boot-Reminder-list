package com.reminderwebapp.reminderwebapp;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class SessionMapper {
    @Id
    private String SessionId;
    private String username;


    public String getSessionId() {
        return this.SessionId;
    }

    public void setSessionId(String SessionId) {
        this.SessionId = SessionId;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    
}
