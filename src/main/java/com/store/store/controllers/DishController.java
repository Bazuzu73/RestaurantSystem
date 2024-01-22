package com.store.store.controllers;

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
public class DishController implements GenericCRUDController<Dish>{

    @Autowired
    private DishService dishService;

    @Autowired
    private IngredientService ingredientService;

    @GetMapping("/dish/list")
    @Override
    public String getAll(Model model) {
        Iterable<Dish> dishes = dishService.getAll();
        model.addAttribute("dishes", dishes);
        return "dishes";
    }

    @GetMapping("/dish/{id}/update")
    @Override
    public String getUpdate(Model model, @PathVariable(value = "id") int id) {
        if (!dishService.ifExist(id)) {
            return "redirect:/dish/list";
        } else {
            model.addAttribute("dish", dishService.getById(id).get(0));
            model.addAttribute("ingredients", dishService.getRelated(id));
            model.addAttribute("allIngredients", ingredientService.getAll());
            return "dish";
        }
    }

    @PostMapping("/dish/{id}/update")
    @Override
    public String postUpdate(@ModelAttribute Dish dish) {
        dishService.save(dish);
        return "redirect:/dish/list";
    }

    @GetMapping("/dish/new")
    @Override
    public String getNew(Model model) {
        model.addAttribute("dish", dishService.getEmpty());
        model.addAttribute("allIngredients", ingredientService.getAll());
        return "dish";
    }

    @PostMapping("/dish/new")
    @Override
    public String postNew(@ModelAttribute Dish dish) {
        dishService.save(dish);
        return "redirect:/dish/list";
    }

    @PostMapping("/dish/{id}/delete")
    @Override
    public String postDelete(@PathVariable(value = "id") int id) {
        if (dishService.ifExist(id)) {
            dishService.delete(id);
        }
        return "redirect:/dish/list";
    }
}
