package com.epam.andriushchenko.web;

import cn.apiclub.captcha.Captcha;
import com.epam.andriushchenko.captcha.CaptchaManager;
import com.epam.andriushchenko.captcha.CaptchaTimeController;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/captcha-image")
public class CaptchaServlet extends HttpServlet {
    private String sImgType = null;

    public void init() throws ServletException {
        sImgType = getServletContext().getInitParameter("ImageType");
        sImgType = sImgType == null ? "png" : sImgType.trim().toLowerCase();
        if (!sImgType.equalsIgnoreCase("png") && !sImgType.equalsIgnoreCase("jpg") &&
                !sImgType.equalsIgnoreCase("jpeg")) {
            sImgType = "png";
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ByteArrayOutputStream imgOutputStream = new ByteArrayOutputStream();
        byte[] captchaBytes;
        Map<String, CaptchaTimeController> captchaContainer = new HashMap<>();

        Captcha captcha = new CaptchaManager().paintCaptcha();

        ImageIO.write(captcha.getImage(), sImgType, imgOutputStream);
        captchaBytes = imgOutputStream.toByteArray();

        resp.setHeader("Cache-Control", "no-store");
        resp.setHeader("Pragma", "no-cache");
        resp.setDateHeader("Expires", 0);
        resp.setContentType("image/" + (sImgType.equalsIgnoreCase("png") ? "png" : "jpeg"));

        String sessionId = req.getSession().getId();
        captchaContainer.put(sessionId, new CaptchaTimeController());
        getServletContext().setAttribute("captchaContainer", captchaContainer);
        req.getSession().setAttribute("captcha", captcha);
        new CaptchaManager().saveCaptchaId(sessionId, req, resp);

        ServletOutputStream outStream = resp.getOutputStream();
        outStream.write(captchaBytes);
        outStream.flush();
        outStream.close();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
