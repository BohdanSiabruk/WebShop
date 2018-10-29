package dao;

import entity.Captcha;

import java.util.Map;

public interface CaptchaDao {

    Map<String, Captcha> findAll();

    void addCaptcha(Captcha captcha);

    boolean isPresentCaptcha(String uuid);

    Captcha findByKey(String uuid);

    void deleteCaptcha(String uuid);

}
