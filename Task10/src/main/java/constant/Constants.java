package constant;

import util.Basket;

public class Constants {

    public static final String COOCIE_STRATEGY = "cookie";
    public static final String SESSION_STRATEGY = "session";
    public static final String HIDDEN_STRATEGY = "hidden";

    public static final String TIME_CAPTCHA_OUT = "time of captcha is out, enter new data";

    public static final String NOT_VALID_FIRSTNAME = "First Name is not valid, should contains just letters";
    public static final String NOT_VALID_LASTNAME = "Lats Name is not valid, should contains just letters";
    public static final String NOT_VALID_EMAIL = "Email is not valid, should be *****@**.**";
    public static final String NOT_VALID_PASSWORD = "Password should contain letters and at least one digit";
    public static final String NOT_VALID_CONFIRM_PASSWORD = "Verify password doesn't match password";
    public static final String NOT_VALID_CAPTCHA = "value of captcha is not valid";

    public static final String LOGIN_IS_PRESENT = "login is present,let`s go to 'login' ";
    public static final String REGISTER_SUCCESSFUL = "registration was successful";

    public static final String FIRST_NAME = "firstName";
    public static final String LAST_NAME = "lastName";
    public static final String EMAIL = "email";
    public static final String CARD_VALUE = "cardValue";
    public static final String VARIANT_PAYMENT = "variantPayment";

    public static final String EMAIL_LOG = "emailLog";
    public static final String PASSWORD = "password";
    public static final String PASSWORD_LOG = "passwordLog";
    public static final String AVATAR = "avatar";

    public static final String CONFIRM_PASSWORD = "confirmPassword";
    public static final String CAPTCHA_STRING = "captchaString";
    public static final String CAPTCHA_STRING_EXPIRE= "captchaStringExpireTime";
    public static final String MAP_ERRORS= "mapError";
    public static final String MAP_TRUE_FIELDS= "mapTrueField";
    public static final String USER_SERVICE= "userService";

    public static final String CAPTCHA_STRATEGY= "captchaStrategy";
    public static final String CAPTCHA_SERVICE= "captchaServiceImpl";
    public static final String REGISTER_SUCCESSFULL= "registerSuccessful";
    public static final String TIME_CAPTCHA= "timeLeaveCaptcha";


    public static final String TAG_CAPTCHA_ID= "id_captcha";

    public static final String LOGIN_ERR_MESS = "error_login";

    public static final String LOGIN_JSP = "/login";

    //servlet
    public static final String AVATAR_SERVLET = "/avatar";
    public static final String CAPTCHA_SERVLET = "/captcha";
    public static final String LOGIN_SERVLET = "/login";
    public static final String INDEX_JSP = "index.jsp";
    public static final String REGISTER = "/register";
    public static final String REGISTER_JSP = "/register.jsp";
    public static final String EXCEPTION = "exception";
    public static final String TEXT_PLAIN = "text/plain";


    public static final String EXCEPTION_ATTRIBUT = "exception";
    public static final String EXCEPTION_500 = "500 Internal Server Error";
    public static final String EXCEPTION_400 = "400 Bad Request";

//products

    public static final String PRODUCT_SERVLET = "/product";
    public static final String BASKET_SERVLET_ADD = "/basketAdd";
    public static final String BASKET_SERVLET = "/basket";
    public static final String BASKET_SERVLET_MINUS = "/basketMinus";
    public static final String BASKET_SERVLET_PLUS = "/basketPlus";
    public static final String BASKET_SERVLET_REMOVE = "/basketRemove";
    public static final String BASKET_SERVLET_CLEAR = "/basketClear";
    public static final String BASCET_JSP = "/basket.jsp";
    public static final String PRODUCT_JSP = "/product_page.jsp";
    public static final String PRODUCT_FIRM = "firm";
    public static final String PRODUCT_MODEL = "model";
    public static final String PRODUCT_PURPOSE = "purpose";
    public static final String PRODUCT_CATEGORY = "category";
    public static final String PRODUCT_PRICE = "price";
    public static final String PRODUCT_PRICE_FROM = "priceFrom";
    public static final String PRODUCT_PRICE_TO = "priceTo";
    public static final String PRODUCT_ENUMERATION = "enumeration";
    public static final String PRODUCT_PICTURE = "picture";

    public static final String PRODUCT_SERVICE = "productService";
    public static final String ORDER_SERVICE = "orderService";
    public static final String PRODUCT_LIST_EMPTY = "products do not found";


    public static final String PRODUCT_TABLE_NAME = "products";


    public static final String PRODUCT_SORT_BY_NAME = "firm21";
    public static final String PRODUCT_SORT_BY_PRICE = "price";
    public static final String PRODUCT_AMOUNT_ON_PAGE = "amountOnPage";


    public static final String PRODUCT_CURRENT_PAGE = "page";
    public static final String PRODUCT_LIMIT_ON_PAGE = "limit";
    public static final String PRODUCT_OFFSET = "offset";
    public static final String PRODUCT_LIST = "listProduct";
    public static final String PRODUCT_EMPTY_LIST = "emptyList";
    public static final String PRODUCT_COUNT_PAGES = "countPage";

    // basket
    public static final String BASKET_SERVICE = "basketService";

    // info
    public static final String INFO_ACCEPTED = "basketService";
    public static final String INFO_CONFIRMED = "basketService";

    public static final String MINUS = "minus";
    public static final String PLUS = "plus";
    public static final String ADD = "add";
    public static final String ID = "id";
    public static final String CLEAN_BASKET = "cleanBasket";
    public static final String DELETE = "del";


    public static final String BASKET = "basket";

}
