package com.trip.happytravel.common.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.trip.happytravel.common.errorcode.CustomErrorCode;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@Getter
@Builder
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@JsonInclude(JsonInclude.Include.NON_NULL)
@NoArgsConstructor(access = AccessLevel.PROTECTED) // 기본 생성자 필요
public class CustomErrorResponse<T>  {

    //포스트맨에서 결과 나오는 타입 설정
    private HttpStatus status;
    private String code;
    private String message;
    private T data;


    //아직 T data를 사용안하기 때문에 주석처리
//    public CustomErrorResponse(CustomErrorCode errorCode , T data){
//        this.status = errorCode.getStatus();
//        this.code = errorCode.getErrorCode();
//        this.message = errorCode.getMessage();
//        this.data = data;
//    }

    public static ResponseEntity<CustomErrorResponse> createResponseEntity(CustomErrorResponse customResp){
        return ResponseEntity.status(customResp.getStatus()).body(customResp);
    }

    // CustomErrorCode를 사용한 생성자
    public CustomErrorResponse(CustomErrorCode errorCode) {
        this.status = errorCode.getStatus();
        this.code = errorCode.getErrorCode();
        this.message = errorCode.getMessage();
    }



}
