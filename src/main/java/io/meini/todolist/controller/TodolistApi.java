package io.meini.todolist.controller;

import io.meini.todolist.common.pagination.PageSearch;
import io.meini.todolist.common.pagination.SearchSpecification;
import io.meini.todolist.controller.response.TodoCreationDTO;
import io.meini.todolist.controller.response.TodoUpdateDTO;
import io.meini.todolist.models.TodoItem;
import io.meini.todolist.services.TodoService;
import lombok.AllArgsConstructor;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.web.SortDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.NoSuchElementException;
import java.util.Optional;

@RestController
@RequestMapping("/api/todo-items")
@AllArgsConstructor
public class TodolistApi {
    private final TodoService todoService;
    @GetMapping
    public Page<TodoItem> findAll(
            @RequestParam(defaultValue = "20") int limit,
            @RequestParam(defaultValue = "0") int offset,
            @RequestParam(required = false) String search,
            @SortDefault Sort sort
    ){
        Specification<TodoItem> spec = (search != null) ? SearchSpecification.parse(search) : Specification.where(null);
        return todoService.findAll(new PageSearch.Builder<TodoItem>()
                .limit(limit)
                .offset(offset)
                .search(spec)
                .sort(sort).build());

    }
    @GetMapping(value = "/{id}")
    public Optional<TodoItem> getOne(@PathVariable long id) {
        TodoItem todoItem = todoService.findById(id)
                .orElseThrow(() -> new NoSuchElementException(String.format("no todoItem with id %d", id)));
        return  todoService.findById(id);
    }
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<TodoCreationDTO> create(@RequestBody() TodoItem item) {
        if (item.getId() != null) {
            throw new IllegalArgumentException("cannot create an item and specify the ID");
        }
        return ResponseEntity.ok(TodoCreationDTO.fromModel(todoService.save(item)));
    }
    @PutMapping
    public ResponseEntity<TodoUpdateDTO> update(@RequestBody() TodoItem item) {
        if (item.getId() == null) {
            throw new IllegalArgumentException("did not specify the ID of item to update");
        }
        return ResponseEntity.ok(TodoUpdateDTO.fromModel(todoService.save(item)));
    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable long id) {
        todoService.delete(id);
    }

}
