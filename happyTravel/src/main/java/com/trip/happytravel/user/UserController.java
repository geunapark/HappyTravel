package com.trip.happytravel.user;

import com.trip.happytravel.common.entity.UserEntity;
import com.trip.happytravel.common.errorcode.ErrorCode;
import com.trip.happytravel.common.exception.CommonException;
import com.trip.happytravel.common.response.CommonResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequiredArgsConstructor
@Validated // 유효성 검사를 활성화
public class UserController {

    private final UserService userService;

    @PostMapping("/api/users/createUser") // POST 요청을 처리
    public ResponseEntity<CommonException> createUser(@Valid @RequestBody UserDto requestDto) throws CommonException {
        UserEntity userEntity = userService.createUser(requestDto); // 사용자 정보를 저장
        // 성공적인 응답 생성
        CommonException response = new CommonException(ErrorCode.SUCCESS); // SUCCESS는 에러 코드에서 0000에 해당

        return ResponseEntity.ok(response);
    }

    @GetMapping("/api/users/login")
    public ResponseEntity<CommonResponse<UserEntity>> login(@RequestBody UserDto requestDto){
        UserEntity user = userService.login(requestDto.getUserId() , requestDto.getUserEmail());
        return  ResponseEntity.ok(new CommonResponse<>(ErrorCode.SUCCESS, user));
    }

}
