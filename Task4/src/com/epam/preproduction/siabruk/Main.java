package com.epam.preproduction.siabruk;

import com.epam.preproduction.siabruk.controller.BasketController;
import com.epam.preproduction.siabruk.controller.OrderController;
import com.epam.preproduction.siabruk.controller.ProductController;
import com.epam.preproduction.siabruk.entity.Bicycle;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;

public class Main {
    static  BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    static ProductController productController = new ProductController();
    static BasketController basketController = new BasketController();
    static OrderController orderController = new OrderController();

    public static void main(String[] args) throws IOException, ParseException {

        boolean flag = true;
        Main.AddProduct();


        String choosenNumber;


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
            System.out.println("6 - show list order");
            System.out.println("7 - find the nearest order by date ");
            System.out.println("8 - exit ");
            System.out.println();
            System.out.println("///////////////////////////////////////////////////////////");

            choosenNumber = checkValue(bufferedReader.readLine());
            switch (choosenNumber) {
                case "1":
                    productController.get();
                    break;
                case "2":
                    System.out.print("make your choice ");
                    choosenNumber = bufferedReader.readLine();
                    int choice = Integer.parseInt(choosenNumber);
                    basketController.add(choice);
                    break;
                case "3":
                    basketController.show();
                    break;
                case "4":
                    basketController.showLastItem();
                    break;
                case "5":
                    basketController.showSumOfOder();
                    System.out.print("enter date: ");
                    orderController.createOrder(orderController.parseDate(bufferedReader.readLine()));
                    break;
                case "6":

                    orderController.showListOder();
                    break;
                case "7":
                    orderController.findNearest(bufferedReader.readLine());
                    break;
                case "8":
                    flag = false;
                    break;
                default:
                    System.out.println(" that command doesn't exist");
            }
        }


    }
    public static String checkValue(String s) throws IOException {
        int i = 0;
        try {
            i = Integer.parseInt(s);
        } catch (NumberFormatException e) {
            e.printStackTrace();
            System.out.println("you should enter number");
        }

        if (i > 0 && i < 9){
            return s;
        } else return checkValue(bufferedReader.readLine());

    }

    public static void AddProduct() {
        for (int i = 0; i < 6; i++ ) {
            productController.add(new Bicycle(26 + i, "black", 3500 + i));
        }
    }
}
