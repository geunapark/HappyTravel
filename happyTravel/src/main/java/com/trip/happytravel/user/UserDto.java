package com.trip.happytravel.user;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class UserDto {


    @NotBlank(message = "1001")
    @Size(min = 7 , max = 15 , message = "1002")
    @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?:(?!.*([a-z])\\1{2})[a-z0-9@!*$#^]*)+$" , message = "1003")
    private String userId;

    @NotBlank(message = "1011")
    @Size(min = 7 , max = 20 , message = "1012")
    @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-zA-Z])(?:(?!.*([a-z])\\1{2})[a-zA-Z0-9@!*$#^]*)+$" , message = "1013")
    private String userPwd;

    @NotBlank(message = "1021")
    private String userEmail;

    private String sociaEmail;

    @NotBlank(message = "1031")
    @Pattern(regexp = "^[0-9]+$" , message = "1032")
    private String userPhoneNumber;

    @NotBlank(message = "1041")
    @Pattern(regexp = "^[a-zA-Z0-9]+$",message = "1042")
    private String userNickName;
}