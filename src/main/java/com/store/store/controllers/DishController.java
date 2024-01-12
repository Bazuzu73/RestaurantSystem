package com.store.store.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.ui.Model;
import com.store.store.models.Dish;
import com.store.store.services.DishService;
import com.store.store.services.IngredientService;
import org.springframework.web.bind.annotation.PostMapping;

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
        } else {
        model.addAttribute("dish", dishService.getById(id).get(0));
        model.addAttribute("ingredients", dishService.getRelated(id));
        model.addAttribute("allIngredients", ingredientService.getAll());
        return "dishDetailed";
        }
    }

    @PostMapping("/dish/{id}/update")
    public String postDish(Model model, @ModelAttribute Dish dish) {
        dishService.save(dish);
        return "redirect:/dishes";
    }


    @GetMapping("/dish/new")
    public String getNewDish(Model model) {
        model.addAttribute("dish", dishService.getEmpty());
        model.addAttribute("allIngredients", ingredientService.getAll());
        return "dishDetailed";
    }
    
    @PostMapping("/dish/new")
    public String postNewDish(Model model, @ModelAttribute Dish dish) {
        dishService.save(dish);
        return "redirect:/dishes";
    }

    @PostMapping("/dish/{id}/delete")
    public String deleteDish(@PathVariable(value = "id") int id, Model model) {
        if (dishService.ifExist(id)) {
            dishService.delete(id);
        }
        return "redirect:/dishes";
    }
    
}
