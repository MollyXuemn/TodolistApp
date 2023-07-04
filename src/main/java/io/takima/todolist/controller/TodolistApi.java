package io.takima.todolist.controller;

import io.takima.todolist.models.TodoItem;
import io.takima.todolist.services.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@RestController
@RequestMapping("/api/todo-items")
public class TodolistApi {
    private final TodoService todoService;
    @Autowired
    public TodolistApi(TodoService todoService) {
        this.todoService = todoService;
    }
    @GetMapping
    public List<TodoItem> findAll(){
        return todoService.findAll();
    }
    @GetMapping(value = "/{id}")
    public Optional<TodoItem> getOne(@PathVariable long id) {
        TodoItem todoItem = todoService.findById(id)
                .orElseThrow(() -> new NoSuchElementException(String.format("no todoItem with id %d", id)));
        return  todoService.findById(id);
    }
    @PostMapping(value = "/{id}")
    public TodoItem create(@RequestBody() TodoItem item) {
        if (item.getId() != null) {
            throw new IllegalArgumentException("cannot create an item and specify the ID");
        }
        return todoService.save(item);
//        return new ResponseEntity<>(assembler.toModel(article), HttpStatus.CREATED);
    }
    @PutMapping(value = "/{id}")
    public TodoItem update(@RequestBody() TodoItem item) {
        if (item.getId() == null) {
            throw new IllegalArgumentException("did not specify the ID of item to update");
        }
        return todoService.save(item);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable long id) {
        todoService.delete(id);
    }

}
