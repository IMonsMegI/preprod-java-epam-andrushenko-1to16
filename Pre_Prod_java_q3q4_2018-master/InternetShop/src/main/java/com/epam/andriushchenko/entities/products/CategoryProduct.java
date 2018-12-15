package com.epam.andriushchenko.entities.products;

public class CategoryProduct {
    private int id;
    private String value;

    public CategoryProduct() {
    }

    public CategoryProduct(int id, String value) {
        this.id = id;
        this.value = value;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "CategoryProduct{" + "id=" + id + ", value='" + value + '}';
    }
}
