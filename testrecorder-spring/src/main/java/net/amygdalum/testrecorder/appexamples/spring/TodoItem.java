package net.amygdalum.testrecorder.appexamples.spring;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;

public class TodoItem {

	@Id
	private long id;
	@Column
	private int number;
	@Column
	private String name;

	public TodoItem(int number, String name) {
		this.number = number;
		this.name = name;
	}
		
	public void setId(long key) {
		this.id = key;
	}
	
	public long getId() {
		return id;
	}
	
	public int getNumber() {
		return number;
	}
	
	public String getName() {
		return name;
	}

}
