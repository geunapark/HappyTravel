package com.trip.happytravel.template;

import com.trip.happytravel.common.entity.TemplateEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TemplateRepository extends JpaRepository<TemplateEntity, Long> {
}
