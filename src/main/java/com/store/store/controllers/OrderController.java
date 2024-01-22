package com.store.store.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

import com.store.store.models.Order;
import com.store.store.services.DishService;
import com.store.store.services.OrderService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/order")
public class OrderController implements GenericCRUDController<Order>{

    @Autowired
    OrderService orderService;

    @Autowired
    DishService dishService;

    @GetMapping("/list")
    @Override
    public String getAll(Model model) {
        model.addAttribute("orders", orderService.getAll());
        return "orders";
    }

    @GetMapping("/new")
    @Override
    public String getNew(Model model) {
        model.addAttribute("order", orderService.getEmpty());
        model.addAttribute("province", orderService.getOrderProvinces());
        model.addAttribute("dishList", dishService.getAll());
        return "order";
    }

    @PostMapping("/new")
    @Override
    public String postNew(@ModelAttribute Order order) {
        orderService.save(order);
        return "redirect:order/list";
    }

    @GetMapping("/{id}/update")
    @Override
    public String getUpdate(Model model, @PathVariable(value = "id") int id) {
        model.addAttribute("order", orderService.getById(id).get(0));
        model.addAttribute("dishList", dishService.getAll());
        model.addAttribute("province", orderService.getOrderProvinces());
        return "order";
    }

    @PostMapping("/{id}/update")
    @Override
    public String postUpdate(@ModelAttribute Order order) {
        orderService.save(order);
        return "redirect:order/list";
    }

    @PostMapping("/{id}/delete")
    @Override
    public String postDelete(@PathVariable(value = "id") int id) {
        orderService.delete(id);
        return "redirect:order/list";
    }
}
