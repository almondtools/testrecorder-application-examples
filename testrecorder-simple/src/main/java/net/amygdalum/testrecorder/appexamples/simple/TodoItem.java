package net.amygdalum.testrecorder.appexamples.simple;

public class TodoItem {

	private int id;
	private String name;

	public TodoItem(int id, String name) {
		this.id = id;
		this.name = name;
	}
	
	public int getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}

}
