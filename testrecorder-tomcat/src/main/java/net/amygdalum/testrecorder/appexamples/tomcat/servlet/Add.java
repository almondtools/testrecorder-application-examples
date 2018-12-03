package net.amygdalum.testrecorder.appexamples.tomcat.servlet;

public class Add implements Action {

	private TodoList list;
	private String name;

	public Add(TodoList list, String name) {
		this.list = list;
		this.name = name;
	}

	@Override
	public String execute() {
		int id = list.add(name);

		return "added " + id + ":\t " + name;  
	}

}
