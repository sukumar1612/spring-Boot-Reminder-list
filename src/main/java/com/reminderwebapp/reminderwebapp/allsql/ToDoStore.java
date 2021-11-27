package com.reminderwebapp.reminderwebapp.allsql;
import java.util.List;

import com.reminderwebapp.reminderwebapp.entityclasses.ToDoItem;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface ToDoStore extends JpaRepository<ToDoItem, Long>
{
    List<ToDoItem> findByUsername(String username);
}