package io.meini.todolist.repositories.impl;

import io.meini.todolist.common.pagination.PageSearch;
import io.meini.todolist.repositories.TodoDao;
import io.meini.todolist.models.TodoItem;

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
