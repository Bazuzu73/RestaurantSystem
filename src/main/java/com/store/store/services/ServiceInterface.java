package com.store.store.services;

import java.util.List;

public interface ServiceInterface<T> {

    public boolean ifExist(int id);

    Iterable<T> getAll();

    List<T> getById(int id);

    void save(T t);
}
