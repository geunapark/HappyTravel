package com.trip.happyTravel.user;

import com.trip.happyTravel.Common.entity.UserColumnEntity;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
@Validated // 유효성 검사를 활성화
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/api/users/register") // POST 요청을 처리
    public ResponseEntity<UserColumnEntity> cerateUser(@Valid @RequestBody UserDto request) {
        UserColumnEntity userEntity = new UserColumnEntity();
        userEntity.setUserId(request.getUserId());
        userEntity.setUserPwd(request.getUserPwd());
        userEntity.setUserEmail(request.getUserEmail());

        UserColumnEntity response = userService.cerateUser(userEntity);
        return ResponseEntity.ok(response); // 저장된 사용자 정보를 응답으로 반환
    }
}
