package dao;


import bin.Page;
import bin.PaginationRequest;
import entity.Product;

import java.sql.SQLException;

public interface ProductDao {

    Page<Product> findByRequest(PaginationRequest paginationRequest) throws SQLException;
}
