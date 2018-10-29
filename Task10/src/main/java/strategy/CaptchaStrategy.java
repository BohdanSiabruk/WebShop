package strategy;


import entity.Captcha;
import service.impl.CaptchaServiceImpl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface CaptchaStrategy {
    Captcha getCaptcha(HttpServletRequest request, CaptchaServiceImpl captchaServiceImpl);

    void setCaptcha(CaptchaServiceImpl captchaServiceImpl, HttpServletRequest request, HttpServletResponse response);
}
