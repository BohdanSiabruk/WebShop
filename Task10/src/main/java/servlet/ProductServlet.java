package servlet;

import bin.Page;
import bin.PaginationRequest;
import entity.Product;
import service.ProductService;
import util.ProductHelper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static constant.Constants.*;

@WebServlet(PRODUCT_SERVLET)
public class ProductServlet extends HttpServlet {
    private ProductService productService;


    @Override
    public void init() {
        this.productService = (ProductService) getServletContext().getAttribute(PRODUCT_SERVICE);
    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {



        PaginationRequest paginationRequest = ProductHelper.createProductParameterForm(req);
        Page<Product> productPage = productService.findProduct(paginationRequest);

        ProductHelper.addParameterToRequest(req, paginationRequest, productPage);

        req.getRequestDispatcher(PRODUCT_JSP).forward(req, resp);
    }
}
