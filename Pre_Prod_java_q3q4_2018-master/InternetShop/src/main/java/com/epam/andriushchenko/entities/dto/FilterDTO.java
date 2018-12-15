package com.epam.andriushchenko.entities.dto;

import java.util.List;

public class FilterDTO {
    private String searchName;
    private String minPrice;
    private String maxPrice;
    private List<String> manufacture;
    private List<String> category;
    private String sortBy;
    private String sortWay;
    private String productsOnPage;
    private String currentPage;
    private int startProductPagination;

    public FilterDTO(String searchName, String minPrice, String maxPrice, List<String> manufacture,
                     List<String> category, String sortBy, String sortWay, String productsOnPage, String currentPage, int startProductPagination) {
        this.searchName = searchName;
        this.minPrice = minPrice;
        this.maxPrice = maxPrice;
        this.manufacture = manufacture;
        this.category = category;
        this.sortBy = sortBy;
        this.sortWay = sortWay;
        this.productsOnPage = productsOnPage;
        this.currentPage = currentPage;
        this.startProductPagination = startProductPagination;
    }

    public String getSearchName() {
        return searchName;
    }

    public String getMinPrice() {
        return minPrice;
    }

    public String getMaxPrice() {
        return maxPrice;
    }

    public List<String> getManufacture() {
        return manufacture;
    }

    public List<String> getCategory() {
        return category;
    }

    public String getSortBy() {
        return sortBy;
    }

    public String getSortWay() {
        return sortWay;
    }

    public String getProductsOnPage() {
        return productsOnPage;
    }

    public String getCurrentPage() {
        return currentPage;
    }

    public int getStartProductPagination() {
        return startProductPagination;
    }

    public void setStartProductPagination(int startProductPagination) {
        this.startProductPagination = startProductPagination;
    }

    public void setProductsOnPage(String productsOnPage) {
        this.productsOnPage = productsOnPage;
    }

    public void setCurrentPage(String currentPage) {
        this.currentPage = currentPage;
    }
}
