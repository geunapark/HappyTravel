package com.trip.happytravel.Common.handler;

import com.trip.happytravel.Common.enception.CommonResponse;
import com.trip.happytravel.Common.errocode.ErrorCode;
import com.trip.happytravel.user.UserController;
import jdk.jshell.spi.ExecutionControl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class CustomExceptionHandler {

    //일반적인 예외처리 코드
    @ExceptionHandler(ExecutionControl.UserException.class)
    public ResponseEntity<CommonResponse> handleException(Exception ex) {
        log.error("handleExceptiom" , ex);
        CommonResponse response = new CommonResponse(ErrorCode.DUPLICATED_ID);
        return new ResponseEntity<>(response , HttpStatus.CONFLICT);
    }

    // 중복된 ID 처리
    @ExceptionHandler(ExecutionControl.UserException.class) // DuplicateIdException은 사용자 정의 예외
    public ResponseEntity<CommonResponse> handleDuplicateIdException(UserController ex) {
        log.error("Duplicate ID Error", ex);
        CommonResponse response = new CommonResponse(ErrorCode.DUPLICATED_ID);
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

}
