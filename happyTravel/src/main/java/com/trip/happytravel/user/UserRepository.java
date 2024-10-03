package com.trip.happytravel.user;

import com.trip.happytravel.common.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, String> {
    UserEntity findUserByUserId(String userId);
    // 기본 CRUD 메서드가 자동으로 제공됨
}
