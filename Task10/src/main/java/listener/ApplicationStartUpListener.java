package listener;

import constant.Constants;
import dao.CaptchaDao;
import dao.impl.CaptchaDaoImpl;
import db.ConnectionPool;
import schedule.StatusWriter;
import service.OrderService;
import service.ProductService;
import service.UserService;
import service.impl.CaptchaServiceImpl;
import service.impl.OrderServiceImpl;
import service.sqlImpl.ProductServiceImpl;
import service.sqlImpl.UserServiceImpl;
import strategy.CaptchaStrategy;
import strategy.ChooseStrategy;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

import static constant.Constants.*;

@WebListener

public class ApplicationStartUpListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent event) {
        System.out.println("---- initialize servlet context -----");

        Map<String, String> mapError = createMapErrors();
        event.getServletContext().setAttribute("errorsMap", mapError);

        CaptchaDao captchaDaoImpl = new CaptchaDaoImpl();
        CaptchaServiceImpl captchaServiceImpl = new CaptchaServiceImpl(captchaDaoImpl);
        event.getServletContext().setAttribute("captchaServiceImpl", captchaServiceImpl);

        CaptchaStrategy captchaStrategy = new ChooseStrategy(event.getServletContext().getInitParameter("chooseStrategy")).chooseStrategy();
        event.getServletContext().setAttribute("captchaStrategy", captchaStrategy);


        DataSource dataSource = ConnectionPool.initDatasource();
        UserService userService = new UserServiceImpl(dataSource);
        event.getServletContext().setAttribute(Constants.USER_SERVICE, userService);

        ProductService productService = new ProductServiceImpl(dataSource);
        event.getServletContext().setAttribute(PRODUCT_SERVICE, productService);


        OrderService orderService = new OrderServiceImpl(dataSource);
        event.getServletContext().setAttribute(ORDER_SERVICE, orderService);


        event.getServletContext().setAttribute("dataSource", dataSource);

        StatusWriter statusWriter = new StatusWriter();
        statusWriter.write(dataSource);

    }

    @Override
    public void contextDestroyed(ServletContextEvent event) {
        System.out.println("---- destroying servlet context -----");
    }

    private Map<String, String> createMapErrors() {
        final Map<String, String> mapError = new HashMap<>();

        mapError.put(Constants.FIRST_NAME, Constants.NOT_VALID_FIRSTNAME);
        mapError.put(Constants.LAST_NAME, Constants.NOT_VALID_LASTNAME);
        mapError.put(Constants.EMAIL, Constants.NOT_VALID_EMAIL);
        mapError.put(Constants.PASSWORD, Constants.NOT_VALID_PASSWORD);
        mapError.put(Constants.CONFIRM_PASSWORD, Constants.NOT_VALID_CONFIRM_PASSWORD);
        mapError.put(Constants.CAPTCHA_STRING, Constants.NOT_VALID_CAPTCHA);
        mapError.put(Constants.CAPTCHA_STRING_EXPIRE, Constants.TIME_CAPTCHA_OUT);
        return mapError;
    }
}
