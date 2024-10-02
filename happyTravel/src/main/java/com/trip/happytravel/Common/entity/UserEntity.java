package com.trip.happytravel.Common.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "USER_TB")
@Getter @Setter
@NoArgsConstructor
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

    @Column
    private String userNickName;

    // 칼럼 추가해야 함
    @Builder
    public UserEntity(String userId, String userPwd, String userEmail, String userNickName, String phoneNo) {
        this.userId = userId;
        this.userPwd = userPwd;
        this.userEmail = userEmail;
        this.userNickName = userNickName;
        this.phoneNo = phoneNo;
    }
}
