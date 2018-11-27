package net.amygdalum.testrecorder.appexamples.tomcat.servlet;

public class Remove implements Action {

	private TodoList list;
	private Integer id;

	public Remove(TodoList list, String id) {
		this.list = list;
		this.id = Integer.parseInt(id);
	}

	@Override
	public void execute(StringBuilder buffer) {
		list.remove(id);

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
