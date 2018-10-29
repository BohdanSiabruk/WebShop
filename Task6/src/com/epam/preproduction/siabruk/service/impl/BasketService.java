package com.epam.preproduction.siabruk.service.impl;

import com.epam.preproduction.siabruk.dao.impl.BasketDAO;
import com.epam.preproduction.siabruk.entity.Bicycle;
import com.epam.preproduction.siabruk.service.BicycleService;

import java.util.Map;


public class BasketService {
    private BasketDAO basketDAO;

    public BasketService(BicycleService bicycleService) {
        this.basketDAO = new BasketDAO(bicycleService);
    }


    public void add(int id) {
        this.basketDAO.addWithKey(id);
    }

    public void show() {
        basketDAO.show();
    }

    public void showLastItem() {
        basketDAO.showLast();
    }

    public void showSumOfOder() {
        basketDAO.sumOrder();
    }

    public Map<Bicycle, Integer> findAll() {
        return basketDAO.getBasket();
    }

}
