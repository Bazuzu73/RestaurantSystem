package com.store.store.controllers;

import org.springframework.ui.Model;

public interface GenericCRUDController<T> {

    public String getAll(Model model);

    public String getNew(Model model);

    public String postNew(T t);

    public String getUpdate(Model model, int id);

    public String postUpdate(T t);

    public String postDelete(int id);
}
