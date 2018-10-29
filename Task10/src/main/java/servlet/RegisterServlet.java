package servlet;

import constant.Constants;
import mapper.UserMapper;
import org.apache.commons.collections.MapUtils;
import service.impl.CaptchaServiceImpl;

import service.UserService;
import strategy.CaptchaStrategy;
import util.DownloaderAvatar;
import util.UtilRegister;
import util.Validators;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Predicate;

import static constant.Constants.*;
import static org.apache.commons.lang3.StringUtils.isEmpty;

@MultipartConfig
@WebServlet(REGISTER)

public class RegisterServlet extends HttpServlet {

    private UserService userService;
    private CaptchaServiceImpl captchaServiceImpl;
    private CaptchaStrategy captchaStrategy;
    private Map<String, String> errorsMap;
    private boolean status = false;

    @Override
    public void init() {
        this.captchaServiceImpl = (CaptchaServiceImpl) getServletContext().getAttribute("captchaServiceImpl");
        this.userService = (UserService) getServletContext().getAttribute("userService");
        this.captchaStrategy = (CaptchaStrategy) getServletContext().getAttribute("captchaStrategy");
        this.errorsMap = (Map<String, String>) getServletContext().getAttribute("errorsMap");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = captchaStrategy.getCaptcha(req, captchaServiceImpl).getUuid();

        Map<String, String> mapCurrentError = new HashMap<>();
        Map<String, String> mapAllParameter = createMapAllParameter(req);
        Map<String, Predicate<Map.Entry<String, String>>> predicateMap = createMapPredicates(req, mapAllParameter, id);
        Map<String, String> mapTrueField = new HashMap<>();


        for (Map.Entry<String, Predicate<Map.Entry<String, String>>> predicateEntry : predicateMap.entrySet()) {
            for (Map.Entry<String, String> requestEntry : mapAllParameter.entrySet()) {
                if (predicateEntry.getKey().equals(requestEntry.getKey())) {
                    if (predicateEntry.getValue().test(requestEntry)) {
                        mapCurrentError.put(predicateEntry.getKey(), errorsMap.get(predicateEntry.getKey()));
                    } else {
                        mapTrueField.put(predicateEntry.getKey(), mapAllParameter.get(predicateEntry.getKey()));
                    }
                }
            }
        }
        req.getSession().setAttribute(Constants.MAP_TRUE_FIELDS, mapTrueField);


        try {
            if (!Validators.isPresentLogin(userService, mapAllParameter)) {

                mapCurrentError.put(Constants.EMAIL, Constants.LOGIN_IS_PRESENT);
            }
        } catch (SQLException e) {
            req.getSession().setAttribute(Constants.MAP_ERRORS, mapCurrentError);
            e.printStackTrace();
        }
        if (MapUtils.isNotEmpty(mapCurrentError)) {
            status = false;
            req.getSession().setAttribute(Constants.MAP_ERRORS, mapCurrentError);
        } else {
            status = true;
            try {
                String imageName = getServletContext().getInitParameter("imagePath");
                String imagePath = DownloaderAvatar.upload(req, imageName);
                userService.addUser(new UserMapper().createUser(mapAllParameter, imagePath));
            } catch (SQLException e) {
                req.getSession().setAttribute(EXCEPTION_ATTRIBUT, EXCEPTION_400);
                e.printStackTrace();
            }
            mapAllParameter.forEach((k, v) -> req.removeAttribute(k));
            captchaServiceImpl.deleteNotValidCaptcha();
            req.getSession().setAttribute(Constants.REGISTER_SUCCESSFULL, Constants.REGISTER_SUCCESSFUL);
        }

        resp.sendRedirect(resp.encodeRedirectURL(REGISTER));
    }

    @Override
    protected void doGet(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {

        captchaStrategy.setCaptcha(captchaServiceImpl, httpServletRequest, httpServletResponse);
        Map<String, String> myAttr = (Map<String, String>) httpServletRequest.getSession().getAttribute(Constants.MAP_TRUE_FIELDS);
        Map<String, String> mapError = (Map<String, String>) httpServletRequest.getSession().getAttribute(Constants.MAP_ERRORS);

        if (myAttr != null || mapError != null) {
            UtilRegister.setAttr(myAttr, mapError, httpServletRequest);
            if (!status) {
                UtilRegister.removeAttr(myAttr, httpServletRequest);
            } else {
                String registerSuccessful = (String) httpServletRequest.getSession().getAttribute(Constants.REGISTER_SUCCESSFULL);
                httpServletRequest.setAttribute(Constants.REGISTER_SUCCESSFULL, registerSuccessful);
                httpServletRequest.getSession().removeAttribute(Constants.REGISTER_SUCCESSFULL);
            }
        }
        httpServletRequest.getRequestDispatcher(REGISTER_JSP).forward(httpServletRequest, httpServletResponse);

    }

    private Map<String, String> createMapAllParameter(HttpServletRequest req) {
        Map<String, String> mapAllParameter = new HashMap<>();
        mapAllParameter.put(Constants.FIRST_NAME, req.getParameter(Constants.FIRST_NAME));
        mapAllParameter.put(Constants.LAST_NAME, req.getParameter(Constants.LAST_NAME));
        mapAllParameter.put(Constants.EMAIL, req.getParameter(Constants.EMAIL));
        mapAllParameter.put(Constants.PASSWORD, req.getParameter(Constants.PASSWORD));
        mapAllParameter.put(Constants.CONFIRM_PASSWORD, req.getParameter(Constants.CONFIRM_PASSWORD));
        mapAllParameter.put(Constants.CAPTCHA_STRING, req.getParameter(Constants.CAPTCHA_STRING));
        mapAllParameter.put(Constants.CAPTCHA_STRING_EXPIRE, req.getParameter(Constants.CAPTCHA_STRING_EXPIRE));
        return mapAllParameter;
    }

    private Map<String, Predicate<Map.Entry<String, String>>> createMapPredicates(HttpServletRequest req, Map<String, String> mapAllParameter, String id) {
        Map<String, Predicate<Map.Entry<String, String>>> predicateMap = new HashMap<>();
        predicateMap.put(Constants.FIRST_NAME, e -> !UtilRegister.checkInputValue(e.getValue(), e.getKey()));
        predicateMap.put(Constants.LAST_NAME, e -> !UtilRegister.checkInputValue(e.getValue(), e.getKey()));
        predicateMap.put(Constants.EMAIL, e -> !UtilRegister.checkInputValue(e.getValue(), e.getKey()));
        predicateMap.put(Constants.PASSWORD, e -> !UtilRegister.checkInputValue(e.getValue(), e.getKey()));
        predicateMap.put(Constants.CONFIRM_PASSWORD, e -> (isEmpty(mapAllParameter.get(Constants.PASSWORD)) || !e.getValue().equals(mapAllParameter.get(Constants.PASSWORD))));
        predicateMap.put(Constants.CAPTCHA_STRING, e -> (!e.getValue().equals(captchaServiceImpl.findByKey(id).getValue())));
        predicateMap.put(Constants.CAPTCHA_STRING_EXPIRE, e -> (captchaServiceImpl.findByKey(id).getValue() == null || captchaServiceImpl.findByKey(id) == null));

        return predicateMap;
    }
}