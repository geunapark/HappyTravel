package com.trip.happytravel.common.entity.Pk;

import com.trip.happytravel.common.entity.TemplateEntity;
import com.trip.happytravel.common.entity.TermsAgreeEntity;
import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Embeddable
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class TemplatePk implements Serializable {

    private Long templateSq;

    private String userType;

    private String userId;
}
