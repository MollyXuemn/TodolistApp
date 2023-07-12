package io.takima.todolist.services;

import io.takima.todolist.common.pagination.PageSearch;
import io.takima.todolist.models.TodoItem;
import io.takima.todolist.repositories.TodoDao;
import io.takima.todolist.repositories.impl.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class TodoService {
    private final TodoRepository todoRepository;
    private final TodoDao todoDao;
    @Autowired
    public TodoService(TodoRepository todoRepository,TodoDao todoDao) {
        this.todoRepository = todoRepository;
        this.todoDao = todoDao;
    }

    public Page<TodoItem> findAll(PageSearch pageSearch){
        return todoDao.findAll(pageSearch);
    }

    public Optional<TodoItem> findById(Long id){
        return todoRepository.findById(id);
    }
    @Transactional
    public TodoItem save(TodoItem item){
        return todoRepository.save(item);
    }
    @Transactional
    public void delete(Long id){
        todoRepository.deleteById(id);
    }
}
