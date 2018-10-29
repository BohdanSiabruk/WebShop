package com.epam.preproduction.siabruk.builder;

import com.epam.preproduction.siabruk.entity.Bicycle;
import com.epam.preproduction.siabruk.manager.ProductManager;
import com.epam.preproduction.siabruk.strategy.ChooseStrategy;

import java.io.IOException;

public interface BuilderProduct {
    Bicycle createBicycle() throws IOException, IllegalAccessException, InstantiationException;

}
