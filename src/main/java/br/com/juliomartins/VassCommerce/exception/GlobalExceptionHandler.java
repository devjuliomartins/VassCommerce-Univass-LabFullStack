package br.com.juliomartins.VassCommerce.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, Object>> handleValidationExceptions(MethodArgumentNotValidException ex) {
        List<Map<String, String>> fields = new ArrayList<>();

        for (FieldError error : ex.getBindingResult().getFieldErrors()) {
            fields.add(Map.of(
                    "name", error.getField(),
                    "message", error.getDefaultMessage()
            ));
        }

        Map<String, Object> responseBody = Map.of(
                "error", "Invalid input",
                "fields", fields
        );

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseBody);
    }
}
