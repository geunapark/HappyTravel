package com.trip.happytravel.user;

import com.trip.happytravel.common.entity.UserEntity;
import com.trip.happytravel.common.errorcode.CustomErrorCode;
import com.trip.happytravel.common.exception.CustomException;
import com.trip.happytravel.common.response.CustomErrorResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    @Transactional
    public UserEntity createUser(UserDto requestDto) throws CustomException {
        // ID 중복검사
        UserEntity findUserById = userRepository.findUserByUserId(requestDto.getUserId());
        if (findUserById != null) {
            throw new CustomException(CustomErrorCode.ID_ALREADY_EXISTS); // 에러코드 1003
        }
        // Insert하는  userEntity 생성 후 값 넣어주기
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

    //사용자 로그인 기능구현 서비스
    public UserEntity login(String userId , String userEmail){
        Optional<UserEntity> userEntity = userRepository.findById(userId);

        if (userEntity.isPresent()){
            UserEntity user = userEntity.get();
            if (user.getUserEmail().equals(userEmail)){
                return user;
            }else {
                throw new CustomException(CustomErrorCode.PASSWORD_MUSMATCH);
            }
        }else {
            throw new CustomException(CustomErrorCode.USER_BLOCKED);
        }
    }

}
