package com.reminderwebapp.reminderwebapp.allsql;

import org.springframework.data.repository.CrudRepository;
import com.reminderwebapp.reminderwebapp.UserNameAndPassword;

public interface Unap extends CrudRepository<UserNameAndPassword, String>
{

}
