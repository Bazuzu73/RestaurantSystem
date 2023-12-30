package com.store.store.models;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;

@Entity
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Order_Id")
    private int id;

    @Column(name = "Delivery_Name")
    private String deliveryName;

    @Column(name = "Delivery_Street")
    private String deliveryStreet;

    @Column(name = "Delivary_City")
    private String deliveryCity;

    @Column(name = "Delivery_Province")
    private DeliveryProvince DeliveryProvince;

    @Column(name = "Delivery_PostalCode")
    private String deliveryPostCode;

    @Column(name = "Credit_Card_Number")
    private String ccNumber;

    @Column(name = "Credit_Card_Expiration")
    private String ccExpiration;

    @Column(name = "Credit_Card_CVV")
    private String ccCVV;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "Order_Dish", joinColumns =  @JoinColumn(name = "Order_Id"), inverseJoinColumns = @JoinColumn(name = "Dish_Id"))
    private List<Dish> dishes;

    public Order() {
    }

    public Order(String deliveryName, String deliveryStreet, String deliveryCity,
            DeliveryProvince deliveryProvince, String deliveryPostCode, String ccNumber,
            String ccExpiration, String ccCVV) {
        this.deliveryName = deliveryName;
        this.deliveryStreet = deliveryStreet;
        this.deliveryCity = deliveryCity;
        DeliveryProvince = deliveryProvince;
        this.deliveryPostCode = deliveryPostCode;
        this.ccNumber = ccNumber;
        this.ccExpiration = ccExpiration;
        this.ccCVV = ccCVV;
    }

    public int getId() {
        return id;
    }

    public String getDeliveryName() {
        return deliveryName;
    }

    public void setDeliveryName(String deliveryName) {
        this.deliveryName = deliveryName;
    }

    public String getDeliveryStreet() {
        return deliveryStreet;
    }

    public void setDeliveryStreet(String deliveryStreet) {
        this.deliveryStreet = deliveryStreet;
    }

    public String getDeliveryCity() {
        return deliveryCity;
    }

    public void setDeliveryCity(String deliveryCity) {
        this.deliveryCity = deliveryCity;
    }

    public DeliveryProvince getDeliveryProvince() {
        return DeliveryProvince;
    }

    public void setDeliveryProvince(DeliveryProvince deliveryProvince) {
        DeliveryProvince = deliveryProvince;
    }

    public String getDeliveryPostCode() {
        return deliveryPostCode;
    }

    public void setDeliveryPostCode(String deliveryPostCode) {
        this.deliveryPostCode = deliveryPostCode;
    }

    public String getCcNumber() {
        return ccNumber;
    }

    public void setCcNumber(String ccNumber) {
        this.ccNumber = ccNumber;
    }

    public String getCcExpiration() {
        return ccExpiration;
    }

    public void setCcExpiration(String ccExpiration) {
        this.ccExpiration = ccExpiration;
    }

    public String getCcCVV() {
        return ccCVV;
    }

    public void setCcCVV(String ccCVV) {
        this.ccCVV = ccCVV;
    }

    public List<Dish> getDishes() {
        return dishes;
    }

    public void setDishes(List<Dish> dishes) {
        this.dishes = dishes;
    }

}
