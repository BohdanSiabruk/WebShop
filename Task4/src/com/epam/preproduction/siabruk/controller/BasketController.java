package com.epam.preproduction.siabruk.controller;

import com.epam.preproduction.siabruk.entity.Bicycle;
import com.epam.preproduction.siabruk.service.BasketService;

import java.util.Map;


public class BasketController {
    private BasketService basketService;

    public BasketController() {
        this.basketService = new BasketService();
    }


    public void add(int id) {
        this.basketService.addWithKey(id);
    }

    public void show() {
        basketService.show();
    }

    public void showLastItem() {
        basketService.showLast();
    }

    public void showSumOfOder() {
        basketService.sumOrder();
    }

    public Map<Bicycle, Integer> findAll() {
        return basketService.getBasket();
    }

}
