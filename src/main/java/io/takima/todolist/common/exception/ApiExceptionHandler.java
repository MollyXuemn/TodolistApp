package io.takima.todolist.common.exception;

import io.takima.todolist.common.dto.ExceptionEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
@RestControllerAdvice
public class ApiExceptionHandler {
    @ExceptionHandler({ApiException.class})
    public ResponseEntity<ExceptionEntity> handleApiException(ApiException e, WebRequest request) {
        e.printStackTrace();
        return e.getExceptionEntity().toResponseEntity(request);
    }

}
