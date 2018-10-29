package servlet;

import entity.Captcha;
import service.impl.CaptchaServiceImpl;
import strategy.CaptchaStrategy;

import javax.imageio.ImageIO;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

import static constant.Constants.*;


@WebServlet(CAPTCHA_SERVLET)
public class CaptchaServlet extends HttpServlet {

    private CaptchaStrategy captchaStrategy;
    private ServletContext servletContext;
    private CaptchaServiceImpl captchaServiceImpl;

    @Override
    public void init() throws ServletException {

        this.servletContext = this.getServletContext();
        this.captchaStrategy = (CaptchaStrategy) servletContext.getAttribute(CAPTCHA_STRATEGY);
        this.captchaServiceImpl = (CaptchaServiceImpl) servletContext.getAttribute(CAPTCHA_SERVICE);
    }

    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws IOException {

        response.setContentType("image/png");
        OutputStream os = response.getOutputStream();
        Captcha captcha = captchaStrategy.getCaptcha(request, captchaServiceImpl);

        Timer timer = new Timer(true);
        int minutes = Integer.parseInt(servletContext.getInitParameter(TIME_CAPTCHA));

        timer.schedule(new ScheduleTask(captcha), TimeUnit.SECONDS.toMillis(minutes));
        ImageIO.write(captcha.getBufferedImage(), "png", os);
    }

    private class ScheduleTask extends TimerTask {
        private Captcha captcha;

        ScheduleTask(Captcha captcha) {
            this.captcha = captcha;
        }

        @Override
        public void run() {
            captcha.cleanValue();
        }
    }
}
