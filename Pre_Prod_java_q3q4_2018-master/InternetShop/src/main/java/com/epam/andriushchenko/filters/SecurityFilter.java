package com.epam.andriushchenko.filters;

import com.epam.andriushchenko.entities.users.User;
import com.epam.andriushchenko.entities.users.UserRole;
import com.epam.andriushchenko.security.Constraint;
import com.epam.andriushchenko.security.Security;
import com.epam.andriushchenko.util.Path;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class SecurityFilter implements Filter {
    private List<String> userLinks;
    private List<String> adminLinks;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        try {
            unMarshalingSecurity();
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse resp = (HttpServletResponse) servletResponse;
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("user");
        String uri = req.getRequestURI();

        if (!userLinks.contains(uri) && !adminLinks.contains(uri)) {
            filterChain.doFilter(req, resp);
        } else {
            if (user == null) {
                req.getRequestDispatcher(Path.LOGIN_PAGE).forward(req, resp);
            } else {
                if ((user.getUserRole() == UserRole.USER && !userLinks.contains(uri))
                        || (user.getUserRole() == UserRole.ADMIN && !adminLinks.contains(uri))) {
                    filterChain.doFilter(req, resp);
                } else {
                    req.setAttribute("statusCode", 403);
                    req.setAttribute("message", "Not enough access permissions.");
                    req.getRequestDispatcher(Path.ERROR_PAGE).forward(req, resp);
                }
            }
        }
    }

    @Override
    public void destroy() {

    }

    private void unMarshalingSecurity() throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(Security.class);
        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
        Security security = (Security) jaxbUnmarshaller.unmarshal(new File("src/main/webapp/security.xml"));
        for (Constraint constraint : security.getConstraintList()) {
            if ("user".equals(constraint.getRole())) {
                userLinks = constraint.getAvailableURLs();
            }
            if ("admin".equals(constraint.getRole())) {
                adminLinks = constraint.getAvailableURLs();
            }
        }
    }
}
