package com.trip.happytravel.common.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "TERMS_TB")
@Getter @Setter
@NoArgsConstructor
public class TemplateEntity {

    @Id
    private Long templateSq;

    @Column
    private String mcategory;

    @Column
    private String scategory;

    @Column
    private String termsNm;

    @Column
    private String termsContent;

    @Column
    private String reqUser;

    @Column
    private String termsRegDtm;

    @Column
    private String termsUpd;

    @Column
    private String termsUpdUser;

    @Column
    private String useFl;

    // 칼럼 추가해야 함
    @Builder
    public TemplateEntity(long templateSq, String mcategory, String scategory,
                          String termsNm, String termsContent , String reqUser,
                          String termsRegDtm, String termsUpd, String termsUpdUser, String useFl) {

       this.templateSq = templateSq;
       this.mcategory = mcategory;
       this.scategory = scategory;
       this.termsNm = termsNm;
       this.termsContent = termsContent;
       this.reqUser = reqUser;
       this.termsRegDtm = termsRegDtm;
       this.termsUpd = termsUpd;
       this.termsUpdUser = termsUpdUser;
       this.useFl = useFl;

    }

}
