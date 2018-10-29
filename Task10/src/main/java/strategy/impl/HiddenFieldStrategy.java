package strategy.impl;

import entity.Captcha;
import service.impl.CaptchaServiceImpl;
import strategy.CaptchaStrategy;
import util.GenerateCaptcha;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static constant.Constants.TAG_CAPTCHA_ID;


public class HiddenFieldStrategy implements CaptchaStrategy {

    @Override
    public Captcha getCaptcha(HttpServletRequest request, CaptchaServiceImpl captchaServiceImpl) {
        String captchaId = (String) request.getServletContext().getAttribute(TAG_CAPTCHA_ID);
        captchaServiceImpl.deleteNotValidCaptcha();
        return captchaServiceImpl.findByKey(captchaId);

    }

    @Override
    public void setCaptcha(CaptchaServiceImpl captchaServiceImpl, HttpServletRequest request, HttpServletResponse response) {
        Captcha captcha = GenerateCaptcha.generateCaptcha();
        request.getServletContext().setAttribute(TAG_CAPTCHA_ID, captcha.getUuid());
        captchaServiceImpl.addCaptcha(captcha);
    }

}
