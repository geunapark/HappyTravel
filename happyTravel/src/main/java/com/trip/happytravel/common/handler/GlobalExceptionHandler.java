package com.trip.happytravel.common.handler;

import ch.qos.logback.core.spi.ErrorCodes;
import com.trip.happytravel.common.errocode.ErrorCode;
import com.trip.happytravel.common.exception.CommonException;
import com.trip.happytravel.common.response.CommonResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice
public class GlobalExceptionHandler {

    //회원 유효성 검사 예외 핸들러
    //MethodArgumentNotValidException 예외가 발생했을 때 이 메서드를 호출하도록 Spring에게 지시하는 것
    @ExceptionHandler(CommonException.class)
    public ResponseEntity<CommonResponse>handleValidException(CommonException ex){
        CommonResponse response = new CommonResponse(ex.getErrorCode() , ex.getMessage());
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }



}
