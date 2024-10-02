package com.trip.happytravel.user;

import com.trip.happytravel.Common.entity.UserEntity;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequiredArgsConstructor
@Validated // 유효성 검사를 활성화
public class UserController {

    private final UserService userService;

    @PostMapping("/api/users/createUser") // POST 요청을 처리
    public ResponseEntity<UserEntity> cerateUser(@Valid @RequestBody UserDto requestDto) {
        return ResponseEntity.ok(userService.cerateUser(requestDto)); // 저장된 사용자 정보를 응답으로 반환
    }
}
