package com.epam.preproduction.siabruk.service;

import java.util.Map;

public interface IModel<T> {
    public T add(T item);

    public T addWithKey(Integer id);

    public Map<T, Integer> findAll();

    public void show();
}
