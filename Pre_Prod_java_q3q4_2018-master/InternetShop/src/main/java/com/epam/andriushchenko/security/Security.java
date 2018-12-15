package com.epam.andriushchenko.security;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "security")
public class Security {
    private List<Constraint> constraintList;

    public List<Constraint> getConstraintList() {
        return constraintList;
    }

    @XmlElement(name = "constraint")
    public void setConstraintList(List<Constraint> constraintList) {
        this.constraintList = constraintList;
    }
}
