package com.epam.preproduction.siabruk.service.impl;

import com.epam.preproduction.siabruk.dao.BicycleDAO;
import com.epam.preproduction.siabruk.entity.Bicycle;
import com.epam.preproduction.siabruk.service.BicycleService;

import java.util.Map;

public class BicycleServiceImpl implements BicycleService {

    private BicycleDAO bicycleDAO;

    public BicycleServiceImpl(BicycleDAO bicycleDAO) {
        this.bicycleDAO = bicycleDAO;
    }

    public BicycleServiceImpl() {
    }


    @Override
    public Map<Bicycle, Integer> getAll() {
        return bicycleDAO.getAll();
    }

    @Override
    public Bicycle getById(int id) {
        return bicycleDAO.getId(id);
    }

    public void add(Bicycle bicycle) {
        bicycleDAO.getAll().put(bicycle, bicycleDAO.getAll().size() + 1);
    }
}