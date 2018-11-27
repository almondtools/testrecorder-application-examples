package net.amygdalum.testrecorder.appexamples.tomcat.servlet;

public class Add implements Action {

	private TodoList list;
	private Integer id;
	private String name;

	public Add(TodoList list, String id, String name) {
		this.list = list;
		this.id = Integer.parseInt(id);
		this.name = name;
	}

	@Override
	public void execute(StringBuilder buffer) {
		list.add(id, new TodoItem(id, name));

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
