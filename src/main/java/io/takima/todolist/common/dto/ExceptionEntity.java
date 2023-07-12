package io.takima.todolist.common.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.web.context.request.WebRequest;
import jakarta.validation.constraints.NotBlank;
import java.time.LocalDateTime;

@Getter
@Setter
public class ExceptionEntity {
    @NotNull
    @JsonIgnore
    private HttpStatus status;
    @Nullable
    private String message;
    @Nullable
    private String code;
    @NotNull
    @JsonIgnore
    private HttpHeaders headers;
    @Nullable
    private Object data;
    private LocalDateTime timestamp = LocalDateTime.now();
    @JsonIgnore
    private Throwable cause;

    /**
     * @param status  the Http status this exception is mapped to
     * @param message The exception's message, typically got from {@link Exception#getMessage()}
     * @param code    any custom API error code
     * @param headers any custom header to be set when this exception is raised
     * @param data    any additional data this exception refers to.
     */
    public ExceptionEntity(@NotNull Throwable cause,
                            @Nullable HttpStatus status,
                            @Nullable String message,
                            @Nullable String code,
                            @Nullable HttpHeaders headers,
                            @Nullable Object data) {
        this.cause = cause;
        this.message = message != null ? message : cause.getMessage();
        this.status = status != null ? status : HttpStatus.INTERNAL_SERVER_ERROR;
        this.code = code;
        this.headers = headers != null ? headers : new HttpHeaders();
        this.data = data;
    }

    public ExceptionEntity(ExceptionEntity exceptionEntity) {
        ExceptionEntity ee = exceptionEntity;
        this.status = ee.status;
        this.cause = ee.cause;
        this.message = ee.message;
        this.code = ee.code;
        this.headers = ee.headers;
        this.data = ee.data;
        this.timestamp = ee.timestamp;
    }

    public ResponseEntity<ExceptionEntity> toResponseEntity(WebRequest request) {
        return new ResponseEntity<>(this, headers, status);
    }
    public ExceptionEntity() {
    }


    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }

    @Nullable
    public String getMessage() {
        return message;
    }

    public void setMessage(@Nullable String message) {
        this.message = message;
    }

    @Nullable
    public String getCode() {
        return code;
    }

    public void setCode(@Nullable String code) {
        this.code = code;
    }

    public HttpHeaders getHeaders() {
        return headers;
    }

    public void setHeaders(HttpHeaders headers) {
        this.headers = headers;
    }

    @Nullable
    public Object getData() {
        return data;
    }

    public void setData(@Nullable Object data) {
        this.data = data;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }
    public Throwable getCause() {
        return this.cause;
    }
    public void setCause(Throwable cause) {
        this.cause = cause;
    }
    public static class Builder {
        private ExceptionEntity exceptionEntity = new ExceptionEntity();
        public ExceptionEntity.Builder cause(Throwable cause) {
            this.exceptionEntity.cause = cause;
            return this;
        }

        public ExceptionEntity.Builder message(String message) {
            this.exceptionEntity.message = message;
            return this;
        }

        public ExceptionEntity.Builder status(HttpStatus status) {
            this.exceptionEntity.status = status;
            return this;
        }

        public ExceptionEntity.Builder code(String code) {
            this.exceptionEntity.code = code;
            return this;
        }

        public ExceptionEntity.Builder headers(HttpHeaders headers) {
            this.exceptionEntity.headers = headers;
            return this;
        }

        public ExceptionEntity.Builder data(Object data) {
            this.exceptionEntity.data = data;
            return this;
        }
        public ExceptionEntity build() {
            return new ExceptionEntity(exceptionEntity);
        }


    }

}


