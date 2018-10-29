package service;

import entity.Captcha;

import java.util.Map;


public interface CaptchaService {

    void addCaptcha(Captcha captcha);

    boolean isPresentCaptcha(String uuid);

    Captcha findByKey(String uuid);

    Map<String, Captcha> findAll();

    void deleteCaptcha(String uuid);

    void deleteNotValidCaptcha();

}
