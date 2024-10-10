package com.trip.happytravel.user;

import com.trip.happytravel.common.entity.UserEntity;
import com.trip.happytravel.common.errorcode.ErrorCode;
import com.trip.happytravel.common.exception.CommonException;
import com.trip.happytravel.common.response.CommonResponse;
import io.swagger.v3.oas.annotations.Operation;           // Swagger 설명을 추가하기 위한 어노테이션
import io.swagger.v3.oas.annotations.responses.ApiResponse;  // 응답 코드 설명을 위한 어노테이션
import io.swagger.v3.oas.annotations.responses.ApiResponses; // 여러 응답 코드에 대한 설명 추가
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
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

//    // 사용자 생성 API
//    @Operation(summary = "Create User", description = "Creates a new user in the system.") // API 요약 및 설명 추가
//    @ApiResponses({
//            @ApiResponse(responseCode = "200", description = "User successfully created"),
//            @ApiResponse(responseCode = "400", description = "Invalid input data"),
//            @ApiResponse(responseCode = "500", description = "Internal server error")
//    })
    @PostMapping("/api/users/createUser")
    public ResponseEntity<CommonException> createUser(@Valid @RequestBody UserDto requestDto) throws CommonException {
        UserEntity userEntity = userService.createUser(requestDto);
        // 성공적인 응답
        log.error("에러다 에러 ㅋㅋㅋ");
        CommonException response = new CommonException(ErrorCode.SUCCESS);
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
//    public ResponseEntity<CommonResponse<UserEntity>> login(@RequestBody UserDto requestDto) {
//        UserEntity user = userService.login(requestDto.getUserId(), requestDto.getUserEmail());
//        return ResponseEntity.ok(new CommonResponse<>(ErrorCode.SUCCESS, user));
//    }

    //log테스트 진행중 결과는 성공적으로 나옴
    @GetMapping("/")
    public String index(){

        log.trace("TRACE");
        log.debug("DEBUG");
        log.info("INFO");
        log.warn("WARN");
        log.error("ERRor");

        return "index";
    }
}
