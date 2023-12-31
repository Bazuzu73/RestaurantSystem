package com.store.store.controllers;

import java.util.List;
import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.store.store.models.Ingredient;
import com.store.store.repos.IngredientRepository;

@Controller
public class IngredientController {

    @Autowired
    private IngredientRepository ingredientRepository;

    @GetMapping("/ingredients")
    public String getIngredientList(Model model) {
        Iterable<Ingredient> ingredients = ingredientRepository.findAll();
        model.addAttribute("ingredients", ingredients);
        return "ingredients";
    }

    @GetMapping("/ingredient/{id}")
    public String getMethodName(@PathVariable(value = "id") int id, Model model) {
        List<Ingredient> ingredient = new ArrayList<>();
        Optional<Ingredient> ingredientOptional = ingredientRepository.findById(id);
        if (ingredientOptional.isPresent()) {
            ingredientOptional.ifPresent(ingredient::add);
            model.addAttribute("ingredient", ingredient);
            return "ingredient";
        } else {
            return "redirect:/ingredients";
        }
    }

}
