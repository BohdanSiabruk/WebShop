package locale;


import javax.servlet.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;

import static java.util.Objects.nonNull;

public class LocaleFilter implements Filter {
    private String localizationType;
    private Integer cookieMaxAge;
    private List<String> localeList;
    private String defaultLanguage;

    @Override
    public void init(FilterConfig filterConfig) {

        defaultLanguage = filterConfig.getInitParameter("defaultLanguage");
        localizationType = filterConfig.getServletContext().getInitParameter("localeType");
        cookieMaxAge = Integer.valueOf(filterConfig.getServletContext().getInitParameter("localeCookieMaxAge"));

        localeList = new ArrayList<>();
        String locale = filterConfig.getInitParameter("availableLanguage");
        String[] locales = locale.split(",");
        for (String localeName : locales) {
            ResourceBundle.getBundle("loc", new Locale(localeName));
            localeList.add(localeName);
        }
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        HttpServletRequestWrapper requestWrapper = new HttpServletRequestWrapper(request) {

            @Override
            public Locale getLocale() {
                return localeHandle(request, response);
            }
        };
        filterChain.doFilter(requestWrapper, response);
    }

    private Locale localeHandle(HttpServletRequest req, HttpServletResponse resp) {

         if (nonNull(req.getParameter("language"))) {
            return setLocaleByParam(req, resp);
        } else if (nonNull(req.getSession().getAttribute("language"))) {
            return new Locale((String) req.getSession().getAttribute("language"));
        } else if (nonNull(req.getCookies())) {
            for (Cookie cookie : req.getCookies()) {
                if (cookie.getName().equals("language")) {
                    return new Locale(cookie.getValue());
                }
            }
        }
        return setAvailableLocale(req, resp);
    }

    // from browser
    private Locale setAvailableLocale(HttpServletRequest req, HttpServletResponse resp) {
        Enumeration<Locale> locales = req.getLocales();
        while (locales.hasMoreElements()) {
            Locale locale = locales.nextElement();
            if (localeList.contains(locale.toString())) {
                if (localizationType.equals("session")) {
                    req.getSession().setAttribute("language", locale);
                } else if (localizationType.equals("cookie")) {
                    Cookie cookie = new Cookie("language", locale.toString());
                    cookie.setMaxAge(cookieMaxAge);
                    resp.addCookie(cookie);
                }
                return locale;
            } else  if (!locales.hasMoreElements() && !localeList.contains(locale.toString())){
                return setDefaultLocale(req, resp);
            }
        }
        return null;
    }

    // from jsp
    private Locale setLocaleByParam(HttpServletRequest req, HttpServletResponse resp) {
        if (localizationType.equals("session")) {
            req.getSession().setAttribute("language", req.getParameter("language"));
        } else if (localizationType.equals("cookie")) {
            Cookie cookie = new Cookie("language", req.getParameter("language"));
            cookie.setMaxAge(cookieMaxAge);
            cookie.setValue(req.getParameter("language"));
            resp.addCookie(cookie);
        }
        return new Locale(req.getParameter("language"));
    }

    private Locale setDefaultLocale(HttpServletRequest req, HttpServletResponse resp){
        if (localizationType.equals("session")){
            req.getSession().setAttribute("language", defaultLanguage);
            return new Locale((String) req.getSession().getAttribute("language"));
        } else if (localizationType.equals("cookie")){
            Cookie cookie = new Cookie("language", defaultLanguage);
            cookie.setMaxAge(cookieMaxAge);
            resp.addCookie(cookie);
            return new Locale(cookie.getValue());
        }
        return null;
    }
    @Override
    public void destroy() {

    }
}
