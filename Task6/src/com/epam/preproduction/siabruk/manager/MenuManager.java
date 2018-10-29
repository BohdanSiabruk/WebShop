package com.epam.preproduction.siabruk.manager;

import com.epam.preproduction.siabruk.builder.BuilderContainer;
import com.epam.preproduction.siabruk.service.impl.BasketService;
import com.epam.preproduction.siabruk.service.BicycleService;
import com.epam.preproduction.siabruk.service.impl.OrderService;
import com.epam.preproduction.siabruk.strategy.BicycleStrategy;
import com.epam.preproduction.siabruk.strategy.ChooseStrategy;
import com.epam.preproduction.siabruk.helper.ConsoleHelper;

import java.io.IOException;
import java.text.ParseException;

public class MenuManager {
    private BicycleService bicycleService;

    public MenuManager(BicycleService bicycleService) {
        this.bicycleService = bicycleService;
    }

    public void menu() throws IOException, ParseException, IllegalAccessException, InstantiationException {

        BasketService basketService = new BasketService(bicycleService);
        OrderService orderService = new OrderService(basketService);
        BuilderContainer builderContainer = new BuilderContainer();
        boolean flag = true;

        String choosenNumber;

        String language = ConsoleHelper.checkLanguage();

        ChooseStrategy chooseStrategy = new ChooseStrategy(language);
        String methodInput = ConsoleHelper.checkEnteringValueChoiceMethod(ConsoleHelper.
                resourceBundle(language, "generateOrConsole"), chooseStrategy);
        BicycleStrategy bicycleStrategy = chooseStrategy.chooseStrategy(methodInput);
        ProductManager productManager = new ProductManager(bicycleService, builderContainer,
                bicycleStrategy , language);


        while (flag) {
            System.out.println("///////////////////////////////////////////////////////////");
            System.out.println();
            System.out.println("choose action");
            System.out.println();
            System.out.println("1 - show a product list");
            System.out.println("2 - add product into basket");
            System.out.println("3 - show basket");
            System.out.println("4 - show 5 last element");
            System.out.println("5 - make an oder and show sum of oder");
            System.out.println("6 - show list order by date");
            System.out.println("7 - find the nearest order by date ");
            System.out.println("8 - add product");
            System.out.println("9 - add product with com.epam.preproduction.siabruk.reflection");
            System.out.println("10 - exit ");
            System.out.println();
            System.out.println("///////////////////////////////////////////////////////////");

            System.out.println(ConsoleHelper.resourceBundle(language, "choose position"));
            choosenNumber = ConsoleHelper.checkValue();
            switch (choosenNumber) {
                case "1":
                    bicycleService.getAll().forEach((key, value) -> System.out.println(value
                            + " " + key));
                    break;
                case "2":
                    System.out.print("make your choice ");
                    int choice = ConsoleHelper.checkAndGetValueIntMenu(bicycleService);
                    basketService.add(choice);
                    break;
                case "3":
                    basketService.show();
                    break;
                case "4":
                    basketService.showLastItem();
                    break;
                case "5":
                    basketService.showSumOfOder();
                    System.out.print("enter date: \"dd-MM-yyyy HH:mm:ss\"");
                    orderService.createOrder(ConsoleHelper.parseDate());
                    break;
                case "6":
                    orderService.showListOder();
                    break;
                case "7":
                    System.out.println("enter date \"dd-MM-yyyy HH:mm:ss\" ");
                    orderService.findNearest(ConsoleHelper.parseDate());
                    break;
                case "8":
                    productManager.addProduct(false);
                    break;
                case "9":
                    productManager.addProduct(true);
                    break;
                case "10":
                    flag = false;
                    break;
                default:
                    System.out.println(" that command doesn't exist");
            }
        }
    }
}
