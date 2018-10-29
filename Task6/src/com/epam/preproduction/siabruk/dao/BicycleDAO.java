package com.epam.preproduction.siabruk.dao;

import com.epam.preproduction.siabruk.entity.Bicycle;

import java.util.Map;

public interface BicycleDAO {
    public Map<Bicycle, Integer> getAll();

    public Bicycle getId(int id);

    void add(Bicycle bicycle);
}
