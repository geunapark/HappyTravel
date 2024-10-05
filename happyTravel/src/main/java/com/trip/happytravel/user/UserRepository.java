package com.trip.happytravel.user;

import com.trip.happytravel.common.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

// 기본 CRUD 메서드가 자동으로 제공됨
public interface UserRepository extends JpaRepository<UserEntity, String> {

    //사용자 회원가입 기능구현
    UserEntity findUserByUserId(String userId);

    //사용자 로그인 기능구현
    Optional<UserEntity> findById(String userId);

}
