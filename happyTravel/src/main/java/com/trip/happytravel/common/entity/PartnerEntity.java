package com.trip.happytravel.Common.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "PARTNAER_TB")
@Getter @Setter
public class PartnerEntity {

    @Id
    private String partnerId;

    private String partnerPwd;

    private String partnerEmail;

    private String businessLicenseNumber;

}
