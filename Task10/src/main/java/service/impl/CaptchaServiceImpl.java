package service.impl;

import dao.CaptchaDao;
import entity.Captcha;
import service.CaptchaService;

import java.util.*;

public class CaptchaServiceImpl implements CaptchaService {
    CaptchaDao captchaDao;

    public CaptchaServiceImpl(CaptchaDao captchaDao) {
        this.captchaDao = captchaDao;
    }

    @Override
    public void addCaptcha(Captcha captcha) {
        captchaDao.addCaptcha(captcha);
    }
    @Override
    public boolean isPresentCaptcha(String uuid) {
        return captchaDao.isPresentCaptcha(uuid);
    }

    @Override
    public Captcha findByKey(String uuid) {
        return captchaDao.findByKey(uuid);
    }

    @Override
    public Map<String, Captcha> findAll() {
        return captchaDao.findAll();
    }
    @Override
    public void deleteCaptcha(String uuid) {
        captchaDao.deleteCaptcha(uuid);
    }

    @Override
    public void deleteNotValidCaptcha() {
            findAll().entrySet().stream().filter(e ->
                    e.getValue().getValue().equals("")).forEach(e -> captchaDao.deleteCaptcha(e.getKey()));
    }
}
