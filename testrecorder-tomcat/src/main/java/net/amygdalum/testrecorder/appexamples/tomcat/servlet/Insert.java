package net.amygdalum.testrecorder.appexamples.tomcat.servlet;

public class Insert implements Action {

	private TodoList list;
	private Integer id;
	private String name;

	public Insert(TodoList list, String id, String name) {
		this.list = list;
		this.id = Integer.parseInt(id);
		this.name = name;
	}

	@Override
	public String execute() {
		list.insert(id, name);
		
		return "inserted " + id + ":\t " + name;  
	}

}
