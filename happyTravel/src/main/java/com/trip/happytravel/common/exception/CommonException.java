package com.trip.happytravel.common.exception;

import com.trip.happytravel.common.errorcode.ErrorCode;
import lombok.Getter;

@Getter
public class CommonException extends RuntimeException {

   private final ErrorCode errorCode;

   public CommonException(ErrorCode errorCode){
       this.errorCode = errorCode;
   }

   public ErrorCode getErrorCode(){
       return errorCode;
   }
}
