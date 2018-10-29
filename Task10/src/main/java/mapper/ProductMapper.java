package mapper;



import entity.Product;

import java.sql.ResultSet;
import java.sql.SQLException;

import static constant.Constants.*;

public class ProductMapper implements Mapper<Product> {

    public Product map(ResultSet resultSet) throws SQLException {
        return new Product(resultSet.getInt("id"), resultSet.getString(PRODUCT_FIRM), resultSet.getString(PRODUCT_MODEL),
                resultSet.getString(PRODUCT_PURPOSE), resultSet.getBigDecimal(PRODUCT_PRICE), resultSet.getString(PRODUCT_PICTURE));
    }
}
