package com.epam.preproduction.siabruk.controller;

import com.epam.preproduction.siabruk.entity.Bicycle;
import com.epam.preproduction.siabruk.service.ProductService;

public class ProductController {

    private ProductService productService;

    public ProductController() {
        this.productService = new ProductService();
    }

    public void get() {
        productService.show();
    }
    public void add(Bicycle bicycle){
        productService.add(bicycle);
    }

}
