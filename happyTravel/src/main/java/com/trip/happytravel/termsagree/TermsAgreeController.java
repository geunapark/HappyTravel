package com.trip.happytravel.termsagree;

import com.trip.happytravel.common.entity.TermsAgreeEntity;
import com.trip.happytravel.common.errorcode.CustomErrorCode;
import com.trip.happytravel.common.exception.CustomException;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class TermsAgreeController {

    private final TermsAgreeService termsAgreeService;
    private static final Logger log = LoggerFactory.getLogger(TermsAgreeController.class);

    //필수약관 만들기
    public ResponseEntity<CustomException> createTermsAgree(@Valid @RequestBody TermsAgreeDto requserDto) throws CustomException{

        String reqId = MDC.get("reqId");
        log.info("createTermsAgree requset : {}" , reqId);

        TermsAgreeEntity termsAgreeEntity = termsAgreeService.createTermsAgree(requserDto);
        
        //에러 메세지
        CustomException response =  new CustomException(CustomErrorCode.SUCCESS);

        return ResponseEntity.ok(response);


    }
}
