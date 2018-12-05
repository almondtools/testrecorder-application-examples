package net.amygdalum.testrecorder.appexamples.spring;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TodoItemRepository extends CrudRepository<TodoItem, Integer> {

	@Query("select id, number, name from todo_item where number = :number")
	public TodoItem findByNumber(@Param("number") int number);

}
