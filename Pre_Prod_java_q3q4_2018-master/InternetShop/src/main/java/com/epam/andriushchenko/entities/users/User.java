package com.epam.andriushchenko.entities.users;

public class User {
    private static final String DEFAULT_IMAGE = "default-user-avatar-30-30.jpg";
    private int id;
    private String name;
    private String surname;
    private String login;
    private String email;
    private String password;
    private String image = DEFAULT_IMAGE;
    private UserRole userRole;

    public User() {
    }

    public User(String name, String surname, String login, String email, String password, String image, UserRole userRole) {
        this.name = name;
        this.surname = surname;
        this.login = login;
        this.email = email;
        this.password = password;
        this.image = image;
        this.userRole = userRole;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public UserRole getUserRole() {
        return userRole;
    }

    public void setUserRole(UserRole userRole) {
        this.userRole = userRole;
    }

    @Override
    public String toString() {
        return "User{" + "id=" + id + ", name='" + name + ", surname='" + surname + ", login='" + login
                + ", email='" + email + ", password='" + password + ", image='" + image + '}';
    }
}
