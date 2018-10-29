package util;

import context.ProductContext;
import db.TransactionManager;
import entity.Product;
import mapper.ContextMapper;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class Basket {
    private TransactionManager transactionManager;
    private Map<Integer, ProductContext> mapProductInBasket = new HashMap<>();


    public Basket(DataSource dataSource) {
        this.transactionManager = new TransactionManager(dataSource);
    }

    public Map<Integer, ProductContext> getMapProductInBasket() {
        return mapProductInBasket;
    }


    public void addProductToBasketFromBase(int id) throws SQLException {
        addProductToBasket(transactionManager.execute(() -> UtilSQl.getProductFromBase(id)), id);
    }

    public void addProductToBasket(Product product, int id) {
        if (mapProductInBasket.containsKey(id)) {
            int currentCount = mapProductInBasket.get(id).getCount();
            ProductContext productContext = ContextMapper.map(currentCount + 1, product);
            mapProductInBasket.put(id, productContext);
        } else {
            mapProductInBasket.put(id, ContextMapper.map(1, product));
        }
    }

    public void removeOneProductFromBasket(int id) {
        if (mapProductInBasket.get(id).getCount() > 1) {
            int count = mapProductInBasket.get(id).getCount() - 1;
            mapProductInBasket.get(id).setCount(count);
        } else {
            mapProductInBasket.remove(id);
        }
    }

    public Product findById(int id) {
        return mapProductInBasket.get(id).getProduct();
    }

    public void removeProductFromBasket(int id) {
        mapProductInBasket.remove(id);
    }

    public void clearBasket() {
        mapProductInBasket.clear();
    }
}
