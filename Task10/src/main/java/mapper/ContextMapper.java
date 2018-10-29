package mapper;

import context.ProductContext;
import entity.Product;

public final class ContextMapper {
    private ContextMapper() {
    }

    public static ProductContext map(int count, Product product) {
        ProductContext productContext = new ProductContext();
        productContext.setProduct(product);
        productContext.setCount(count);
        return productContext;
    }
}
