package com.store.store.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.store.store.models.Dish;
import com.store.store.models.Ingredient;
import com.store.store.repos.DishRepository;

@Service
public class DishService {

    @Autowired
    private DishRepository dishRepository;

    public boolean ifExist(int id) {
        return dishRepository.existsById(id);
    }

    public Iterable<Dish> getAllDishes() {
        return dishRepository.findAll();
    }

    public List<Dish> getDishById(int id) {
        Optional<Dish> optionalDish = dishRepository.findById(id);
        List<Dish> dish = new ArrayList<>();
        if (optionalDish.isPresent()) {
            optionalDish.ifPresent(dish::add);
        }
        return dish;
    }

    public List<Ingredient> getRelatedIngredients(int id) {
        Optional<Dish> optionalDish = dishRepository.findById(id);
        Dish dish;
        List<Ingredient> ingredients = new ArrayList<>();
        if (optionalDish.isPresent()) {
            dish = optionalDish.get();
            ingredients = dish.getIngredients();
        }
        return ingredients;
    }
}
