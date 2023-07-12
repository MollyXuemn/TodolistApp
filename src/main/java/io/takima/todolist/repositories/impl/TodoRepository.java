package io.takima.todolist.repositories.impl;

import io.takima.todolist.common.pagination.PageSearch;
import io.takima.todolist.models.TodoItem;
import io.takima.todolist.repositories.TodoDao;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TodoRepository extends TodoDao, JpaRepository<TodoItem, Long>, JpaSpecificationExecutor<TodoItem> {
    default Page<TodoItem> findAll(PageSearch page){
        return findAll(page.getSearch(), page);
    };
    Optional<TodoItem> findById(Long id);
    TodoItem save(TodoItem item);

}
