package com.store.store.services;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.store.store.models.OrderProvince;
import com.store.store.models.Dish;
import com.store.store.models.Order;
import com.store.store.repos.OrderRepository;

@Service
public class OrderService implements ServiceInterface<Order>, RelatedInterface<Dish> {

    @Autowired
    private OrderRepository orderRepository;

    @Override
    public boolean ifExist(int id) {
        return orderRepository.existsById(id);
    }

    @Override
    public Iterable<Order> getAll() {
        return orderRepository.findAll();
    }

    @Override
    public List<Order> getById(int id) {
        return orderRepository.findById(id).map(Collections::singletonList).orElse(Collections.emptyList());
    }

    @Override
    public List<Dish> getRelated(int id) {
        return orderRepository.findById(id).map(Order::getDishes).orElse(Collections.emptyList());
    }

    @Override
    public void save(Order order) {
        orderRepository.save(order);
    }

    @Override
    public void delete(int id) {
        orderRepository.delete(orderRepository.findById(id).get());
    }

    @Override
    public Order getEmpty() {
        return new Order();
    }

    public OrderProvince[] getOrderProvinces() {
        return OrderProvince.values();
    }
}
