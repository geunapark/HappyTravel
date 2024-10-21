package com.trip.happytravel.common.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "TERMS_AGREE_TH")
@Getter @Setter
@NoArgsConstructor
public class TermsAgreeThEntity {

    private String userType;

    private String userId;

    private String templateSq;

    private String agreeFl;

    private String agreeDt;

    private String regUser;

    private String regDtm;
    
}
