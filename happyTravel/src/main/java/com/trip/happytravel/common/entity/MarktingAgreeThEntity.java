package com.trip.happytravel.common.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "MARKTING_AGREE_TH")
@Getter @Setter
@NoArgsConstructor
public class MarktingAgreeThEntity {

    private Long agreeSq;

    private String templateSq;

    private String userType;

    private String userId;

    private String agreeFl;

    private String agreeDt;

    private String dagreeDt;

    private String regUser;

    private String regDtm;

    private String updtUser;

    private String updtDtm;
}
