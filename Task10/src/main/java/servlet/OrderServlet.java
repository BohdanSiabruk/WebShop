package servlet;

import db.TransactionManager;
import entity.Order;
import enumeration.Status;
import service.OrderService;
import util.Basket;
import util.OrderHelper;
import util.UtilSQl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.io.IOException;
import java.sql.SQLException;

import static constant.Constants.*;
import static java.util.Objects.nonNull;
import static util.OrderHelper.isNotNullCardRecvisit;

@WebServlet("/order")
public class OrderServlet extends HttpServlet {
    private OrderService orderService;
    private TransactionManager transactionManager;

    @Override
    public void init() {
        this.transactionManager = new TransactionManager((DataSource) getServletContext().getAttribute("dataSource"));
        this.orderService = (OrderService) getServletContext().getAttribute(ORDER_SERVICE);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String typeCard = req.getParameter(VARIANT_PAYMENT);
        String numberCard = req.getParameter(CARD_VALUE);

        String login = (String) req.getSession().getAttribute(EMAIL);
        Basket basket = (Basket) req.getSession().getAttribute(BASKET);
        Order order = OrderHelper.createOrder(basket.getMapProductInBasket(), login);

        if (isNotNullCardRecvisit(typeCard, numberCard) && nonNull(login)) {
            try {
                orderService.makeOrder(order);

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        String sql = "update orders set status='" + Status.CONFIRMED.status + "' where status='accepted'";
        try {
            transactionManager.execute(() -> UtilSQl.writeStatus(sql));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        req.getSession().removeAttribute(BASKET);
        resp.sendRedirect("/order");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/order.jsp").forward(req, resp);
    }

}
