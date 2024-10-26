package com.trip.happytravel.common.entity;

import com.trip.happytravel.common.entity.Pk.TemplatePk;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "TERMS_AGREE_TH")
@Getter @Setter
@NoArgsConstructor
public class TermsAgreeEntity {

    @EmbeddedId
    private TemplatePk termsAgreePk;  // 복합키

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "templateSq", insertable = false, updatable = false)
    private TemplateEntity template;  //TemplateEntity와 연관관계 매핑에서 조인을 통해 두 테이블 연결

    @Column
    private String agreeFl;

    @Column
    private String agreeDt;

    @Column
    private String regUser;

    @Column
    private String regDtm;

    @Builder
    public TermsAgreeEntity(TemplatePk template, String userType, String userId,
                            String agreeFl, String agreeDt, String regUser, String regDtm){
        this.termsAgreePk = new TemplatePk(template.getTemplateSq(), userType, userId);
        this.agreeFl = agreeFl;
        this.agreeDt = agreeDt;
        this.regUser = regUser;
        this.regDtm = regDtm;
    }

}
