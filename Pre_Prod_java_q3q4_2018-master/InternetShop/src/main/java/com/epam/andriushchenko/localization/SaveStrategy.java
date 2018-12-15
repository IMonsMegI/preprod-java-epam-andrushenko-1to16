package com.epam.andriushchenko.localization;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface SaveStrategy {
    void save(String locale, HttpServletRequest req, HttpServletResponse resp);
}
