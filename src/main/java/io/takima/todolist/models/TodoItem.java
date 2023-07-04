package io.takima.todolist.models;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
public class TodoItem {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="todo_id_seq")
    Long id;
    @NotBlank
    @Column
    String title;
    @Column
    String description;
    @Column
    LocalDateTime createdAt;
    @Column
    LocalDateTime lastModified;
    @Column
    Boolean isDone;

    public TodoItem(Long id, String title, String description, LocalDateTime createdAt, LocalDateTime lastModified, Boolean isDone) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.createdAt = createdAt;
        this.lastModified = lastModified;
        this.isDone = isDone;
    }

    public TodoItem() {
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

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TodoItem todoItem = (TodoItem) o;

        return Objects.equals(id, todoItem.id);
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

}
