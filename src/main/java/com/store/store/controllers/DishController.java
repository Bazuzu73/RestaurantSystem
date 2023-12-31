package com.store.store.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.ui.Model;
import com.store.store.models.Dish;
import com.store.store.models.Ingredient;
import com.store.store.repos.DishRepository;

@Controller
public class DishController {

    @Autowired
    private DishRepository dishRepository;

    @GetMapping("/dishes")
    public String getListofDishes(Model model) {    
        Iterable<Dish> dishes = dishRepository.findAll();
        model.addAttribute("dishes", dishes);
        return "dishes";
    }

    @GetMapping("/dish/{id}")
    public String getDish(@PathVariable(value = "id") int id, Model model) {
        if(!dishRepository.existsById(id)) {
            return "redirect:/dishes";
        }
        Optional<Dish> dishOptional = dishRepository.findById(id);
        List<Dish> dishArray = new ArrayList<>();
        Iterable<Ingredient> ingredients = new ArrayList<>();
        if (dishOptional.isPresent()) {
            dishOptional.ifPresent(dishArray :: add);
            Dish dish = dishOptional.get();
            ingredients = dish.getIngredients();
        }
        model.addAttribute("dish", dishArray);
        model.addAttribute("ingredients", ingredients);
        return "dishDetailed";
    }
}
