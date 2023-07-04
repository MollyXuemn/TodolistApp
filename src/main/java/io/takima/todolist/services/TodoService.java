package io.takima.todolist.services;

import io.takima.todolist.models.TodoItem;
import io.takima.todolist.repositories.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class TodoService {
    private final TodoRepository todoRepository;
    @Autowired
    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    public List<TodoItem> findAll(){
        return todoRepository.findAll();
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
