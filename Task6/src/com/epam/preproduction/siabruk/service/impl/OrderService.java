package com.epam.preproduction.siabruk.service.impl;

import com.epam.preproduction.siabruk.dao.impl.OrderDao;
import com.epam.preproduction.siabruk.service.impl.BasketService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class OrderService {

    private OrderDao orderDao = new OrderDao();
    private BasketService basketService;

    public OrderService(BasketService basketService) {
        this.basketService = basketService;
    }

    public void createOrder(Date date) {

        orderDao.makeOrder(date, basketService.findAll());

        basketService.show();
    }

    public void showListOder() throws IOException, ParseException {
        System.out.println("start");
        Date start = inputDate();
        System.out.println("end");
        Date end = inputDate();
        orderDao.findByDurability(start, end);
    }

    public void findNearest(Date date) throws ParseException {
        orderDao.showOderByDate(date);
    }

    public Date inputDate() throws IOException, ParseException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("enter the date by template 'dd-MM-yyyy HH:mm:ss': ");

        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");

        return formatter.parse(bufferedReader.readLine());
    }
}
