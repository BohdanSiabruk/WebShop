package com.epam.preproduction.siabruk.controller;

import static org.junit.Assert.*;

import com.epam.preproduction.siabruk.entity.Bicycle;
import com.epam.preproduction.siabruk.service.OrderService;
import org.junit.Before;
import org.junit.Test;

import java.text.ParseException;
import java.util.Date;

public class OrderControllerTest {
    BasketController basketController;
    ProductController productController;
    OrderController orderController = new OrderController();


    @Before
    public void setup() throws ParseException {
        basketController = new BasketController();
        productController = new ProductController();
        for (int i = 0; i < 6; i++) {
            productController.add(new Bicycle(26 + i, "black", 3500 + i));
        }

        basketController.add(1);
        basketController.add(2);
        basketController.add(2);
        orderController.createOrder(orderController.parseDate("10-10-2018 12:12:12"));

        basketController.add(3);
        basketController.add(2);
        basketController.add(2);
        orderController.createOrder(orderController.parseDate("12-12-2012 12:12:12"));


    }

    @Test
    public void testMakeOrder() throws ParseException {

        basketController.add(3);
        basketController.add(2);
        basketController.add(4);

        orderController.createOrder(orderController.parseDate("12-12-2013 12:12:12"));

        assertEquals(3, orderController.findAll().size());
    }

    @Test
    public void testParseDate() throws ParseException {
assertEquals(new Date().getClass(), orderController.parseDate("12-12-2018 12:12:12").getClass());
    }


}
