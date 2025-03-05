package com.trip.happytravel.template;

import com.trip.happytravel.common.entity.TemplateEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TemplateService {

    private final TemplateRepository templateRepository;

    public TemplateEntity createTemplate(TemplateDto requsetDto) {

        TemplateEntity templateEntity = TemplateEntity.builder()
                .templateSq(requsetDto.getTemplateSq())
                .mcategory(requsetDto.getMcategory())
                .scategory(requsetDto.getScategory())
                .termsNm(requsetDto.getTermsNm())
                .termsContent(requsetDto.getTermsContent())
                .reqUser(requsetDto.getReqUser())
                .termsRegDtm(requsetDto.getTermsRegDtm())
                .termsUpd(requsetDto.getTermsUpd())
                .termsUpdUser(requsetDto.getTermsUpdUser())
                .useFl(requsetDto.getUseFl())
                .build();

        templateEntity = templateRepository.save(templateEntity);

        return templateEntity;

    }
}
