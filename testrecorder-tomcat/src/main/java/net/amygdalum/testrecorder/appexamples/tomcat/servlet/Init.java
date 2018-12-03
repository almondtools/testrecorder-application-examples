package net.amygdalum.testrecorder.appexamples.tomcat.servlet;

public class Init implements Action {

	private TodoList list;

	public Init(TodoList list) {
		this.list = list;
	}

	@Override
	public String execute() {
		list.add("Have a Shower");
		list.add("Brush your Teeth");
		list.add("Have Breakfast");
		list.add("Make your Bed");
		
		return "initialized list";
	}

}
