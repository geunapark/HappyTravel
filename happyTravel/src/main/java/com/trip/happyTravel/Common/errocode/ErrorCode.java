package com.trip.happyTravel.Common.errocode;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum ErrorCode {

    //0000
    UNKNOW(404 , "0000" , "알 수 없는 에러가 발생했습니다." ),

    //100X : 사용자 관련 에러
    USER_NOT_FOUND(500, "1001" , "사용자를 찾을 수 없습니다"),
    DUPLICATED_ID(409,"1002" , "이미 존재하는 아이디입니다."),
    PASSWORD_MUSMATCH(500,"1003" , "비밀번호가 일치하지 않습니다"),
    USER_BLACK_LIST(500, "1004" , "차단 된 사용자입니다");

    private int status;
    private final String errorCode;    // 코드 필드 추가
    private final String message; // 메시지 필드 추가
}
