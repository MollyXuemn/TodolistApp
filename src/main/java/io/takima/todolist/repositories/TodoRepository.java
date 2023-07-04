package io.takima.todolist.repositories;

import io.takima.todolist.models.TodoItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TodoRepository extends JpaRepository<TodoItem, Long> {
    List<TodoItem> findAll();

    Optional<TodoItem> findById(Long id);
    TodoItem save(TodoItem item);
//    List<TodoItem> findPage(String search, int limit, int offset);

}
