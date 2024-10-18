package com.trip.happytravel.template;

import com.trip.happytravel.common.entity.TemplateEntity;
import com.trip.happytravel.common.errorcode.CustomErrorCode;
import com.trip.happytravel.common.exception.CustomException;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class TemplateController {

    private static final Logger log = LoggerFactory.getLogger(TemplateController.class);
    private final TemplateService templateService;

    @PostMapping("/api/template/create")
    public ResponseEntity<CustomException> createTemplate(@RequestBody TemplateDto requsetDto){

        String reqId = MDC.get("reqId");
        log.info("createTemplate request : {} " , reqId );

        TemplateEntity templateEntity = templateService.createTemplate(requsetDto);

        CustomException response = new CustomException(CustomErrorCode.SUCCESS);
        return ResponseEntity.ok(response);
    }

}
