package dao.impl;

import bin.Page;
import bin.PaginationRequest;
import constant.Constants;
import dao.ProductDao;
import entity.Product;
import mapper.Mapper;
import mapper.ProductMapper;

import java.sql.SQLException;

public class ProductDaoImpl extends PaginationDao<Product> implements ProductDao  {
    private Mapper<Product> mapper = new ProductMapper();

    @Override
    public String getTableName() {
        return Constants.PRODUCT_TABLE_NAME;
    }

    @Override
    public Page<Product> findByRequest(PaginationRequest paginationRequest) throws SQLException {
        return getPage(paginationRequest, mapper);
    }

}
