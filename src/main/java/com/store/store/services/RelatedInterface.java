package com.store.store.services;

import java.util.List;

public interface RelatedInterface<T> {
    List<T> getRelated(int id);
}
