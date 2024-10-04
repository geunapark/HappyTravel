package com.trip.happytravel.common.handler;

import com.trip.happytravel.common.errocode.ErrorCode;
import com.trip.happytravel.common.exception.CommonException;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;


@RestControllerAdvice
public class GlobalExceptionHandler {

    //회원 유효성 검사 예외 핸들러
    //MethodArgumentNotValidException 예외가 발생했을 때 이 메서드를 호출하도록 Spring에게 지시하는 것
    public ResponseEntity<CommonException> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
        Map<String, Object> errors = new HashMap<>();

        for (FieldError fieldError : ex.getBindingResult().getFieldErrors()) {
            String errorCodeStr = fieldError.getDefaultMessage();

            // ErrorCode에서 에러 코드가 존재하는지 확인
            ErrorCode errorCode;
            try {
                errorCode = ErrorCode.valueOf(errorCodeStr);
            } catch (IllegalArgumentException e) {
                // 기본 에러 코드 설정
                errorCode = ErrorCode.ID_CANNOT_BE_EMPTY; // 기본값 설정
            }

            Map<String, String> userError = new HashMap<>();
            userError.put("errorCode", errorCode.getErrorCode());
            userError.put("message", errorCode.getMessage());
            userError.put("field", fieldError.getField());

            errors.put(fieldError.getField(), userError);
        }

        return ResponseEntity.badRequest().body(new CommonException(ErrorCode.ID_CANNOT_BE_EMPTY)); // 기본값 사용
    }





}
