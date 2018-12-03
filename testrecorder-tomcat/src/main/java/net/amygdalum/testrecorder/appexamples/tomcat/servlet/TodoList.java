package net.amygdalum.testrecorder.appexamples.tomcat.servlet;

import java.util.Collection;
import java.util.NavigableMap;
import java.util.TreeMap;

import net.amygdalum.testrecorder.profile.Recorded;

public class TodoList {

	private NavigableMap<Integer, TodoItem> items;

	public TodoList() {
		items = new TreeMap<>();
	}

	public Collection<TodoItem> items() {
		return items.values();
	}

	@Recorded
	public int add(String name) {
		int key = items.isEmpty() ? 0 : items.lastKey() + 1;
		items.put(key, new TodoItem(key, name));
		return key;
	}

	public void insert(int id, String name) {
		Integer[] relocatedKeys = items.descendingKeySet().headSet(id, true).toArray(new Integer[0]);

		for (Integer key : relocatedKeys) {
			TodoItem item = items.remove(key);
			int newId = key + 1;
			String  newName = item.getName();
			items.put(newId, new TodoItem(newId, newName));
		}
		items.put(id, new TodoItem(id, name));
	}

	public String remove(Integer id) {
		TodoItem removed = items.remove(id);

		if (removed != null) {
			Integer[] relocatedKeys = items.navigableKeySet().tailSet(id).toArray(new Integer[0]);

			for (Integer key : relocatedKeys) {
				TodoItem item = items.remove(key);
				int newId = key - 1;
				String newName = item.getName();
				items.put(newId, new TodoItem(newId, newName));
			}
			return removed.getName();
		} else {
			return "";
		}
	}

}