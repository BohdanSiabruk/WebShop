package com.epam.preproduction.siabruk.service;

import com.epam.preproduction.siabruk.entity.Bicycle;
import org.junit.Test;

import static org.junit.Assert.*;

public class ProductServiceTest {
ProductService productService;

    @Test
    public void add() {
        productService = new ProductService();
        productService.add(new Bicycle(26, "red", 232));
        assertEquals(1, productService.findAll().size());
    }
}