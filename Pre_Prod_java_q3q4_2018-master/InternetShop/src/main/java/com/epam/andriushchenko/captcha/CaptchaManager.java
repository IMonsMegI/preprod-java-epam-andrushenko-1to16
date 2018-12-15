package com.epam.andriushchenko.captcha;

import cn.apiclub.captcha.Captcha;
import cn.apiclub.captcha.backgrounds.GradiatedBackgroundProducer;

import javax.servlet.ServletContext;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CaptchaManager {
    private static final String SESSION = "session";
    private static final String CONTEXT_COOKIE = "context-cookie";
    private static final String CONTEXT_HIDDEN = "context-hidden";

    public Captcha paintCaptcha() {
        int WIDTH = 150;
        int HEIGHT = 80;

        return new Captcha.Builder(WIDTH, HEIGHT)
                .addText()
                .addBackground(new GradiatedBackgroundProducer())
                .addNoise()
                .build();
    }

    public String getCaptchaId(HttpServletRequest req) {
        ServletContext servletContext = req.getServletContext();
        String placeOfSavingCaptcha = servletContext.getInitParameter("placeOfCaptchaIdSaving");
        if (SESSION.equals(placeOfSavingCaptcha)) {
            return (String) req.getSession().getAttribute("captchaId");
        }
        if (CONTEXT_HIDDEN.equals(placeOfSavingCaptcha)) {
            return (String) req.getAttribute("captchaId");
        }
        if (CONTEXT_COOKIE.equals(placeOfSavingCaptcha)) {
            for (Cookie cookie : req.getCookies()) {
                if ("captchaId".equals(cookie.getName())) {
                    return cookie.getValue();
                }
            }
        }
        return "";
    }

    public void saveCaptchaId(String captchaId, HttpServletRequest req, HttpServletResponse resp) {
        ServletContext servletContext = req.getServletContext();
        String placeOfSavingCaptcha = servletContext.getInitParameter("placeOfCaptchaIdSaving");
        if (SESSION.equals(placeOfSavingCaptcha)) {
            req.getSession().setAttribute("captchaId", captchaId);
        }
        if (CONTEXT_COOKIE.equals(placeOfSavingCaptcha)) {
            Cookie cookie = new Cookie("captchaId", captchaId);
            resp.addCookie(cookie);
        }
        if (CONTEXT_HIDDEN.equals(placeOfSavingCaptcha)) {
            req.setAttribute("captchaId", captchaId);
        }
    }
}

