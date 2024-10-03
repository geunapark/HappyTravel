package com.trip.happytravel.common.exception;

import com.trip.happytravel.common.errocode.ErrorCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommonResponse extends Throwable {

    private final int status;
    private final String message;
    private final String code;


    public CommonResponse(ErrorCode errorCode) {
        this.status = errorCode.getStatus();
        this.message = errorCode.getMessage();
        this.code = errorCode.getErrorCode();
    }
}
