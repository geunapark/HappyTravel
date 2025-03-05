package com.trip.happytravel.termsagree;

import com.trip.happytravel.common.entity.Pk.TemplatePk;
import com.trip.happytravel.common.entity.TemplateEntity;
import com.trip.happytravel.common.entity.TermsAgreeEntity;
import com.trip.happytravel.template.TemplateRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class TermsAgreeService {

    private final TemplateRepository templateRepository;  // 템플릿 조회용
    private final TermsAgreeRepository termsAgreeRepository;  // 약관 동의 저장용

    public TermsAgreeEntity createTermsAgree(TermsAgreeDto requestDto) {


        // 1. 템플릿 조회
        TemplateEntity template = templateRepository.findById(requestDto.getTemplateSq())
                .orElseThrow(() -> new RuntimeException("템플릿을 찾을 수 없습니다."));

        // 2. 약관 동의 엔티티 생성
        TermsAgreeEntity termsAgree = TermsAgreeEntity.builder()
                .termsAgreePk(new TemplatePk(template.getTemplateSq(), requestDto.getUserType(), requestDto.getUserId())) // 복합키 설정
                .template(template) // 템플릿 설정
                .agreeFl(requestDto.getAgreeFl())
                .agreeDt(LocalDate.now()) // LocalDate 타입으로 설정
                .regUser(requestDto.getRegUser())
                .regDtm(LocalDateTime.now()) // LocalDateTime 타입으로 설정
                .build();

        // 3. 저장
        return termsAgreeRepository.save(termsAgree);
    }
}
