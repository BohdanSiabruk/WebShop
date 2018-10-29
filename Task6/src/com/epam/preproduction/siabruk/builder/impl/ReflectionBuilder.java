package com.epam.preproduction.siabruk.builder.impl;

import com.epam.preproduction.siabruk.builder.BuilderProduct;
import com.epam.preproduction.siabruk.entity.Bicycle;
import com.epam.preproduction.siabruk.reflection.BicycleAnnotation;
import com.epam.preproduction.siabruk.strategy.BicycleStrategy;

import java.io.IOException;
import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

public class ReflectionBuilder implements BuilderProduct {

    private BicycleStrategy bicycleStrategy;
    private Class clazz;

    public ReflectionBuilder(BicycleStrategy bicycleStrategy, Class clazz) {
        this.bicycleStrategy = bicycleStrategy;
        this.clazz = clazz;
    }

    @Override
    public Bicycle createBicycle() throws IOException, IllegalAccessException, InstantiationException {

        Bicycle someBike = (Bicycle) clazz.newInstance();

        Set<Field> set = findFields(someBike.getClass(), BicycleAnnotation.class);
        for (Field field : set) {
            field.setAccessible(true);

            if (field.getType() == int.class || field.getType() == BigDecimal.class) {

                switch (field.getName()) {
                    case "wheelSize":
                        field.setInt(someBike, bicycleStrategy.getWheelSize());
                        break;
                    case "price":
                        field.set(someBike, bicycleStrategy.getPrice());
                        break;
                    case "amountOfSpeed":
                        field.setInt(someBike, bicycleStrategy.getAmountOfSpeed());
                        break;
                    case "maxSpeed":
                        field.setInt(someBike, bicycleStrategy.getMaxSpeed());
                        break;
                    case "workTime":
                        field.setInt(someBike, bicycleStrategy.getWorkTime());
                        break;
                }
            } else {
                if (field.getType() == String.class) {

                    switch (field.getName()) {

                        case "color":
                            field.set(someBike, bicycleStrategy.getColor());
                            break;
                        case "suspensionType":
                            field.set(someBike, bicycleStrategy.getSuspensionType());
                            break;
                    }
                }
            }
            field.setAccessible(false);
        }
        return someBike;
    }

    private Set<Field> findFields(Class<?> classs, Class<? extends BicycleAnnotation> bicycleClass) {
        Set<Field> set = new HashSet<>();
        Class<?> c = classs;
        while (c != null) {
            for (Field field : c.getDeclaredFields()) {
                if (field.isAnnotationPresent(bicycleClass)) {
                    set.add(field);
                }
            }
            c = c.getSuperclass();
        }
        return set;
    }
}
