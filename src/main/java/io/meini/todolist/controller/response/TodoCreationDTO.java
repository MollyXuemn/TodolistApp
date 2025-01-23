package io.meini.todolist.controller.response;

import io.meini.todolist.models.TodoItem;

import java.time.LocalDateTime;

public class TodoCreationDTO {
    Long id;
    String title;
    LocalDateTime createdAt;
    Boolean isDone;

    public TodoCreationDTO(Long id, String title, LocalDateTime createdAt, Boolean isDone) {
        this.id = id;
        this.title = title;
        this.createdAt = createdAt;
        this.isDone = isDone;
    }
    public static TodoCreationDTO fromModel(TodoItem todoItem) {
        return new TodoCreationDTO(todoItem.getId(), todoItem.getTitle(), todoItem.getCreatedAt(), todoItem.getDone());
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public Boolean getDone() {
        return isDone;
    }

    public void setDone(Boolean done) {
        isDone = done;
    }
}
