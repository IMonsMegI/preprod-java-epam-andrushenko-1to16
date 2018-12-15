package com.epam.andriushchenko.security;

import javax.xml.bind.annotation.XmlElement;
import java.util.ArrayList;
import java.util.List;

public class Constraint {
    private List<String> availableURLs = new ArrayList<>();
    private String role;

    public List<String> getAvailableURLs() {
        return availableURLs;
    }

    @XmlElement(name = "url-pattern")
    public void setAvailableURLs(List<String> availableURLs) {
        this.availableURLs = availableURLs;
    }

    public String getRole() {
        return role;
    }

    @XmlElement(name = "role")
    public void setRole(String role) {
        this.role = role;
    }
}
