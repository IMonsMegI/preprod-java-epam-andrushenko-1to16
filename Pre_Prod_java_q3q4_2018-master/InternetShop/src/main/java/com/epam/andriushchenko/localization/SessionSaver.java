package com.epam.andriushchenko.localization;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SessionSaver implements SaveStrategy {

    @Override
    public void save(String locale, HttpServletRequest req, HttpServletResponse resp) {
        HttpSession session = req.getSession();
        session.setAttribute("locale", locale);
    }
}
