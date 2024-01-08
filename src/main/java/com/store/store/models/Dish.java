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
public class Dish {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Dish_Id")
    private int dishId;

    @Column(name = "Dish_Name")
    private String dishName;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "Dish_Ingredient", joinColumns = @JoinColumn(name = "Dish_Id"), inverseJoinColumns = @JoinColumn(name = "Ingredient_Id"))
    private List<Ingredient> ingredients;

    @ManyToMany(mappedBy = "dishes")
    private List<Order> orders;

    public Dish() {
    }

    public Dish(String dishName) {
        this.dishName = dishName;
    }

    public int getDishId() {
        return dishId;
    }

    public void setDishId(int dishId) {
        this.dishId = dishId;
    }

    public String getDishName() {
        return dishName;
    }

    public void setDishName(String dishName) {
        this.dishName = dishName;
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

}
