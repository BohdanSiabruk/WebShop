package servlet;

import service.UserService;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.SQLException;

import static constant.Constants.*;

@WebServlet(AVATAR_SERVLET)
public class AvatarServlet extends HttpServlet {

    private UserService userService;
    @Override
    public void init() throws ServletException {
        this.userService = (UserService) getServletContext().getAttribute(USER_SERVICE);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws  IOException {

        resp.setContentType("image/png");
        String imageName = null;
        try {
            imageName = getServletContext().getInitParameter("imagePath") +
                    userService.findByEmail(req.getParameter(EMAIL)).getAvatar();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try (
                ServletOutputStream out = resp.getOutputStream();
                FileInputStream inputStream = new FileInputStream(imageName);
                BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
                BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(out)
        ) {
            int ch;
            while ((ch = bufferedInputStream.read()) != -1) {
                bufferedOutputStream.write(ch);
            }
        }
    }
}
