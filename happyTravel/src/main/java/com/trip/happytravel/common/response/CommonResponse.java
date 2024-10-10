package com.trip.happytravel.common.response;

import com.trip.happytravel.common.errorcode.ErrorCode;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter @Setter
public class CommonResponse<T> {

    //포스트맨에서 결과 나오는 타입 설정
    private HttpStatus status;
    private String code;
    private String message;
    private T data;

//    public CommonResponse(ErrorCode errorCode , T data){
//        this.status = errorCode.getStatus();
//        this.code = errorCode.getErrorCode();
//        this.message = errorCode.getMessage();
//        this.data = data;
//    }


    public CommonResponse(ErrorCode errorCode){
        this.status = errorCode.getStatus();
        this.code = errorCode.getErrorCode();
        this.message = errorCode.getMessage();
    }



}
