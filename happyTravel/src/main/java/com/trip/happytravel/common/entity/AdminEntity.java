package com.trip.happytravel.common.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "ADMIN_TB")
@Getter @Setter
@NoArgsConstructor
public class AdminEntity {

    @Id
    private String adminId;

    private String adminPwd;

    private String otpScretKey;

    private String adminPwdUpdDt;

    private String deptCd;

    private String regUser;

    private String regDtm;

    private String updtUser;

    private String updtDtm;
}
