package com.reminderwebapp.reminderwebapp.allsql;

import com.reminderwebapp.reminderwebapp.entityclasses.UserNameAndPassword;

import org.springframework.data.repository.CrudRepository;

public interface Unap extends CrudRepository<UserNameAndPassword, String>
{

}
