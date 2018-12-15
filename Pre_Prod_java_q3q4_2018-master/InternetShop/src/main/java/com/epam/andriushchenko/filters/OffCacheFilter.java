package com.epam.andriushchenko.filters;

import com.epam.andriushchenko.cache.HttpCacheHeader;

import javax.servlet.*;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class OffCacheFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletResponse httpServletResponse = (HttpServletResponse) servletResponse;

        httpServletResponse.setHeader(HttpCacheHeader.CACHE_CONTROL.getName(), "no-cache, no-store");
        httpServletResponse.setDateHeader(HttpCacheHeader.EXPIRES.getName(), 0L);

        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {

    }
}
