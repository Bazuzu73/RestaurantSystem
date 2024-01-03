package com.store.store.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

import com.store.store.models.Ingredient;
import com.store.store.models.IngredientType;
import com.store.store.services.IngredientService;

import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class IngredientController {

    @Autowired
    private IngredientService ingredientService;

    @GetMapping("/ingredients")
    public String getIngredientList(Model model) {
        model.addAttribute("ingredients", ingredientService.getAll());
        return "ingredients";
    }

    @GetMapping("/ingredient/{id}")
    public String getIngredient(@PathVariable(value = "id") int id, Model model) {
        if (!ingredientService.ifExist(id)) {
            return "redirect:ingredients";
        } else {
            model.addAttribute("ingredient", ingredientService.getById(id));
            return "ingredientDetailed";
        }
    }

    @GetMapping("/ingredient/new")
    public String saveIngredient(Model model) {
        IngredientType type[] = ingredientService.getIngredientTypes();
        Ingredient ingredient = new Ingredient();
        model.addAttribute("ingredient", ingredient);
        model.addAttribute("type", type);
        return "ingredientDetailed";
    }

    @PostMapping("/ingredient/new")
    public String postMethodName(Model model, @ModelAttribute Ingredient ingredient) {
        ingredientService.save(ingredient);
        return "redirect:/ingredients";
    }

}
