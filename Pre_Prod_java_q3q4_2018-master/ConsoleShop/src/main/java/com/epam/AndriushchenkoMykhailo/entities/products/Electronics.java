package com.epam.AndriushchenkoMykhailo.entities.products;

import com.fasterxml.jackson.annotation.JsonTypeInfo;

import java.math.BigDecimal;
import java.util.Objects;

@JsonTypeInfo(use= JsonTypeInfo.Id.CLASS)
public class Electronics {
    private int id;
    private BigDecimal cost;
    private String model;
    private int power;

    public Electronics() {
    }

    public Electronics(int id, BigDecimal cost, String model, int power) {
        this.id = id;
        this.cost = cost;
        this.model = model;
        this.power = power;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public BigDecimal getCost() {
        return cost;
    }

    public String getModel() {
        return model;
    }

    public int getPower() {
        return power;
    }

    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setPower(int power) {
        this.power = power;
    }

    @Override
    public String toString() {
        return "Electronics{" + "id=" + id + ", cost=" + cost + ", model='" + model + ", power=" + power + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Electronics that = (Electronics) o;
        return id == that.id && cost == that.cost && power == that.power && Objects.equals(model, that.model);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, cost, model, power);
    }
}
