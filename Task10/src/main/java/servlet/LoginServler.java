package servlet;

import entity.User;
import service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

import static constant.Constants.*;
import static util.Validators.isPresentUser;

@WebServlet(LOGIN_SERVLET)
public class LoginServler extends HttpServlet {

    UserService userService;

    @Override
    public void init()  {
        this.userService = (UserService) getServletContext().getAttribute(USER_SERVICE);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws  IOException {

        String email = req.getParameter(EMAIL_LOG);
        String password = req.getParameter(PASSWORD_LOG);
        User user = null;

        try {
            user = userService.findByEmail(email);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (isPresentUser(user, password)) {
            req.getSession().setAttribute(EMAIL, email);
            req.getSession().setAttribute(FIRST_NAME, user.getFirstName());

        } else {
            req.getSession().setAttribute(LOGIN_ERR_MESS, "Incorrect data");
        }
        resp.sendRedirect(LOGIN_JSP);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getSession().removeAttribute(LOGIN_ERR_MESS);
        req.getRequestDispatcher(INDEX_JSP).forward(req, resp);
    }
}
