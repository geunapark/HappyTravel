package com.trip.happytravel.common.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.trip.happytravel.common.errocode.ErrorCode;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.validation.FieldError;
import org.springframework.web.ErrorResponse;

import java.util.ArrayList;
import java.util.List;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter @Setter
public class CommonResponse<T> {

    private int status;
    private String code;
    private String message;
    private T data;

    public CommonResponse(ErrorCode errorCode , T data){
        this.status = errorCode.getStatus();
        this.code = errorCode.getErrorCode();
        this.message = errorCode.getMessage();
        this.data = data;
    }

    public CommonResponse(ErrorCode errorCode){
        this.status = errorCode.getStatus();
        this.code = errorCode.getErrorCode();
        this.message = errorCode.getMessage();
    }



}
