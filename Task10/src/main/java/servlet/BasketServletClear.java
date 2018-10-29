package servlet;

import com.google.gson.Gson;
import util.Basket;
import util.OrderHelper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.io.IOException;
import java.io.PrintWriter;

import static constant.Constants.*;
import static java.util.Objects.isNull;


@WebServlet(BASKET_SERVLET_CLEAR)
public class BasketServletClear extends HttpServlet {
    private Basket basket;
    private DataSource dataSource;


    @Override
    public void init() {
        this.dataSource = (DataSource) getServletContext().getAttribute("dataSource");

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        if (isNull(req.getSession().getAttribute(BASKET))) {
            basket = new Basket(dataSource);
            req.getSession().setAttribute(BASKET, basket);
        } else {
            basket = (Basket) req.getSession().getAttribute(BASKET);
        }

        resp.setContentType(TEXT_PLAIN);
        String clearBasket = req.getParameter(CLEAN_BASKET);
        if (clearBasket != null) {
            basket.clearBasket();
        }
        Gson json = new Gson();
        PrintWriter pr = resp.getWriter();
        String str = json.toJson(basket.getMapProductInBasket());
        pr.print(str);
        basket = null;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher(BASCET_JSP).forward(req, resp);
    }
}
