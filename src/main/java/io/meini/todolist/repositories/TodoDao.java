package io.meini.todolist.repositories;

import io.meini.todolist.common.pagination.PageSearch;
import io.meini.todolist.models.TodoItem;
import org.springframework.data.domain.Page;

import java.util.Optional;

public interface TodoDao {
    Page<TodoItem> findAll(PageSearch pageSearch);

    Optional<TodoItem> findById(Long id);
    TodoItem save(TodoItem item);

}
