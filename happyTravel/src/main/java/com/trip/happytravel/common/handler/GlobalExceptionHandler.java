package com.trip.happytravel.common.handler;

import com.trip.happytravel.common.errorcode.ErrorCode;
import com.trip.happytravel.common.exception.CommonException;
import com.trip.happytravel.common.response.CommonResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;
import java.util.stream.Collectors;


@RestControllerAdvice
public class GlobalExceptionHandler {

    //회원 유효성 검사 예외 핸들러
    //MethodArgumentNotValidException 예외가 발생했을 때 이 메서드를 호출하도록 Spring에게 지시하는 것
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<CommonResponse> handleValidationExceptions(MethodArgumentNotValidException ex) {
        List<String> errorMessages = ex.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(error -> error.getDefaultMessage()) // 에러 메시지(에러 코드)를 가져옴
                .collect(Collectors.toList());

        // 가장 첫 번째 에러 코드를 기준으로 반환
        String errorCodeMessage = errorMessages.get(0);
        ErrorCode errorCode = ErrorCode.valueOf(errorCodeMessage); // 에러 코드에 맞는 ErrorCode enum 반환

        CommonResponse response = new CommonResponse(errorCode);
        return new ResponseEntity<>(response, HttpStatus.valueOf(errorCode.getStatus()));
    }



}
