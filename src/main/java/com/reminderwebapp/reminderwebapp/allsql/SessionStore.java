package com.reminderwebapp.reminderwebapp.allsql;

import com.reminderwebapp.reminderwebapp.entityclasses.SessionMapper;

import org.springframework.data.repository.CrudRepository;

public interface SessionStore extends CrudRepository<SessionMapper, String>
{

}
