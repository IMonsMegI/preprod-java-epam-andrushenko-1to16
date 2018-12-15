package com.epam.AndriushchenkoMykhailo.entities;

import com.epam.AndriushchenkoMykhailo.entities.products.Electronics;

public class CartHistoryProduct {
    private Electronics product;
    private int countOfProduct;

    public CartHistoryProduct(Electronics product, int countOfProduct) {
        this.product = product;
        this.countOfProduct = countOfProduct;
    }

    public Electronics getProduct() {
        return product;
    }

    public int getCountOfProduct() {
        return countOfProduct;
    }

    @Override
    public String toString() {
        return "CartHistoryProduct{" + "product=" + product + ", countOfProduct=" + countOfProduct + '}';
    }
}
