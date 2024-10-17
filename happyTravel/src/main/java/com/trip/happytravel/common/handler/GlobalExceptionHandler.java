package com.trip.happytravel.common.handler;

import com.trip.happytravel.common.response.CustomErrorResponse;
import com.trip.happytravel.common.errorcode.CustomErrorCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = {MethodArgumentNotValidException.class})
    public ResponseEntity<CustomErrorResponse> handleUserSigUpValidationException(MethodArgumentNotValidException ex){
        BindingResult bindingResult = ex.getBindingResult();
        List<FieldError> fieldErrors = bindingResult.getFieldErrors();
        FieldError fieldError = fieldErrors.get(0);
        String errorCode = fieldError.getDefaultMessage();

        CustomErrorCode error = CustomErrorCode.findErrorCode(errorCode);

        CustomErrorResponse customResp = CustomErrorResponse.builder()
                .status(error.getStatus())
                .code(error.getErrorCode())
                .message(error.getMessage())
                .build();

        return CustomErrorResponse.createResponseEntity(customResp);
    }
}
