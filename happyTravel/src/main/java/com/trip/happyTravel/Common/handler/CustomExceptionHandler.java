package com.trip.happyTravel.Common.handler;

import com.trip.happyTravel.Common.enception.ErrorResponse;
import com.trip.happyTravel.Common.errocode.ErrorCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class CustomExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleException(Exception ex) {
        log.error("handleExceptiom" , ex);
        ErrorResponse response = new ErrorResponse(ErrorCode.DUPLICATED_ID);
        return new ResponseEntity<>(response , HttpStatus.CONFLICT);
    }
}
