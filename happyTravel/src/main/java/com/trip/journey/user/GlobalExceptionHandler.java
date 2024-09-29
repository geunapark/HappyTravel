package com.trip.journey.user;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice // 전역 예외 처리기
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class) // 유효성 검사 실패 처리
    public ResponseEntity<Map<String, String>> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();

        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage); // 오류 필드와 메시지를 저장
        });

        return ResponseEntity.badRequest().body(errors); // 400 Bad Request와 함께 오류 메시지 반환
    }
}
