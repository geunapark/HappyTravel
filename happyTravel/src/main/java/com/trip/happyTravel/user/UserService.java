package com.trip.happyTravel.user;

import com.trip.happyTravel.Common.entity.UserColumnEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public UserColumnEntity cerateUser(UserColumnEntity createUserEntity) {
        return userRepository.save(createUserEntity); // 사용자 정보를 데이터베이스에 저장
    }
}
