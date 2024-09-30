package com.trip.happyTravel.user;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class UserDto {


    @NotBlank(message = "ID는 필수입력입니다.")
    @Size(min = 8 , max = 20 , message = "아이디는 8 -20 자 이내로 입력해주세요.")
    private String userId;

    @NotBlank
    private String userPwd;

    @NotBlank
    private String userEmail;

    @NotBlank
    private String sociaEmail;

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

    public String setSociaEmail(){ return sociaEmail; }

    public void getSociaEmail(String sociaEmail){ this.sociaEmail = sociaEmail; }
}