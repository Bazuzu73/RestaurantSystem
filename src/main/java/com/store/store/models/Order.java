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
import jakarta.persistence.Table;

@Entity
@Table(name = "Order_Table")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Order_Id")
    private int id;

    @Column(name = "order_Name")
    private String orderName;

    @Column(name = "order_Street")
    private String orderStreet;

    @Column(name = "Delivary_City")
    private String orderCity;

    @Column(name = "order_Province")
    private OrderProvince orderProvince;

    @Column(name = "order_PostalCode")
    private String orderPostCode;

    @Column(name = "Credit_Card_Number")
    private String ccNumber;

    @Column(name = "Credit_Card_Expiration")
    private String ccExpiration;

    @Column(name = "Credit_Card_CVV")
    private String ccCVV;

    @ManyToMany(cascade = { CascadeType.MERGE, CascadeType.PERSIST })
    @JoinTable(name = "Order_Dish", joinColumns = @JoinColumn(name = "Order_Id"), inverseJoinColumns = @JoinColumn(name = "Dish_Id"))
    private List<Dish> dishes;

    public Order() {
    }

    public Order(int id, String orderName, String orderStreet, String orderCity,
            com.store.store.models.OrderProvince orderProvince, String orderPostCode, String ccNumber,
            String ccExpiration, String ccCVV, List<Dish> dishes) {
        this.id = id;
        this.orderName = orderName;
        this.orderStreet = orderStreet;
        this.orderCity = orderCity;
        this.orderProvince = orderProvince;
        this.orderPostCode = orderPostCode;
        this.ccNumber = ccNumber;
        this.ccExpiration = ccExpiration;
        this.ccCVV = ccCVV;
        this.dishes = dishes;
    }

    public int getId() {
        return id;
    }

    public String getorderName() {
        return orderName;
    }

    public void setorderName(String orderName) {
        this.orderName = orderName;
    }

    public String getorderStreet() {
        return orderStreet;
    }

    public void setorderStreet(String orderStreet) {
        this.orderStreet = orderStreet;
    }

    public String getorderCity() {
        return orderCity;
    }

    public void setorderCity(String orderCity) {
        this.orderCity = orderCity;
    }

    public OrderProvince getorderProvince() {
        return orderProvince;
    }

    public void setorderProvince(OrderProvince orderProvince) {
        this.orderProvince = orderProvince;
    }

    public String getorderPostCode() {
        return orderPostCode;
    }

    public void setorderPostCode(String orderPostCode) {
        this.orderPostCode = orderPostCode;
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
