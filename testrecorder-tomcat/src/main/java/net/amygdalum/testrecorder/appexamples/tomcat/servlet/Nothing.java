package net.amygdalum.testrecorder.appexamples.tomcat.servlet;

public class Nothing implements Action {

	public Nothing(TodoList list) {
	}

	@Override
	public String execute() {
		return "";
	}

}
