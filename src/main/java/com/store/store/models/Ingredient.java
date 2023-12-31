package com.store.store.models;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "Ingredient_Table")
public class Ingredient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Ingredient_Id")
    private int id;

    @Column(name = "Ingredient_Name")
    private String name;

    @Enumerated(EnumType.ORDINAL)
    @Column(name = "Ingredient_Type")
    private IngredientType ingredientType;

    @ManyToMany(mappedBy = "ingredients")
    private List<Dish> dishes;

    public Ingredient(String name, IngredientType ingredientType) {
        this.name = name;
        this.ingredientType = ingredientType;
    }

    public Ingredient() {

    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public IngredientType getIngredientType() {
        return ingredientType;
    }

    public void setIngredientType(IngredientType ingredientType) {
        this.ingredientType = ingredientType;
    }

    public List<Dish> getDishes() {
        return dishes;
    }

    public void setDishes(List<Dish> dishes) {
        this.dishes = dishes;
    }
}
