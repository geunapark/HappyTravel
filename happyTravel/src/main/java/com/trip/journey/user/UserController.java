package com.trip.journey.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/users") // 기본 URL 설정
@Validated // 유효성 검사를 활성화
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register") // POST 요청을 처리
    public ResponseEntity<UserEntity> registerUser(@RequestBody UserDto userDto) {
        UserEntity userEntity = new UserEntity();
        userEntity.setUserId(userDto.getUserId());
        userEntity.setUserPwd(userDto.getUserPwd());
        userEntity.setUserEmail(userDto.getUserEmail());

        UserEntity savedUser = userService.registerUser(userEntity);
        return ResponseEntity.ok(savedUser); // 저장된 사용자 정보를 응답으로 반환
    }
}
