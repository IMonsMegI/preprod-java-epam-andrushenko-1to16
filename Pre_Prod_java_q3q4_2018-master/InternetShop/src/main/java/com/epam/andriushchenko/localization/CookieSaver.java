package com.epam.andriushchenko.localization;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CookieSaver implements SaveStrategy {

    @Override
    public void save(String locale, HttpServletRequest req, HttpServletResponse resp) {
        String cookieMaxAge = req.getServletContext().getInitParameter("savingCookieTime");
        Cookie cookie = new Cookie("locale", locale);
        cookie.setMaxAge(Integer.parseInt(cookieMaxAge));
        resp.addCookie(cookie);
    }
}
