package net.amygdalum.testrecorder.appexamples.tomcat.servlet;

import java.util.Collection;
import java.util.SortedMap;
import java.util.TreeMap;

import net.amygdalum.testrecorder.profile.Recorded;

public class TodoList {

	private SortedMap<Integer, TodoItem> items;

	public TodoList() {
		items = new TreeMap<>();
	}
	
	public Collection<TodoItem> items() {
		return items.values();
	}

	@Recorded
	public void add(Integer id, TodoItem item) {
		items.put(id, item);
	}

	public void remove(Integer id) {
		items.remove(id);
	}

}
