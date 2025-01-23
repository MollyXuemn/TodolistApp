package io.meini.todolist.controller.response;

import io.meini.todolist.models.TodoItem;

import java.time.LocalDateTime;

public class TodoUpdateDTO {
    Long id;
    String title;
    String description;
    LocalDateTime lastModified;
    Boolean isDone;

    public TodoUpdateDTO(Long id, String title, String description, LocalDateTime lastModified, Boolean isDone) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.lastModified = lastModified;
        this.isDone = isDone;
    }

    public static TodoUpdateDTO fromModel(TodoItem todoItem) {
        return new TodoUpdateDTO(todoItem.getId(), todoItem.getTitle(), todoItem.getDescription(), todoItem.getLastModified(), todoItem.getDone());
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getLastModified() {
        return lastModified;
    }

    public void setLastModified(LocalDateTime lastModified) {
        this.lastModified = lastModified;
    }

    public Boolean getDone() {
        return isDone;
    }

    public void setDone(Boolean done) {
        isDone = done;
    }
}
