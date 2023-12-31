package com.store.store.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.ui.Model;
import com.store.store.models.Dish;
import com.store.store.models.Ingredient;
import com.store.store.services.DishService;

@Controller
public class DishController {

    private DishService dishService;

    @GetMapping("/dishes")
    public String getListofDishes(Model model) {    
        Iterable<Dish> dishes = dishService.getAllDishes();
        model.addAttribute("dishes", dishes);
        return "dishes";
    }

    @GetMapping("/dish/{id}")
    public String getDish(@PathVariable(value = "id") int id, Model model) {
        if(dishService.ifExist(id)) {
            return "redirect:/dishes";
        }
        List<Dish> dish = dishService.getDishById(id);
        List<Ingredient> ingredients = dishService.getRelatedIngredients(id);
        model.addAttribute("dish", dish);
        model.addAttribute("ingredients", ingredients);
        return "dishDetailed";
    }
}
