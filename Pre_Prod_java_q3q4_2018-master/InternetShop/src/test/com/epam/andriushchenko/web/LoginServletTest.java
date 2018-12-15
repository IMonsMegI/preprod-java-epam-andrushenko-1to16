package com.epam.andriushchenko.web;

import com.epam.andriushchenko.entities.User;
import com.epam.andriushchenko.services.UsersService;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

import static org.mockito.Mockito.*;

public class LoginServletTest {
    private static final String USER = "user";

    private ServletContext servletContext = mock(ServletContext.class);
    private UsersService usersService = mock(UsersService.class);
    private HttpServletRequest httpServletRequest = mock(HttpServletRequest.class);
    private HttpServletResponse httpServletResponse = mock(HttpServletResponse.class);
    private HttpSession session = mock(HttpSession.class);

    private User user;

    private LoginServlet loginServlet = new LoginServlet();


    @BeforeEach
    void init() throws SQLException, ServletException {
        user = new User("Michael", "Andr", "Micha", "micha@gmail.com", "qwerty", "");
        when(httpServletRequest.getServletContext()).thenReturn(servletContext);
        when(servletContext.getAttribute("usersService")).thenReturn(usersService);
        when(httpServletRequest.getSession()).thenReturn(session);
        when(session.getAttribute(USER)).thenReturn(user);
        when(usersService.findUserByLogin("Micha")).thenReturn(user);
        loginServlet.init();
    }

    @Test
    public void shouldPutUserToSessionWhenLogin() throws ServletException, IOException {
        when(httpServletRequest.getAttribute("login")).thenReturn("Micha");
        when(httpServletRequest.getAttribute("password")).thenReturn("qwerty");

        loginServlet.doPost(httpServletRequest, httpServletResponse);

        verify(session).setAttribute("user", user);
    }
}