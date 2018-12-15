package com.epam.AndriushchenkoMykhailo.entities.products;

import java.math.BigDecimal;
import java.util.Objects;

public class TV4K extends TV {
    private int countOfPixel;
    private String aspectRatio;

    public TV4K() {
    }

    public TV4K(int id, BigDecimal cost, String model, int power, double diagonal, boolean color, double height, double width, double length, int countOfPixel, String aspectRatio) {
        super(id, cost, model, power, diagonal, color, height, width, length);
        this.countOfPixel = countOfPixel;
        this.aspectRatio = aspectRatio;
    }

    @Override
    public String toString() {
        return "TV4K {" + "id=" + super.getId() + ", cost=" + super.getCost() + ", model=" + super.getModel() + ", power=" + super.getPower() +
                ", diagonal=" + super.getDiagonal() + ", color=" + super.getCost() + ", height=" + super.getHeight() + ", width="
                + super.getWidth() + ", length=" + super.getLength() + ", countOfPixel=" + countOfPixel + ", aspectRatio=" + aspectRatio + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        TV4K tv4K = (TV4K) o;
        return countOfPixel == tv4K.countOfPixel &&
                Objects.equals(aspectRatio, tv4K.aspectRatio);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), countOfPixel, aspectRatio);
    }

    public void setCountOfPixel(int countOfPixel) {
        this.countOfPixel = countOfPixel;
    }

    public void setAspectRatio(String aspectRatio) {
        this.aspectRatio = aspectRatio;
    }

    public int getCountOfPixel() {
        return countOfPixel;
    }

    public String getAspectRatio() {
        return aspectRatio;
    }
}
