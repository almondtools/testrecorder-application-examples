package net.amygdalum.testrecorder.appexamples.tomcat.servlet;

public class Remove implements Action {

	private TodoList list;
	private Integer id;

	public Remove(TodoList list, String id) {
		this.list = list;
		this.id = Integer.parseInt(id);
	}

	@Override
	public String execute() {
		String name = list.remove(id);

		return "removed " + id + ":\t " + name;  
	}

}
