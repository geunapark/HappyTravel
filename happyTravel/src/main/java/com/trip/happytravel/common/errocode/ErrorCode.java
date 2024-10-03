package com.trip.happytravel.common.errocode;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorCode {

    //0000
    SUCCESS(200 , "0000" , "성공"),

    //100X : 회원가입 관련 에러,
    //아이디 에러코드 1001- 1010
    ID_CANNOT_BE_EMPTY(400, "1001" , "아이디는 공백일 수 없습니다."),
    ID_VALIDATION_FAILED_LENGTH(400, "1002", "아이디는 7글자 이상 15글자 이내로 작성해야 합니다."),
    ID_VALIDATION_FAILED_FORMAT(400, "1003", "아이디 조건이 맞지 않습니다."),
    ID_ALREADY_EXISTS(409 , "1004" , "이미 존재하는 아이디입니다." ),
    USER_BLOCKED(403 , "1005" , "차단 된 사용자입니다"),

    //비밀번호 에러코드 1011 - 1020
    PASSWORD_CANNOT_BE_EMPTY(400 , "1011" , "비밀번호는 공백일 수 없습니다."),
    PASSWORD_VALIDATION_FAILED_LENGTH(400, "1012", "비밀번호는 8글자 이상 20글자 이내로 작성해야 합니다."),
    PASSWORD_VALIDATION_FAILED_FORMAT(400, "1013", "비밀번호 조건이 맞지 않습니다."),
    PASSWORD_MUSMATCH(400,"1014" , "비밀번호가 일치하지 않습니다"),
    PASSWORD_MISMATCH(400 , "1015" , "비밀번호가 일치하지 않습니다."),
    TOO_MANY_FAILED_ATTEMPTS(403 , "1016" , "비밀번호 5회이상 틀리셨습니다."),

    //이메일 에러코드 1021 - 1030
    EMAIL_CANNOT_BE_EMPTY(400 , "1021" , "이메일은 공백일 수 없습니다"),
    INVALID_EMAIL_FORMAT(400 , "1022" , "이메일 조건이 맞지 않습니다."),
    EMAIL_ALREADY_EXISTS(409 , "1023" , "이미 존재하는 이메일입니다."),

    //전화번호 에러코드 1031 - 1040
    PHONE_NUMBER_CANNOT_BE_EMPTY(400 , "1031" , "전화번호는 공백일 수 없습니다."),
    INVALID_PHONE_NUMBER_FORMAT(400 , "1032" , "전화번호 조건이 맞지 않습니다."),
    PHONE_NUMBER_ALREADY_EXISTS(409 , "1033" , "이미존재하는 전화번호입니다."),

    //닉네임 에러코드 1041 - 1050;
    NICKNAME_NUMBER_CANNOT_BE_EMPTY(400 , "1041" , "닉네임은 공백일 수 없습니다."),
    INVALID_NICKNAME_FORMAT(400 , "1042" , "닉네임 조건이 맞지 않습니다"),
    NICKNAME_NOT_AVAILABLE(409 , "1043" , "사용할 수 없는 닉네임입니다.");

    private int status;
    private final String errorCode;    // 코드 필드 추가
    private final String message; // 메시지 필드 추가
}
