package com.epam.andriushchenko.util;

import com.epam.andriushchenko.captcha.CaptchaManager;
import com.epam.andriushchenko.captcha.CaptchaTimeController;
import com.epam.andriushchenko.entities.dto.UserDTO;
import com.epam.andriushchenko.services.UsersService;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class UserInputValidator {

    public Map<String, String> validateLoginInput(UserDTO userDTO, HttpServletRequest req) {
        UsersService usersService = (UsersService) req.getServletContext().getAttribute("usersService");
        Map<String, String> errors = new HashMap<>();
        String loginValidation = null;
        try {
            loginValidation = loginValidationForLogin(userDTO.getLogin(), usersService);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        checkErrorExist(errors, "loginError", loginValidation);
        String passwordValidation = passwordValidation(userDTO.getPassword());
        checkErrorExist(errors, "passwordError", passwordValidation);
        return errors;
    }

    public Map<String, String> validateRegistrationInput(UserDTO userDTO, HttpServletRequest req) {
        UsersService usersService = (UsersService) req.getServletContext().getAttribute("usersService");
        Map<String, String> errors = new HashMap<>();
        String nameValidation = nameValidation(userDTO.getName());
        checkErrorExist(errors, "nameError", nameValidation);
        String surnameValidation = surnameValidation(userDTO.getSurname());
        checkErrorExist(errors, "surnameError", surnameValidation);
        String loginValidation = null;
        try {
            loginValidation = loginValidationForRegistration(userDTO.getLogin(), usersService);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        checkErrorExist(errors, "loginError", loginValidation);
        String emailValidation = emailValidation(userDTO.getEmail());
        checkErrorExist(errors, "emailError", emailValidation);
        String passwordValidation = passwordValidation(userDTO.getPassword());
        checkErrorExist(errors, "passwordError", passwordValidation);
        String captchaValidation = captchaValidation(userDTO.getUserInput(), req);
        checkErrorExist(errors, "captchaError", captchaValidation);
        return errors;
    }

    private void checkErrorExist(Map<String, String> errors, String errorName, String errorDescription) {
        if (!"".equals(errorDescription)) {
            errors.put(errorName, errorDescription);
        }
    }

    private String nameValidation(String name) {
        if (name == null || name.isEmpty()) {
            return "Name can not be empty!";
        }
        return "";
    }

    private String surnameValidation(String surname) {
        if (surname == null || surname.isEmpty()) {
            return "Surname can not be empty!";
        }
        return "";
    }

    private String loginValidationForRegistration(String login, UsersService usersService) throws SQLException {
        if (login == null || login.isEmpty()) {
            return "Login can not be empty!";
        } else {
            return usersService.isExistUser(login) ? "User is present" : "";
        }
    }

    private String loginValidationForLogin(String login, UsersService usersService) throws SQLException {
        if (login == null || login.isEmpty()) {
            return "Login can not be empty!";
        } else {
            return usersService.isExistUser(login) ? "" : "User is not present";
        }
    }

    private String emailValidation(String email) {
        if (email == null || email.isEmpty()) {
            return "Email can not be empty!";
        }
        return "";
    }

    private String passwordValidation(String password) {
        if (password == null || password.isEmpty()) {
            return "Password can not be empty!";
        }
        return "";
    }

    private String captchaValidation(String userInput, HttpServletRequest req) {
        if (userInput == null || userInput.isEmpty()) {
            return "Captcha can not be empty!";
        } else {
            String captchaId = new CaptchaManager().getCaptchaId(req);
            Map<String, CaptchaTimeController> captchaContainer = (Map<String, CaptchaTimeController>) req.getServletContext().getAttribute("captchaContainer");
            boolean captchaIsAlive = captchaContainer.get(captchaId).isTimeNotPassed();
            if (captchaIsAlive) {
                return "";
            } else {
                captchaContainer.remove(captchaId);
                return "Captcha`s live is timeout!";
            }
        }
    }
}
