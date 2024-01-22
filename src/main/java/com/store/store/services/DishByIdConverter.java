package com.store.store.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.store.store.models.Dish;

@Component
public class DishByIdConverter implements Converter<String, Dish>{
    
    private List<Dish> dishes = new ArrayList<>();
    
    @Autowired
    private DishService dishService;

    public DishByIdConverter() {
    }

    public DishByIdConverter(List<Dish> dishes) {
        this.dishes = dishes;
    }

    public List<Dish> getDishes() {
        return dishes;
    }

    public void setDishes(List<Dish> dishes) {
        this.dishes = dishes;
    }

    public DishService getDishService() {
        return dishService;
    }

    public void setDishService(DishService dishService) {
        this.dishService = dishService;
    }

    @Override
    public Dish convert(String id) {
        return dishService.getObject(Integer.parseInt(id));
    }
    
}
