package com.epam.AndriushchenkoMykhailo.entities;

public class CartProduct {
    private int id;
    private int countOfProduct;

    public CartProduct(int id, int countOfProduct) {
        this.id = id;
        this.countOfProduct = countOfProduct;
    }

    public int getId() {
        return id;
    }

    public int getCountOfProduct() {
        return countOfProduct;
    }

    @Override
    public String toString() {
        return "CartProduct{" + "id=" + id + ", countOfProduct=" + countOfProduct + '}';
    }
}
