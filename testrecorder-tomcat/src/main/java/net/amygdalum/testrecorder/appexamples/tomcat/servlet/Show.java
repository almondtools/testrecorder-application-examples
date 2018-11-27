package net.amygdalum.testrecorder.appexamples.tomcat.servlet;

public class Show implements Action {

	private TodoList list;

	public Show(TodoList list) {
		this.list = list;
	}

	@Override
	public void execute(StringBuilder buffer) {
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
