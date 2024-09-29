package com.trip.journey.user;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity // JPA가 이 클래스를 엔티티로 인식하게 함
@Table(name = "USER_TB") // 데이터베이스의 USER_TB 테이블과 매핑
public class UserEntity {

    @Id
    @Column(name = "USERID") // USERID 컬럼으로 매핑
    private String userId;

    @Column(name = "USERPWD") // USERPWD 컬럼으로 매핑
    private String userPwd;

    @Column(name = "USEREMAIL") // USEREMAIL 컬럼으로 매핑
    private String userEmail;

    // Getters and Setters
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserPwd() {
        return userPwd;
    }

    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }
}
