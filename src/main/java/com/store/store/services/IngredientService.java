package com.store.store.services;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.store.store.models.Ingredient;
import com.store.store.models.IngredientType;
import com.store.store.repos.IngredientRepository;

@Service
public class IngredientService implements ServiceInterface<Ingredient>{

    @Autowired
    private IngredientRepository ingredientRepository;

    @Override
    public boolean ifExist(int id) {
        return ingredientRepository.existsById(id);
    }

    @Override
    public Iterable<Ingredient> getAll() {
        return ingredientRepository.findAll();
    }

    @Override
    public List<Ingredient> getById(int id) {
        return ingredientRepository.findById(id).map(Collections::singletonList).orElse(Collections.emptyList());
    }

    @Override
    public void save(Ingredient ingredient) {
        ingredientRepository.save(ingredient);
    }

    public IngredientType[] getIngredientTypes() {
        return IngredientType.values();
    }
}
