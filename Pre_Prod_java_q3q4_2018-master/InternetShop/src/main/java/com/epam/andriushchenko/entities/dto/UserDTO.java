package com.epam.andriushchenko.entities.dto;

public class UserDTO {
    private String name;
    private String surname;
    private String login;
    private String email;
    private String password;
    private String userInput;

    public UserDTO(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public UserDTO(String name, String surname, String login, String email, String password, String userInput) {
        this.name = name;
        this.surname = surname;
        this.login = login;
        this.email = email;
        this.password = password;
        this.userInput = userInput;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getLogin() {
        return login;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getUserInput() {
        return userInput;
    }
}
