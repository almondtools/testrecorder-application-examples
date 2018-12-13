package net.amygdalum.testrecorder.appexamples.spring;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import net.amygdalum.testrecorder.profile.Input;
import net.amygdalum.testrecorder.profile.Output;

@Repository
public interface TodoItemRepository extends CrudRepository<TodoItem, Integer> {

	@Input
	@Query("select id, number, name from todo_item where number = :number")
	TodoItem findByNumber(@Param("number") int number);

	@Input
	long count();
	
	@Output
	<S extends TodoItem> S save(S entity);
}
