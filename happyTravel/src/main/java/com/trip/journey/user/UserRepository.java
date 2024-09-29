package com.trip.journey.user;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, String> {
    // 기본 CRUD 메서드가 자동으로 제공됨
}
