package service.sqlImpl;

import bin.Page;
import bin.PaginationRequest;
import dao.ProductDao;
import dao.impl.ProductDaoImpl;
import db.TransactionManager;
import entity.Product;
import service.ProductService;

import javax.sql.DataSource;
import java.sql.SQLException;

public class ProductServiceImpl implements ProductService {

    private ProductDao productDao = new ProductDaoImpl();
    private TransactionManager transactionManager;

    public ProductServiceImpl(DataSource dataSource) {

        this.transactionManager = new TransactionManager(dataSource);
    }

    @Override
    public Page<Product> findProduct(PaginationRequest paginationRequest) {
        Page<Product> productList = null;
        try {
            productList = transactionManager.execute(() -> productDao.findByRequest(paginationRequest));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return productList;
    }

}
