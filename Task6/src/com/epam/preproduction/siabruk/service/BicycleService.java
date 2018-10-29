package com.epam.preproduction.siabruk.service;

import com.epam.preproduction.siabruk.entity.Bicycle;

import java.util.Map;

public interface BicycleService {
    Map<Bicycle, Integer> getAll();

    Bicycle getById(int id);

    void add(Bicycle bicycle);
}
