package com.trip.happytravel.common.handler;

import com.trip.happytravel.common.exception.CustomException;
import com.trip.happytravel.common.response.CustomErrorResponse;
import com.trip.happytravel.common.errorcode.CustomErrorCode;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    //유저 회원가입 dto 유효성 검사 처리
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

    @ExceptionHandler(CustomException.class)
    public ResponseEntity<CustomErrorResponse> handleCustomException(CustomException ex) {
        CustomErrorCode errorCode = ex.getCustomErrorCode(); // 발생한 에러 코드 가져오기

        // CustomErrorResponse 객체 생성
        CustomErrorResponse<Object> response = new CustomErrorResponse<>(errorCode);

        // 에러 응답 반환
        return CustomErrorResponse.createResponseEntity(response);
    }
}
