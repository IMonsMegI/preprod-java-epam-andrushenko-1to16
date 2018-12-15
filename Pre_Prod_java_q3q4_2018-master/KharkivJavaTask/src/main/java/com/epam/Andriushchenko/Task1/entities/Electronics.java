package com.epam.Andriushchenko.Task1.entities;

import java.math.BigDecimal;
import java.util.Objects;

public class Electronics {
    private BigDecimal cost;
    private String model;
    private int power;

    public Electronics() {
    }

    public Electronics(BigDecimal cost, String model, int power) {
        this.cost = cost;
        this.model = model;
        this.power = power;
    }

    public BigDecimal getCost() {
        return cost;
    }

    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    @Override
    public String toString() {
        return "Electronics{" + "cost=" + cost + ", model='" + model + ", power=" + power + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Electronics that = (Electronics) o;
        return cost == that.cost && power == that.power && Objects.equals(model, that.model);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cost, model, power);
    }
}
