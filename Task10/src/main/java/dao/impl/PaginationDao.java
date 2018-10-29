package dao.impl;


import bin.Page;
import bin.PaginationRequest;
import db.ConnectionHolder;
import mapper.Mapper;
import util.ProductHelper;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public abstract class PaginationDao<T> {


    public Page<T> getPage(PaginationRequest paginationRequest, Mapper<T> mapper) throws SQLException {

        Page<T> page = new Page<>();

        page.setProductList(getList(paginationRequest, mapper));
        page.setPage(findCountRequest(paginationRequest));

        return page;
    }

    private List<T> getList(PaginationRequest paginationRequest, Mapper<T> mapper) throws SQLException {

        String sql = ProductHelper.createFullRequest(paginationRequest, getTableName());
        List<T> productList = new ArrayList<>();
        Statement statement;

        Connection connection = ConnectionHolder.getConnection();
        statement = connection.createStatement();
        ResultSet rs = statement.executeQuery(sql);

        while (rs.next()) {
            productList.add(mapper.map(rs));
        }

        return productList;
    }

    private int findCountRequest(PaginationRequest paginationRequest) throws SQLException {

        String sql = ProductHelper.buildSQLRequest(paginationRequest, getTableName());
        Statement statement;
        double count = 0;
        Connection connection = ConnectionHolder.getConnection();
        statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        while (resultSet.next()) {
            count++;
        }
        return ProductHelper.setAmountPages(count, paginationRequest.getAmountOnPage());
    }

    public abstract String getTableName();
}
