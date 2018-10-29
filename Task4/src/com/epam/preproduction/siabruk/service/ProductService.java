package com.epam.preproduction.siabruk.service;

import com.epam.preproduction.siabruk.entity.Bicycle;

import java.util.LinkedHashMap;
import java.util.Map;

public class ProductService implements IModel<Bicycle> {

    private static Map<Bicycle, Integer> products = new LinkedHashMap<>();
    private int i;

    @Override
    public Bicycle add(Bicycle item) {
        products.put(item, i++);

        return item;
    }

    @Override
    public Map<Bicycle, Integer> findAll() {
        return products;
    }

    @Override
    public Bicycle addWithKey(Integer id) {
        throw new UnsupportedOperationException("this command is unsupported ");
    }

    @Override
    public void show() {
        findAll().forEach((key, value) -> System.out.println(value + "  position ==> " + key));
    }
}
