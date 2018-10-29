package com.epam.preproduction.siabruk.controller;

import com.epam.preproduction.siabruk.service.OrderService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

public class OrderController {

    private OrderService orderService = new OrderService();
    private BasketController basketController = new BasketController();

    public void createOrder(Date date) {

        orderService.makeOrder(date, basketController.findAll() );

        basketController.show();
    }

    public void showListOder() throws IOException, ParseException {
        System.out.println("start");
        Date start = inputDate();
        System.out.println("end");
        Date end = inputDate();
        orderService.findByDurability(start, end);
    }

    public void findNearest(String s) throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        orderService.showOderByDate(formatter.parse(s));
    }

    public Date inputDate() throws IOException, ParseException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("enter the date by template 'dd-MM-yyyy HH:mm:ss': ");

        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");

        return formatter.parse(bufferedReader.readLine());
    }

    public Date parseDate(String s) throws ParseException {

        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        return formatter.parse(s);
    }

    public Map<Date, Map> findAll(){
        return orderService.getOrderList();
    }
}
