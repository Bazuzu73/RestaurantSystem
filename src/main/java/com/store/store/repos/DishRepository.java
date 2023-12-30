package com.store.store.repos;

import org.springframework.data.repository.CrudRepository;

import com.store.store.models.Dish;

public interface DishRepository extends CrudRepository<Dish, Integer> {

}
