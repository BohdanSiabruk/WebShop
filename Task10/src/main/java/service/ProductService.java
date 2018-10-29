package service;


import bin.Page;
import bin.PaginationRequest;
import entity.Product;


public interface ProductService {

    Page<Product> findProduct(PaginationRequest paginationRequest);
}
