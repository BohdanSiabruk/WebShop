package com.epam.preproduction.siabruk.manager;

import com.epam.preproduction.siabruk.builder.BuilderContainer;
import com.epam.preproduction.siabruk.builder.BuilderProduct;
import com.epam.preproduction.siabruk.builder.impl.BicycleBuilder;
import com.epam.preproduction.siabruk.builder.impl.ElectricalMountainBieBuilder;
import com.epam.preproduction.siabruk.builder.impl.MountainBikeBuilder;
import com.epam.preproduction.siabruk.builder.impl.ReflectionBuilder;
import com.epam.preproduction.siabruk.constant.Context;
import com.epam.preproduction.siabruk.entity.Bicycle;
import com.epam.preproduction.siabruk.entity.ElectricalMountainBike;
import com.epam.preproduction.siabruk.entity.MountainBike;
import com.epam.preproduction.siabruk.service.BicycleService;
import com.epam.preproduction.siabruk.strategy.BicycleStrategy;
import com.epam.preproduction.siabruk.helper.ConsoleHelper;

import java.io.IOException;

public class ProductManager {

    private BuilderContainer builderContainer;
    private BicycleStrategy bicycleStrategy;
    private BicycleService bicycleService;
    private String language;

    public ProductManager(BicycleService bicycleService, BuilderContainer builderContainer,
                          BicycleStrategy bicycleStrategy, String language) {
        this.bicycleService = bicycleService;
        this.builderContainer = builderContainer;
        this.bicycleStrategy = bicycleStrategy;
        this.language = language;
    }

    public void addProduct(boolean createByReflection) throws IOException, IllegalAccessException, InstantiationException {
        addBuilderCont(bicycleStrategy);
        startBuild(createByReflection);
    }



    private void addBuilderCont(BicycleStrategy bicycleStrategy) {

        builderContainer.addToBuilderContainer(Context.BICYCLE, new BicycleBuilder(bicycleStrategy));
        builderContainer.addToBuilderContainer(Context.MOUNTAINBIKE, new MountainBikeBuilder(bicycleStrategy));
        builderContainer.addToBuilderContainer(Context.ELECTRICALMOUNTAINBIKE, new ElectricalMountainBieBuilder(
                bicycleStrategy));
        builderContainer.addToBuilderContainer(Context.BICYCLE + "ref", new ReflectionBuilder(bicycleStrategy, Bicycle.class));
        builderContainer.addToBuilderContainer(Context.MOUNTAINBIKE + "ref", new ReflectionBuilder(bicycleStrategy, MountainBike.class));
        builderContainer.addToBuilderContainer(Context.ELECTRICALMOUNTAINBIKE + "ref", new ReflectionBuilder(bicycleStrategy, ElectricalMountainBike.class));
    }

    private void startBuild(boolean createByReflection) throws IOException, InstantiationException, IllegalAccessException {

        System.out.println(ConsoleHelper.resourceBundle(language, "chooseObject"));
        String typeOfObject = ConsoleHelper.checkAddNewItem(builderContainer);
        if (createByReflection) {
            typeOfObject += "ref";
        }
        BuilderProduct builderProduct = builderContainer.getBuilder(typeOfObject);
        bicycleService.add(builderProduct.createBicycle());
    }
}
