package io.takima.todolist.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.takima.todolist.models.TodoItem;
import io.takima.todolist.services.TodoService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.Optional;

@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = TodolistApi.class)
@DisplayName("/api")
public class TodolistApiIT {
    @Autowired
    private MockMvc mvc;
    @Autowired
    private ObjectMapper objectMapper;
    @MockBean
    private TodoService todoService;

    @Nested
    @DisplayName("GET getTodoItem")
    class GetTodoItem {

        @Test
        @DisplayName("with missing parameter 'todoItemId' should give status 400 BAD_REQUEST")
        void shouldGive400() throws Exception {
            mvc.perform(get("/api/todo-items/id")
                            .contentType(MediaType.APPLICATION_JSON_VALUE))
                    .andExpect(status().isBadRequest());
        }

        @Nested
        @DisplayName("with a valid todoItemId")
        class WithValidTodoItemId {

            @Test
            @DisplayName("should give status 200 OK")
            void shouldGive200() throws Exception {
                Long id = 1L;
                TodoItem mockTodoItem = new TodoItem();
                mockTodoItem.setId(id);

                // Mock the behavior of the todoService.getTodoItem() method
                when(todoService.findById(anyLong())).thenReturn(Optional.of(mockTodoItem));

                mvc.perform(get("/api/todo-items/{id}", id)
                                .pathInfo("/api/todo-items/" + id)
                                .contentType(MediaType.APPLICATION_JSON_VALUE))
                        .andExpect(status().isOk())
                        .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
                        .andExpect(jsonPath("$.id").value(id));

            }

        }
    }

    @Nested
    @DisplayName("POST /")
    class Create {

        @Test
        @DisplayName("with a new TodoItem should give status 201 CREATED")
        void shouldGive200() throws Exception {
            // Arrange
            TodoItem newItem = new TodoItem();
            newItem.setDescription("Buy groceries");

            TodoItem savedItem = new TodoItem();
            savedItem.setId(1L);
            savedItem.setDescription("Buy groceries");

            // Mock the behavior of the todoService.save() method
            when(todoService.save(any(TodoItem.class))).thenReturn(savedItem);

            // Act and Assert
            mvc.perform(post("/api/todo-items")
                            .contentType(MediaType.APPLICATION_JSON)
                            .content(objectMapper.writeValueAsString(newItem)))
                    .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                    .andExpect(status().isOk())
                    .andExpect(jsonPath("$.id").value(savedItem.getId()));
        }
    }

}


