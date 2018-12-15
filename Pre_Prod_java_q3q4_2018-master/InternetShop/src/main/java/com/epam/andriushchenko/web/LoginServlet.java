package com.epam.andriushchenko.web;

import com.epam.andriushchenko.entities.dto.UserDTO;
import com.epam.andriushchenko.entities.users.User;
import com.epam.andriushchenko.services.UsersService;
import com.epam.andriushchenko.util.Path;
import com.epam.andriushchenko.util.UserInputValidator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Map;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    private UsersService usersService;


    @Override
    public void init() throws ServletException {
        usersService = (UsersService) getServletContext().getAttribute("usersService");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login");
        String password = req.getParameter("password");

        UserDTO userDTO = new UserDTO(login, password);
        Map<String, String> errors = new UserInputValidator().validateLoginInput(userDTO, req);

        if (errors.isEmpty()) {
            User user = null;
            try {
                user = usersService.findUserByLogin(login);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            req.getSession().setAttribute("user", user);
            req.getRequestDispatcher(Path.MAIN_PAGE).forward(req, resp);
        } else {
            req.setAttribute("errors", errors);
            req.getRequestDispatcher(Path.MAIN_PAGE).forward(req, resp);
        }
    }
}
