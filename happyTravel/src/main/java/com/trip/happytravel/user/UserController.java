package com.trip.happytravel.user;

import com.trip.happytravel.common.entity.UserEntity;
import com.trip.happytravel.common.errorcode.CustomErrorCode;
import com.trip.happytravel.common.exception.CustomException;
import com.trip.happytravel.common.filter.MDCFilter;
import com.trip.happytravel.common.response.CustomErrorResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.MDC;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Slf4j
@Validated
public class UserController {

    private final UserService userService;
    private final MDCFilter mdcFilter;

//    // 사용자 생성 API
//    @Operation(summary = "Create User", description = "Creates a new user in the system.") // API 요약 및 설명 추가
//    @ApiResponses({
//            @ApiResponse(responseCode = "200", description = "User successfully created"),
//            @ApiResponse(responseCode = "400", description = "Invalid input data"),
//            @ApiResponse(responseCode = "500", description = "Internal server error")
//    })
    @PostMapping("/api/users/createUser")
    public ResponseEntity<CustomException> createUser(@Valid @RequestBody UserDto requestDto) throws CustomException {

        String reqId = MDC.get("reqId");
        log.info("cerateUser request : {}" ,reqId );

        UserEntity userEntity = userService.createUser(requestDto);
        
        //회원가입 성공 메세지 생성
        CustomException response = new CustomException(CustomErrorCode.SUCCESS);

        return ResponseEntity.ok(response);
    }

//    // 사용자 로그인 API
//    @Operation(summary = "User Login", description = "Authenticates a user with userId and userEmail.") // API 요약 및 설명 추가
//    @ApiResponses({
//            @ApiResponse(responseCode = "200", description = "Login successful"),
//            @ApiResponse(responseCode = "401", description = "Unauthorized"),
//            @ApiResponse(responseCode = "404", description = "User not found"),
//            @ApiResponse(responseCode = "500", description = "Internal server error")
//    })
//    @GetMapping("/api/users/login")
//    public ResponseEntity<CustomErrorResponse<UserEntity>> login(@RequestBody UserDto requestDto) {
//        UserEntity user = userService.login(requestDto.getUserId(), requestDto.getUserEmail());
//        return ResponseEntity.ok(new CustomErrorResponse<>(CustomErrorCode.SUCCESS, user));
//    }

    //log테스트 결과는 성공적으로 나옴
    @GetMapping("/")
    public void test(){
        log.info("테스트 시작");
        System.out.println("안녕.test");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        log.info("테스트 끝");

    }
}
