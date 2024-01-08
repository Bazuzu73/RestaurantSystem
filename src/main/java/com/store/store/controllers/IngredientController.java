package com.store.store.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

import com.store.store.models.Ingredient;
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

    @GetMapping("/ingredient/{id}/update")
    public String getIngredientForUpdate(@PathVariable(value = "id") int id, Model model) {
        if (!ingredientService.ifExist(id)) {
            return "redirect:ingredients";
        } else {
            model.addAttribute("empty_ingredient", ingredientService.getEmpty());
            model.addAttribute("ingredient", ingredientService.getById(id));
            return "ingredientUpdated";
        }
    }

    @GetMapping("/ingredient/new")
    public String saveIngredient(Model model) {
        model.addAttribute("ingredient", ingredientService.getEmpty());
        model.addAttribute("type", ingredientService.getIngredientTypes());
        return "ingredientDetailed";
    }

    @PostMapping("/ingredient/new")
    public String newIngredient(Model model, @ModelAttribute Ingredient ingredient) {
        ingredientService.save(ingredient);
        return "redirect:/ingredients";
    }

    @PostMapping("/ingredient/{id}/delete")
    public String deleteIngredient(@PathVariable(value = "id") int id, Model model) {
        if (ingredientService.ifExist(id)) {
            ingredientService.delete(id);
        }
        return "redirect:/ingredients";
    }
}
