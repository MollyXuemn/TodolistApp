package io.takima.todolist.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.takima.todolist.services.TodoService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
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

}


