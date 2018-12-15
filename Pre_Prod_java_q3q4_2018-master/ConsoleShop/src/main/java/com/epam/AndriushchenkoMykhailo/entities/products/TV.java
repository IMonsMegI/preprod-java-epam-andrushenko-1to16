package com.epam.AndriushchenkoMykhailo.entities.products;

import java.math.BigDecimal;
import java.util.Objects;

public class TV extends Electronics {
    private double diagonal;
    private boolean color;
    private double height;
    private double width;
    private double length;

    public TV(){}

    public TV(int id, BigDecimal cost, String model, int power, double diagonal, boolean color, double height, double width, double length) {
        super(id, cost, model, power);
        this.diagonal = diagonal;
        this.color = color;
        this.height = height;
        this.width = width;
        this.length = length;
    }

    public double getDiagonal() {
        return diagonal;
    }

    public double getHeight() {
        return height;
    }

    public double getWidth() {
        return width;
    }

    public double getLength() {
        return length;
    }

    public void setDiagonal(double diagonal) {
        this.diagonal = diagonal;
    }

    public void setColor(boolean color) {
        this.color = color;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public boolean isColor() {
        return color;
    }

    @Override
    public String toString() {
        return "TV{" + "id=" + super.getId() + ", cost=" + super.getCost() + ", model='" + super.getModel() + ", power=" + super.getPower() +
                "diagonal=" + diagonal + ", color=" + color + ", height=" + height + ", width=" + width + ", length=" + length + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        TV TV = (TV) o;
        return Double.compare(TV.diagonal, diagonal) == 0 &&
                color == TV.color &&
                Double.compare(TV.height, height) == 0 &&
                Double.compare(TV.width, width) == 0 &&
                Double.compare(TV.length, length) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), diagonal, color, height, width, length);
    }
}
