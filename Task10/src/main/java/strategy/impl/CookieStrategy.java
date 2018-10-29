package strategy.impl;

import constant.Constants;
import entity.Captcha;
import service.impl.CaptchaServiceImpl;
import strategy.CaptchaStrategy;
import util.GenerateCaptcha;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CookieStrategy implements CaptchaStrategy {

    @Override
    public Captcha getCaptcha(HttpServletRequest request, CaptchaServiceImpl captchaServiceImpl) {
        Cookie[] cookies = request.getCookies();
        captchaServiceImpl.deleteNotValidCaptcha();
        return getCaptchaFrom(cookies, captchaServiceImpl);
    }

    @Override
    public void setCaptcha(CaptchaServiceImpl captchaServiceImpl, HttpServletRequest request, HttpServletResponse response) {
        Captcha captcha = GenerateCaptcha.generateCaptcha();
        captchaServiceImpl.addCaptcha(captcha);
        Cookie cookie = new Cookie(Constants.TAG_CAPTCHA_ID, captcha.getUuid());
        response.addCookie(cookie);

    }
    private Captcha getCaptchaFrom(Cookie[] cookies, CaptchaServiceImpl captchaServiceImpl) {
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals(Constants.TAG_CAPTCHA_ID)) {
                return captchaServiceImpl.findByKey(cookie.getValue());
            }
        }
        return null;
    }
}
