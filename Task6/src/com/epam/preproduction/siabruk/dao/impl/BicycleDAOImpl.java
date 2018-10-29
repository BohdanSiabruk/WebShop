package com.epam.preproduction.siabruk.dao.impl;

import com.epam.preproduction.siabruk.dao.BicycleDAO;
import com.epam.preproduction.siabruk.entity.Bicycle;

import java.util.LinkedHashMap;
import java.util.Map;

public class BicycleDAOImpl implements BicycleDAO {
    private Map<Bicycle, Integer> bicycleList;

    public BicycleDAOImpl(Map<Bicycle, Integer> bicycleList) {
        this.bicycleList = bicycleList;
    }

    public Map<Bicycle, Integer> getBicycleList() {
        return bicycleList;
    }

    public void setBicycleList(Map<Bicycle, Integer> bicycleList) {
        this.bicycleList = bicycleList;
    }

    @Override
    public Map<Bicycle, Integer> getAll() {
        return bicycleList;
    }

    @Override
    public Bicycle getId(int id) {

        return bicycleList.entrySet().stream().filter(entry -> entry.getValue() == id).map(Map.Entry::getKey).findFirst().orElse(null);
    }

    @Override
    public void add(Bicycle bicycle) {
        bicycleList.put(bicycle, bicycle.getId());
    }

}
