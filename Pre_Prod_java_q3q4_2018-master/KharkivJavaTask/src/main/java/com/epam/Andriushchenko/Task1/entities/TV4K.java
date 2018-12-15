package com.epam.Andriushchenko.Task1.entities;

import java.util.Objects;

public class TV4K extends Televisor {
    private int countOfPixel;
    private String aspectRatio;

    public int getCountOfPixel() {
        return countOfPixel;
    }

    public void setCountOfPixel(int countOfPixel) {
        this.countOfPixel = countOfPixel;
    }

    public String getAspectRatio() {
        return aspectRatio;
    }

    public void setAspectRatio(String aspectRatio) {
        this.aspectRatio = aspectRatio;
    }

    @Override
    public String toString() {
        return "TV4K{" + "countOfPixel=" + countOfPixel + ", aspectRatio='" + aspectRatio + '}';
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
}
