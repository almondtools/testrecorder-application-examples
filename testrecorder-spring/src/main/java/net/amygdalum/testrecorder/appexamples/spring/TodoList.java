package net.amygdalum.testrecorder.appexamples.spring;

import java.util.Collection;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import net.amygdalum.testrecorder.profile.Facade;
import net.amygdalum.testrecorder.profile.Recorded;

@Component
public class TodoList {

	@Autowired
	@Facade
	private TodoItemRepository items;
	
	public TodoList() {
	}

	public Collection<TodoItem> items() {
		return StreamSupport.stream(items.findAll().spliterator(), false)
            .collect(Collectors.toList());
	}

	@Recorded
	public int add(String name) {
		int key = (int) items.count();
		TodoItem item = items.save(new TodoItem(key, name));
		return item.getNumber();
	}

	public void insert(int id, String name) {
		TodoItem[] relocatedItems = IntStream.rangeClosed(id, (int) items.count())
			.mapToObj(Integer::valueOf)
			.map(items::findByNumber)
			.filter(Objects::nonNull)
			.toArray(TodoItem[]::new);

		for (TodoItem item : relocatedItems) {
			items.delete(item);
		}
		for (TodoItem item : relocatedItems) {
			int newId = item.getNumber() + 1;
			String  newName = item.getName();
			items.save(new TodoItem(newId, newName));
		}
		items.save(new TodoItem(id, name));
	}

	public String remove(Integer id) {
		TodoItem removed = items.findByNumber(id);
		

		if (removed != null) {
			items.delete(removed);
			
			TodoItem[] relocatedItems = IntStream.rangeClosed(id+1, (int) items.count())
				.mapToObj(Integer::valueOf)
				.map(items::findByNumber)
				.filter(Objects::nonNull)
				.toArray(TodoItem[]::new);

			for (TodoItem item : relocatedItems) {
				items.delete(item);
			}
			for (TodoItem item : relocatedItems) {
				int newId = item.getNumber() - 1;
				String  newName = item.getName();
				items.save(new TodoItem(newId, newName));
			}
			return removed.getName();
		} else {
			return "";
		}
	}

}