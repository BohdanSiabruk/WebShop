package servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static constant.Constants.EXCEPTION_500;

@WebServlet("/exception")
public class ExceptionServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getSession().getAttribute("exception") == null){
            req.getSession().setAttribute("exception",EXCEPTION_500);
        }

       req.getRequestDispatcher("exception.jsp").forward(req, resp);
    }


}
