package com.epam.andriushchenko.entities.orders;

import com.epam.andriushchenko.entities.products.Product;

import java.math.BigDecimal;

public class OrderProductInfo {
    private int idOrderProduct;
    private int idOrder;
    private Product product;
    private int countOfProduct;
    private BigDecimal cost;

    public OrderProductInfo(int idOrder, Product product, int countOfProduct, BigDecimal cost) {
        this.idOrder = idOrder;
        this.product = product;
        this.countOfProduct = countOfProduct;
        this.cost = cost;
    }

    public int getIdOrderProduct() {
        return idOrderProduct;
    }

    public void setIdOrderProduct(int idOrderProduct) {
        this.idOrderProduct = idOrderProduct;
    }

    public int getIdOrder() {
        return idOrder;
    }

    public void setIdOrder(int idOrder) {
        this.idOrder = idOrder;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getCountOfProduct() {
        return countOfProduct;
    }

    public void setCountOfProduct(int countOfProduct) {
        this.countOfProduct = countOfProduct;
    }

    public BigDecimal getCost() {
        return cost;
    }

    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }
}
