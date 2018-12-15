package com.epam.andriushchenko.web;

import cn.apiclub.captcha.Captcha;
import com.epam.andriushchenko.entities.dto.UserDTO;
import com.epam.andriushchenko.entities.users.User;
import com.epam.andriushchenko.entities.users.UserRole;
import com.epam.andriushchenko.services.UsersService;
import com.epam.andriushchenko.util.Path;
import com.epam.andriushchenko.util.UserInputValidator;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Map;

@WebServlet("/registration")
@MultipartConfig
public class RegistrationServlet extends HttpServlet {
    private UsersService usersService;

    @Override
    public void init() throws ServletException {
        usersService = (UsersService) getServletContext().getAttribute("usersService");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        req.setAttribute("name", session.getAttribute("name"));
        req.setAttribute("surname", session.getAttribute("surname"));
        req.setAttribute("login", session.getAttribute("login"));
        req.setAttribute("email", session.getAttribute("email"));
        session.removeAttribute("name");
        session.removeAttribute("surname");
        session.removeAttribute("login");
        session.removeAttribute("email");
        req.getRequestDispatcher(Path.REGISTRATION_PAGE).forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String surname = req.getParameter("surname");
        String login = req.getParameter("login");
        String email = req.getParameter("email");
        String password = req.getParameter("password1");
        String captchaUserText = req.getParameter("myCaptcha");
        Captcha captcha = (Captcha) req.getSession().getAttribute("captcha");

        UserDTO userDTO = new UserDTO(name, surname, login, email, password, captchaUserText);
        Map<String, String> errors = new UserInputValidator().validateRegistrationInput(userDTO, req);

        if (errors.isEmpty()) {
            if (!captcha.getAnswer().equals(captchaUserText)) {
                HttpSession session = req.getSession();
                session.setAttribute("name", name);
                session.setAttribute("surname", surname);
                session.setAttribute("login", login);
                session.setAttribute("email", email);
                resp.sendRedirect("registration");
            } else {
                String image = saveImage(req);
                User user = new User(name, surname, login, email, password, image, UserRole.USER);
                try {
                    usersService.addUser(user);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                req.getSession().setAttribute("user", user);
                req.getRequestDispatcher(Path.MAIN_PAGE).forward(req, resp);
            }
        } else {
            req.setAttribute("errors", errors);
            req.getRequestDispatcher(Path.REGISTRATION_PAGE).forward(req, resp);
        }
    }

    private String saveImage(HttpServletRequest request) throws IOException, ServletException {
        String SAVE_DIR = (String) getServletContext().getAttribute("directory");
        String savePath = getServletContext().getRealPath("") + File.separator + SAVE_DIR;
        File fileSaveDir = new File(savePath);
        if (!fileSaveDir.exists()) {
            fileSaveDir.mkdir();
        }
        Part part = request.getPart("image");
        String extension = getExtension(part);
        String fileName = request.getParameter("login") + "." + extension;
        if ("jpeg".equals(extension)) {
            part.write(savePath + File.separator + fileName);
        }
        return fileName;
    }

    private String getExtension(Part part) {
        return part.getContentType().split("/")[1];
    }
}

