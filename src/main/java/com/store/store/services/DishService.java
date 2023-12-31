package com.store.store.services;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.store.store.models.Dish;
import com.store.store.models.Ingredient;
import com.store.store.repos.DishRepository;

@Service
public class DishService implements ServiceInterface<Dish>, RelatedInterface<Ingredient> {

    @Autowired
    private DishRepository dishRepository;

    @Override
    public boolean ifExist(int id) {
        return dishRepository.existsById(id);
    }

    @Override
    public Iterable<Dish> getAll() {
        return dishRepository.findAll();
    }

    @Override
    public List<Dish> getById(int id) {
        return dishRepository.findById(id).map(Collections::singletonList).orElse(Collections.emptyList());
    }

    @Override
    public List<Ingredient> getRelated(int id) {
        Optional<Dish> optionalDish = dishRepository.findById(id);
        return optionalDish.map(Dish::getIngredients).orElse(Collections.emptyList());
    }
}
