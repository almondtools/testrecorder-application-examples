package net.amygdalum.testrecorder.appexamples.tomcat.servlet;

public class Init implements Action {

	private TodoList list;

	public Init(TodoList list) {
		this.list = list;
	}

	@Override
	public void execute(StringBuilder buffer) {
		list.add(1, new TodoItem(1,"Requirements"));	
		list.add(2, new TodoItem(2,"Design"));
		list.add(3, new TodoItem(3, "Implementation"));
		list.add(4, new TodoItem(4, "Test"));
		buffer.append("<html><body>");
		buffer.append("<ul>");
		for (TodoItem item : list.items()) {
			buffer.append("<li>");
			buffer.append(item.getId()).append("\t").append(item.getName()).append("<a href=\"?action=delete&id="+item.getId()+"\">-</a>");
			buffer.append("</li>");
		}
		buffer.append("</ul>");
		buffer.append("</body></html>");
	}

}
