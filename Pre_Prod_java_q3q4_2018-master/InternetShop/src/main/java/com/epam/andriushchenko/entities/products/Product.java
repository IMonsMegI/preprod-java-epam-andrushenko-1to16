package com.epam.andriushchenko.entities.products;

import java.math.BigDecimal;
import java.util.Objects;

public class Product {
    private int id;
    private String model;
    private BigDecimal cost;
    private String image;
    private ManufactureProduct manufacture;
    private CategoryProduct categoryProduct;

    public Product() {
    }

    public Product(int id, String model, BigDecimal cost, String image, ManufactureProduct manufacture, CategoryProduct categoryProduct) {
        this.id = id;
        this.model = model;
        this.cost = cost;
        this.image = image;
        this.manufacture = manufacture;
        this.categoryProduct = categoryProduct;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public BigDecimal getCost() {
        return cost;
    }

    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public ManufactureProduct getManufacture() {
        return manufacture;
    }

    public void setManufacture(ManufactureProduct manufacture) {
        this.manufacture = manufacture;
    }

    public CategoryProduct getCategoryProduct() {
        return categoryProduct;
    }

    public void setCategoryProduct(CategoryProduct categoryProduct) {
        this.categoryProduct = categoryProduct;
    }

    @Override
    public String toString() {
        return "Product{" + "id=" + id + ", model='" + model + ", cost=" + cost + ", image='" + image +
                ", manufacture=" + manufacture + ", categoryProduct=" + categoryProduct + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return id == product.id &&
                Objects.equals(model, product.model) &&
                Objects.equals(cost, product.cost) &&
                Objects.equals(image, product.image);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, model, cost, image);
    }
}
