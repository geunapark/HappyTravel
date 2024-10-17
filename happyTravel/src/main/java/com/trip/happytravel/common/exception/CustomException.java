package com.trip.happytravel.common.exception;

import com.trip.happytravel.common.errorcode.CustomErrorCode;
import lombok.Getter;

@Getter
public class CustomException extends RuntimeException {

   private final CustomErrorCode customErrorCode;

   public CustomException(CustomErrorCode customErrorCode){
       super(customErrorCode.getMessage());
       this.customErrorCode = customErrorCode;
   }//CustomException

}
