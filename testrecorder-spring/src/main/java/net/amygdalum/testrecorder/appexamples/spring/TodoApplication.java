package net.amygdalum.testrecorder.appexamples.spring;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.joining;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TodoApplication implements CommandLineRunner {

	@Autowired
	private TodoList list;

	public static void main(String[] args) {
		SpringApplication.run(TodoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Scanner command = new Scanner(System.in);
		list.add("Have a Shower");
		list.add("Brush your Teeth");
		list.add("Have Breakfast");
		list.add("Make your Bed");

		mainloop: while (true) {
			System.out.println(toString(list));
			System.out.println();
			System.out.println("a(dd), i(nsert), (r)emove items, or (q)uit:");
			String col = command.findInLine("\\w");
			switch (col) {
			case "a":
				add(list, command);
				break;
			case "i":
				insert(list, command);
				break;
			case "r":
				remove(list, command);
				break;
			case "q":
				break mainloop;
			}
			command.nextLine();
		}
		command.close();
	}

	private static void add(TodoList list, Scanner command) {
		String name = command.findInLine("\\w.*");
		int id = list.add(name);
		System.out.println("added " + id + ":\t" + name);
	}

	private static void insert(TodoList list, Scanner command) {
		int id = Integer.parseInt(command.findInLine("\\d+"));
		String name = command.findInLine("\\w.*");
		list.insert(id, name);
		System.out.println("inserted " + id + ":\t" + name);
	}

	private static void remove(TodoList list, Scanner command) {
		int id = Integer.parseInt(command.findInLine("\\d+"));
		String name = list.remove(id);
		System.out.println("removed " + id + ":\t" + name);
	}

	private static String toString(TodoList list) {
		return list.items().stream()
			.sorted(comparing(TodoItem::getNumber))
			.map(item -> item.getNumber() + ":\t" + item.getName() + "\n")
			.collect(joining());
	}
}
