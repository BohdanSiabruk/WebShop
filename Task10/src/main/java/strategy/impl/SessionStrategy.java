package strategy.impl;

import entity.Captcha;
import service.impl.CaptchaServiceImpl;
import strategy.CaptchaStrategy;
import util.GenerateCaptcha;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static constant.Constants.TAG_CAPTCHA_ID;

public class SessionStrategy implements CaptchaStrategy {

    @Override
    public Captcha getCaptcha(HttpServletRequest request, CaptchaServiceImpl captchaServiceImpl) {
        String uuid = (String) request.getSession().getAttribute(TAG_CAPTCHA_ID);
        return captchaServiceImpl.findByKey(uuid);
    }


    @Override
    public void setCaptcha(CaptchaServiceImpl captchaServiceImpl, HttpServletRequest request, HttpServletResponse response) {
        Captcha captcha = GenerateCaptcha.generateCaptcha();
        captchaServiceImpl.addCaptcha(captcha);
        request.getSession().setAttribute(TAG_CAPTCHA_ID, captcha.getUuid());
    }
}
