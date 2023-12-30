package com.store.store.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;
import com.store.store.models.Dish;
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
}
