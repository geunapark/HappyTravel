package com.trip.happyTravel.Common.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "partnaerTb")
@Getter @Setter
public class PartnerColumEntity {

    @Id
    private String partnerId;

    private String partnerPwd;

    private String partnerEmail;

    private String businessLicenseNumber;

}
