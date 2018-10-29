package com.epam.preproduction.siabruk.service;

import com.epam.preproduction.siabruk.entity.Bicycle;

import java.util.*;

public class BasketService implements IModel<Bicycle> {
    private static Map<Bicycle, Integer> basket = new Hashtable<>();
     ProductService productService = new ProductService() ;
     Bicycle bicycle = null;

    private HashMap<Bicycle, Integer> tempListBasket = new LinkedHashMap<Bicycle, Integer>() {
        @Override
        protected boolean removeEldestEntry(Map.Entry eldest) {
            return size() > 5;
        }
    };

    @Override
    public Bicycle addWithKey(Integer count) {

        for (Map.Entry<Bicycle, Integer> entry : productService.findAll().entrySet()) {
            if (count.equals(entry.getValue())) {
                bicycle = entry.getKey();
                count = entry.getValue();
            }
        }

        tempListBasket.put(bicycle, count);
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
int sum = basket.entrySet().stream().mapToInt(e -> e.getKey().getPrice() * e.getValue()).sum();

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
