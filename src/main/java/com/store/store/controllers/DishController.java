package com.store.store.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.ui.Model;
import com.store.store.models.Dish;
import com.store.store.models.Ingredient;
import com.store.store.services.DishService;
import com.store.store.services.IngredientService;

@Controller
public class DishController {

    @Autowired
    private DishService dishService;

    @Autowired
    private IngredientService ingredientService;

    @GetMapping("/dishes")
    public String getListofDishes(Model model) {
        Iterable<Dish> dishes = dishService.getAll();
        model.addAttribute("dishes", dishes);
        return "dishes";
    }

    @GetMapping("/dish/{id}/update")
    public String getDish(@PathVariable(value = "id") int id, Model model) {
        if (!dishService.ifExist(id)) {
            return "redirect:/dishes";
        }
        Dish dish = dishService.getById(id).get(0);
        List<Ingredient> dishIngredients = dishService.getRelated(id);
        Iterable<Ingredient> allIngredients = ingredientService.getAll();
        model.addAttribute("dish", dish);
        model.addAttribute("ingredients", dishIngredients);
        model.addAttribute("allIngredients", allIngredients);
        return "dishDetailed";
    }
}
