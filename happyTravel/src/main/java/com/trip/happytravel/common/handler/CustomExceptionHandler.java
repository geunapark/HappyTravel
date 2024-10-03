package com.trip.happytravel.Common.handler;

import ch.qos.logback.core.spi.ErrorCodes;
import com.trip.happytravel.Common.errocode.ErrorCode;
import com.trip.happytravel.Common.exception.CommonResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.DuplicateFormatFlagsException;
import java.util.HashMap;
import java.util.Map;


@RestControllerAdvice
public class CustomExceptionHandler {

    //MethodArgumentNotValidException 예외가 발생했을 때 이 메서드를 호출하도록 Spring에게 지시하는 것
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String,String>>handleValidationException(MethodArgumentNotValidException ex){
        Map<String,String> errorCode = new HashMap<>();

        // 각 필드의 에러 메시지를 추출
        for (FieldError error : ex.getBindingResult().getFieldErrors()) {
            errorCode.put(error.getField(), error.getDefaultMessage());
        }

        return ResponseEntity.badRequest().body(errorCode);
    }


    @ExceptionHandler(CommonResponse.class)
    public ResponseEntity<Map<String, String>> handleCommonException(CommonResponse ex) {
        Map<String, String> errorResponse = new HashMap<>();

        // 에러 코드와 메시지를 CommonException에서 가져오기
        errorResponse.put("ErrorCode", String.valueOf(ex.getStatus()));
        errorResponse.put("message", ex.getMessage());

        return ResponseEntity.status(HttpStatus.CONFLICT).body(errorResponse);
    }



}
