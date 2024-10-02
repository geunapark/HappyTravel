package com.trip.happytravel.user;

import com.trip.happytravel.Common.entity.UserEntity;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public UserEntity cerateUser(@Valid UserDto createUserEntity) {
       createUserEntity.getUserId();
       createUserEntity.getUserPwd();
       createUserEntity.getUserEmail();

        return userRepository.save(createUserEntity); // 사용자 정보를 데이터베이스에 저장
    }
}
