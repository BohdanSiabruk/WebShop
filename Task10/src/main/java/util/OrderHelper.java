package util;

import constant.Constants;
import context.ProductContext;
import entity.Order;
import entity.Product;
import enumeration.Status;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;

import static java.util.Objects.nonNull;

public final class OrderHelper {
    private OrderHelper() {
    }

    public static boolean isNotNullCardRecvisit(String typeCard, String value) {
        return nonNull(typeCard) && nonNull(value);
    }

    public static Order createOrder(Map<Integer, ProductContext> mapBasket, String login) {
        Order order = new Order();
        order.setStatus(Status.ACCEPTED);
        order.setInfo(Constants.INFO_ACCEPTED);
        order.setDate(new java.sql.Date(new Date().getTime()));
        order.setLogin(login);
        order.setMapBasket(mapBasket);
        return order;
    }
}
