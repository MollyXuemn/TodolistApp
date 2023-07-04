package io.takima.todolist.service;

import io.takima.todolist.models.TodoItem;
import io.takima.todolist.repositories.impl.TodoRepository;
import io.takima.todolist.services.TodoService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.NoSuchElementException;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(MockitoExtension.class)
@DisplayName("Todo Service Test:")
public class TodoServiceTest {
    @Mock
    TodoRepository todoRepository;
    TodoService todoService = new TodoService(todoRepository);
    @BeforeEach
    void setUp() {
        todoService = new TodoService(todoRepository);
    }
    @DisplayName("method 'getForCustomer(Long)'")
    @Nested
    class FindByIdMethod {
        @Nested
        @DisplayName("given an existing id")
        class WithValidId {
            Long todoItemId = 1L;

            @Test
            @DisplayName("should return a todo item")
            void shouldReturnTodoItem() {
                Mockito.when(todoRepository.findById(Mockito.any())).thenReturn(Optional.of(new TodoItem(todoItemId, "title", "description",  LocalDateTime.now(), LocalDateTime.now(), false)));
                var todoItem = todoService.findById(todoItemId);

                assertEquals(todoItemId, todoItem.get().getId());
            }
        }
        @Nested
        @DisplayName("given an id that does not exist")
        class WithInvalidId {
            Long todoItemId = 99999L;

            @Test
            @DisplayName("should return an empty observable")
            void shouldThrow() {
                Mockito.when(todoRepository.findById(Mockito.any())).thenThrow(new NoSuchElementException());
                assertThrows(NoSuchElementException.class, () -> todoService.findById(todoItemId));
            }
        }
    }
}
//@SpringBootTest
//@ExtendWith(SpringExtension.class)
//@DisplayName("method save()")
//@Transactional
//class TodoServiceSaveMethodTest {
//
//    @Autowired
//    TodoService todoService;
//
//    @Test
//    @DisplayName("should persist todoitem")
//    void shouldPersistTodoItem() {
//        var todoItem = todoService.findById(1L);
//    }
//}

