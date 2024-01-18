package com.store.store.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

import com.store.store.models.Order;
import com.store.store.services.OrderService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;

@Controller
public class OrderController {

    @Autowired
    OrderService orderService;

    @GetMapping("/order/list")
    public String getListOfOrders(Model model) {
        model.addAttribute("orders", orderService.getAll());
        return "orders";
    }

    @GetMapping("/order/new")
    public String getNewOrder(Model model) {
        model.addAttribute("order", orderService.getEmpty());
        model.addAttribute("province", orderService.getOrderProvinces());
        return "order";
    }

    @PostMapping("/order/new")
    public String postNewOrder(Model model, @ModelAttribute Order order) {
        orderService.save(order);
        return "redirect:/order/list";
    }

    @GetMapping("/order/{id}/update")
    public String getUpdateOrder(@PathVariable(value = "id") int id, Model model) {
        model.addAttribute("order", orderService.getById(id));
        model.addAttribute("province", orderService.getOrderProvinces());
        return "order";
    }

    @PostMapping("/order/{id}/update")
    public String postUpdateOrder(Model model, @RequestAttribute Order order) {
        return "redirect:/order/list";
    }

    @PostMapping("/order/{id}/delete")
    public String postDeleteOrder(@PathVariable(value = "id") int id, Model model) {
        orderService.delete(id);
        return "redirect:/order/list";
    }

}
