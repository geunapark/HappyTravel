package com.trip.happytravel.user;

import com.trip.happytravel.Common.entity.UserEntity;
import com.trip.happytravel.Common.errocode.ErrorCode;
import com.trip.happytravel.Common.exception.CommonResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    @Transactional
    public UserEntity createUser(UserDto requestDto) throws CommonResponse {
        // ID 중복검사
        UserEntity findUserById = userRepository.findUserByUserId(requestDto.getUserId());
        if (findUserById != null) {
            throw new CommonResponse(ErrorCode.ID_ALREADY_EXISTS); // 에러코드 1003
        }

        // insert할 userEntity 생성
        UserEntity userEntity = UserEntity.builder()
                .userId(requestDto.getUserId())
                .userPwd(requestDto.getUserPwd())
                .userEmail(requestDto.getUserEmail())
                .phoneNo(requestDto.getPhoneNo())
                .userNickName(requestDto.getUserNickName())
                .build();

        // UserEntity 저장
        userEntity = userRepository.save(userEntity); // 저장된 UserEntity 반환

        return userEntity;
    }

}
