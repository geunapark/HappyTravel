package com.trip.happytravel.common.handler;

import com.trip.happytravel.common.errorcode.ErrorCode;
import com.trip.happytravel.common.exception.CommonException;
import com.trip.happytravel.common.response.CommonResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;
import java.util.stream.Collectors;


@RestControllerAdvice
public class GlobalExceptionHandler {

    //회원 dto유효성 검사 예외 핸들러
    //MethodArgumentNotValidException 예외가 발생했을 때 이 메서드를 호출하도록 Spring에게 지시하는 것
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<CommonResponse<Object>> handleValidationException(MethodArgumentNotValidException ex) {
        // 유효성 검사 실패 시 처리 로직
        String errorMessage = ex.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(error -> error.getDefaultMessage())
                .findFirst()
                .orElse("유효성 검사 실패");

        // 에러 코드에 맞는 CommonResponse 생성
        CommonResponse<Object> response = new CommonResponse<>(ErrorCode.ID_VALIDATION_FAILED_FORMAT); // 원하는 에러코드로 변경 가능
        response.setMessage(errorMessage); // 유효성 검사 실패 메시지 설정

        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

}
