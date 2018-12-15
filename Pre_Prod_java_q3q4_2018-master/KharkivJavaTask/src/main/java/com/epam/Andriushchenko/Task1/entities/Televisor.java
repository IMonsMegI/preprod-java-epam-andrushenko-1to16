package com.epam.Andriushchenko.Task1.entities;

import java.util.Objects;

public class Televisor extends Electronics {
    private double diagonal;
    private boolean color;
    private double height;
    private double width;
    private double length;

    public Televisor() {
    }

    public Televisor(double diagonal, boolean color, double height, double width, double length) {
        this.diagonal = diagonal;
        this.color = color;
        this.height = height;
        this.width = width;
        this.length = length;
    }

    public double getDiagonal() {
        return diagonal;
    }

    public void setDiagonal(double diagonal) {
        this.diagonal = diagonal;
    }

    public boolean isColor() {
        return color;
    }

    public void setColor(boolean color) {
        this.color = color;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    @Override
    public String toString() {
        return "Televisor{" + "cost=" + super.getCost() + ", model='" + super.getModel() + ", power=" + super.getPower() +
                "diagonal=" + diagonal + ", color=" + color + ", height=" + height + ", width=" + width + ", length=" + length + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Televisor televisor = (Televisor) o;
        return Double.compare(televisor.diagonal, diagonal) == 0 &&
                color == televisor.color &&
                Double.compare(televisor.height, height) == 0 &&
                Double.compare(televisor.width, width) == 0 &&
                Double.compare(televisor.length, length) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), diagonal, color, height, width, length);
    }
}
