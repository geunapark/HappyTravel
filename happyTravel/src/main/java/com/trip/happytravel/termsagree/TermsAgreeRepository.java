package com.trip.happytravel.termsagree;

import com.trip.happytravel.common.entity.TermsAgreeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

// TermsAgreeEntity용 JpaRepository
public interface TermsAgreeRepository extends JpaRepository<TermsAgreeEntity, Long> {
}