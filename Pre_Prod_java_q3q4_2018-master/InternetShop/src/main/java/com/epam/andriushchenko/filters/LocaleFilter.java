package com.epam.andriushchenko.filters;

import com.epam.andriushchenko.localization.CookieSaver;
import com.epam.andriushchenko.localization.SaveStrategy;
import com.epam.andriushchenko.localization.SessionSaver;

import javax.servlet.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.*;

public class LocaleFilter implements Filter {
    private SaveStrategy saveStrategy;
    private String currentLocale;
    private List<String> applicationLocales;

    @Override
    public void init(FilterConfig filterConfig) {
        String locales = filterConfig.getServletContext().getInitParameter("applicationLocales");
        applicationLocales = stringToList(locales);
        initSaveStrategy(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse resp = (HttpServletResponse) servletResponse;

        setUpCurrentLocale(req);

        saveStrategy.save(currentLocale, req, resp);
        req.setAttribute("lang", currentLocale);
        req.setAttribute("applicationLocales", applicationLocales);

        loadPropertyFile(req.getServletContext(), currentLocale);

        filterChain.doFilter(req, resp);
    }

    @Override
    public void destroy() {

    }

    private List<String> stringToList(String initParameter) {
        if (initParameter.isEmpty())
            return new ArrayList<>();
        return Arrays.asList(initParameter.split(" "));
    }

    private void initSaveStrategy(FilterConfig filterConfig) {
        String savingPlace = filterConfig.getInitParameter("placeOfSavingLocale");
        if ("session".equals(savingPlace)) {
            saveStrategy = new SessionSaver();
        }
        if ("cookie".equals(savingPlace)) {
            saveStrategy = new CookieSaver();
        }
    }

    private String getAcceptedLocale(HttpServletRequest request) {
        List<Locale> browseLocales = Collections.list(request.getLocales());
        return browseLocales.stream()
                .flatMap(x -> applicationLocales.stream().filter(i -> x.toString().equals(i)))
                .findFirst().orElse(null);
    }

    private void loadPropertyFile(ServletContext servletContext, String currentLocaleStr) {
        ResourceBundle resourceBundle = ResourceBundle.getBundle("resources", new Locale(currentLocaleStr));
        servletContext.setAttribute("resourceBundle", resourceBundle);
    }

    private void setUpCurrentLocale(HttpServletRequest req) {
        HttpSession session = req.getSession();
        Cookie[] cookies = req.getCookies();
        if (req.getParameter("lang") != null) {
            currentLocale = req.getParameter("lang");
        }
        if (currentLocale == null && session.getAttribute("locale") != null) {
            currentLocale = (String) session.getAttribute("locale");
        }
        if (currentLocale == null) {
            for (Cookie cookie : cookies) {
                if ("locale".equals(cookie.getName())) {
                    currentLocale = cookie.getValue();
                }
            }
        }
        if (currentLocale == null) {
            currentLocale = getAcceptedLocale(req);
        }
    }
}
