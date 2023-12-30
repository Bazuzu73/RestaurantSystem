package com.store.store.repos;

import org.springframework.data.repository.CrudRepository;

import com.store.store.models.Ingredient;

public interface IngredientRepository extends CrudRepository<Ingredient, Integer> {
    
}
