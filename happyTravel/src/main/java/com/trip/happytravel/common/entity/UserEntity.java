package com.trip.happytravel.common.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

@Entity
@Table(name = "USER_TB")
@Getter @Setter
@NoArgsConstructor
public class UserEntity {

    @Id
    private String userId;

    @Column(nullable = false)
    private String userPwd;

    @Column(nullable = false)
    private String userEmail;

    @Column
    private String sociaEmail;

    @Column
    private String lastLoginDt;

    @Column
    private String pwdUpdDt;

    @Column(nullable = false)
    private String phoneNo;

    @Column
    private String redUser;

    @Column
    @CreatedDate
    private String regDtm;

    @Column
    private String updtUser;

    @Column
    @LastModifiedDate
    private String updtDtm;

    @Column(nullable = false)
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
