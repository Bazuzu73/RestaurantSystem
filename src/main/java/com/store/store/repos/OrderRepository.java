package com.store.store.repos;

import org.springframework.data.repository.CrudRepository;

import com.store.store.models.Order;

public interface OrderRepository extends CrudRepository<Order, Integer> {

}
