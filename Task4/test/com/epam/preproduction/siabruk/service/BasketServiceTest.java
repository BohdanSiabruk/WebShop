package com.epam.preproduction.siabruk.service;

import com.epam.preproduction.siabruk.Main;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.junit.Assert.assertNotNull;

public class BasketServiceTest {
    private BasketService basketService = new BasketService();


    @Test
    public void testCreateBasketModelInstance() {


        assertNotNull(basketService);
    }

    @Test
    public void testAddItem() {
        Main.AddProduct();

        basketService.addWithKey(5);

        assertEquals(1, basketService.findAll().size());
    }

    @Test
    public void testSumOrder() {

        basketService.addWithKey(1);
        basketService.addWithKey(2);
        basketService.addWithKey(3);

        assertEquals(4, basketService.findAll().size());

        assertEquals(14011, basketService.sumOrder());
    }

    @Test
    public void testClearBasket() {
        BasketService.clearBasket();

        assertEquals(0, basketService.getBasket().size());
    }
}
