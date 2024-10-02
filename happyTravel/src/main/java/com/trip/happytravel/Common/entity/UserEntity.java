package com.trip.happytravel.Common.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "USER_TB")
@Getter @Setter
public class UserEntity {

    @Id
    private String userId;

    @Column
    private String userPwd;

    @Column
    private String userEmail;

    @Column
    private String sociaEmail;

    @Column
    private String lastLoginDt;

    @Column
    private String pwdUpdDt;

    @Column
    private String phoneNo;

    @Column
    private String redUser;

    @Column
    private String regDtm;

    @Column
    private String updtUser;

    @Column
    private String updtDtm;
}
