package com.reminderwebapp.reminderwebapp.entityclasses;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ToDoItem {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
	
	private String username;
	private String item;
	private long deadline;
	
	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
	public String getUsername() {
		return this.username;
	}
	public void setUsername(String username) {
		this.username = username;
	}

	public String getItem() {
		return item;
	}
	public void setItem(String item) {
		this.item = item;
	}
	public long getDeadline() {
		return deadline;
	}
	public void setDeadline() {
		this.deadline = System.currentTimeMillis() / 1000L;
	}
	// @Override
	// public String toString() {
	// 	return "ToDoItem [item=" + item + ", deadline=" + deadline + "]";
	// }
}

