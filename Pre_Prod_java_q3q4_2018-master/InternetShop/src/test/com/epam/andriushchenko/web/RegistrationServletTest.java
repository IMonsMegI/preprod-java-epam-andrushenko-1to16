package com.epam.andriushchenko.web;

import com.epam.andriushchenko.db.DBManager;
import com.epam.andriushchenko.db.TransactionManager;
import com.epam.andriushchenko.entities.User;
import com.epam.andriushchenko.services.UsersService;
import org.junit.Before;
import org.junit.jupiter.api.Test;

import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class RegistrationServletTest {
    private static HttpServletRequest request;
    private static HttpServletResponse response;
    private static RegistrationServlet servlet;
    private static final String NAME = "name";
    private static final String SURNAME = "surname";
    private static final String LOGIN = "login";
    private static final String EMAIL = "email";
    private static final String PASSWORD = "password1";

    @Before
    public void init() throws NamingException {
        request = mock(HttpServletRequest.class);
        response = mock(HttpServletResponse.class);

        when(request.getParameter("name")).thenReturn("Michael");
        when(request.getParameter("surname")).thenReturn("Andr");
        when(request.getParameter("login")).thenReturn("micha");
        when(request.getParameter("email")).thenReturn("micha@gmail.com");
        when(request.getParameter("password1")).thenReturn("qwerty");

        String name = request.getParameter(NAME);
        String surname = request.getParameter(SURNAME);
        String login = request.getParameter(LOGIN);
        String email = request.getParameter(EMAIL);
        String password1 = request.getParameter(PASSWORD);

        HttpSession session = mock(HttpSession.class);
        when(request.getSession()).thenReturn(session);
        final ServletContext servletContext = mock(ServletContext.class);
        RequestDispatcher dispatcher = mock(RequestDispatcher.class);
        when(servletContext.getRequestDispatcher("/registration.jsp")).thenReturn(dispatcher);
        UsersService usersService = new UsersService(new DBManager(),new TransactionManager(new DBManager()));
        User user = new User(name, surname, login, email, password1,"");
        usersService.addUser(user);
        session.setAttribute("user", user);
    }

    @Test
    public void testDoPostPositive() throws ServletException, IOException {
        assertThrows(NullPointerException.class, () -> servlet.doPost(null, null));
    }

    @Test
    public void testDoPostNegative() throws ServletException, IOException {
        boolean throwsException = false;
        try {
            servlet.doPost(request, response);
        } catch (Exception e) {
            throwsException = true;
        }
        assertFalse(throwsException);
    }
}