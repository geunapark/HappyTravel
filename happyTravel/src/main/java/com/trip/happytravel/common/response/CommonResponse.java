package com.trip.happytravel.common.response;

import com.trip.happytravel.common.errorcode.ErrorCode;
import lombok.*;
import lombok.experimental.FieldDefaults;

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
