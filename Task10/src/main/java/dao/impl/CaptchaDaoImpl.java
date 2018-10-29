package dao.impl;

import dao.CaptchaDao;
import entity.Captcha;

import java.util.HashMap;
import java.util.Map;


public class CaptchaDaoImpl implements CaptchaDao {

    private final Map<String, Captcha> mapCaptcha = new HashMap<>();

    @Override
    public Map<String, Captcha> findAll() {
        Map<String, Captcha> copyMapCaptcha = new HashMap<>(mapCaptcha);
        return copyMapCaptcha;
    }

    @Override
    public void addCaptcha(Captcha captcha) {
        mapCaptcha.put(captcha.getUuid(), captcha);
            }

    @Override
    public boolean isPresentCaptcha(String key) {

        return mapCaptcha.entrySet().stream().anyMatch(e -> e.getKey().equals(key));
    }

    @Override
    public Captcha findByKey(String uuid) {
        return mapCaptcha.get(uuid);
    }

    @Override
    public void deleteCaptcha(String uuid ) {
        mapCaptcha.remove(uuid);
    }
}
