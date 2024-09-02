package br.com.rsfot.bookstore.handler.exception;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

@RestControllerAdvice
public class ApiExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<List<FieldErrorResponse>> handleMethodArgumentNotValidException(MethodArgumentNotValidException exception) {
        List<FieldError> fieldErrors = exception.getBindingResult().getFieldErrors();
        List<FieldErrorResponse> fieldErrorResponses = fieldErrors.stream().map(FieldErrorResponse::new).toList();
        return ResponseEntity.badRequest().body(fieldErrorResponses);
    }

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<FieldErrorResponse> handleEntityNotFoundException(EntityNotFoundException exception) {
        return ResponseEntity.badRequest().body(new FieldErrorResponse("msg", exception.getMessage()));
    }

    private record FieldErrorResponse(String field, String errorMessage) {
        public FieldErrorResponse(FieldError fieldError) {
            this(fieldError.getField(), fieldError.getDefaultMessage());
        }
    }
}
