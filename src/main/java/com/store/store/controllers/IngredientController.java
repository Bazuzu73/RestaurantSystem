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
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/ingredient")
public class IngredientController implements GenericCRUDController<Ingredient>{

    @Autowired
    private IngredientService ingredientService;

    @GetMapping("/list")
    @Override
    public String getAll(Model model) {
        model.addAttribute("ingredients", ingredientService.getAll());
        return "ingredients";
    }

    @GetMapping("/{id}/update")
    @Override
    public String getUpdate(Model model, @PathVariable(value = "id") int id) {
        if (!ingredientService.ifExist(id)) {
            return "redirect:ingredients";
        } else {
            model.addAttribute("ingredient", ingredientService.geIngredientObject(id));
            model.addAttribute("type", ingredientService.getIngredientTypes());
            return "ingredient";
        }
    }

    @PostMapping("/{id}/update")
    @Override
    public String postUpdate(@ModelAttribute Ingredient ingredient) {
        ingredientService.save(ingredient);
        return "redirect:/ingredient/list";
    }

    @GetMapping("/new")
    @Override
    public String getNew(Model model) {
        model.addAttribute("ingredient", ingredientService.getEmpty());
        model.addAttribute("type", ingredientService.getIngredientTypes());
        return "ingredient";
    }

    @PostMapping("/new")
    @Override
    public String postNew(@ModelAttribute Ingredient ingredient) {
        System.out.println(ingredient.getId());
        ingredientService.save(ingredient);
        return "redirect:/ingredient/list";
    }

    @PostMapping("/{id}/delete")
    @Override
    public String postDelete(@PathVariable(value = "id") int id) {
        if (ingredientService.ifExist(id)) {
            ingredientService.delete(id);
        }
        return "redirect:/ingredient/list";
    }
}
