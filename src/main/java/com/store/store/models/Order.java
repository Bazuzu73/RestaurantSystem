package com.store.store.models;

import jakarta.persistence.Entity;

@Entity
public class Order {
    private String deliveryName;
    private String deliveryStreet;
    private String deliveryCity;
    private DeliveryProvince DeliveryProvince;
    private String deliveryPostCode;
    private String ccNumber;
    private String ccExpiration;
    private String ccCVV;
}
