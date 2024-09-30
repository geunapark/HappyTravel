package com.trip.happyTravel.user;

import com.trip.happyTravel.Common.entity.UserColumnEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserColumnEntity, String> {
    // 기본 CRUD 메서드가 자동으로 제공됨
}
