package com.epam.preproduction.siabruk.dao.impl;

import com.epam.preproduction.siabruk.dao.IModel;
import com.epam.preproduction.siabruk.entity.Bicycle;
import com.epam.preproduction.siabruk.service.BicycleService;

import java.util.*;

public class BasketDAO implements IModel<Bicycle> {
    private static Map<Bicycle, Integer> basket = new Hashtable<>();
    private BicycleService bicycleService;
    private Bicycle bicycle = null;

    public BasketDAO(BicycleService bicycleService) {
        this.bicycleService = bicycleService;
    }

    private Map<Bicycle, Integer> tempListBasket = new LinkedHashMap<Bicycle, Integer>() {
        @Override
        protected boolean removeEldestEntry(Map.Entry eldest) {
            return size() > 5;
        }
    };

    @Override
    public Bicycle addWithKey(Integer choice) {

        for (Map.Entry<Bicycle, Integer> entry : bicycleService.getAll().entrySet()) {
            if (choice.equals(entry.getValue())) {
                bicycle = entry.getKey();
                choice = entry.getValue();
            }
        }

        tempListBasket.put(bicycle, choice);


        if (basket.containsKey(bicycle)) {
            basket.put(bicycle, basket.get(bicycle) + 1);
        } else {
            basket.put(bicycle, 1);
        }

        return bicycle;
    }

    @Override
    public Bicycle add(Bicycle item) {
        throw new UnsupportedOperationException("Unsupported method");
    }

    @Override
    public Map<Bicycle, Integer> findAll() {
        Map<Bicycle, Integer> basketCopy;
        basketCopy = basket;
        return basketCopy;
    }

    @Override
    public void show() {
        basket.forEach((key, value) -> System.out.println(key + "amount = " + value));
    }

    public void showLast() {
        tempListBasket.forEach((key, value) -> System.out.println(key));
    }

    public int sumOrder() {
              int sum = basket.entrySet().stream().mapToInt(e -> e.getKey().getPrice().intValue() * e.getValue()).sum();

        System.out.println("sum order = " + sum);
        return sum;
    }

    public static void clearBasket() {
        basket = new Hashtable<>();
    }

    public Map<Bicycle, Integer> getBasket() {
        return basket;
    }
}
