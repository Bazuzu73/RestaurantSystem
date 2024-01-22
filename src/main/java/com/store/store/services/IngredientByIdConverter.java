package com.store.store.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.store.store.models.Ingredient;

@Component
public class IngredientByIdConverter implements Converter<String, Ingredient> {
    private List<Ingredient> ingredients = new ArrayList<>();

    @Autowired
    private IngredientService ingredientService;

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    public IngredientByIdConverter() {
    }

    public IngredientByIdConverter(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    @Override
    public Ingredient convert(String id) {
        return ingredientService.geIngredientObject(Integer.parseInt(id));
    }
    
}
