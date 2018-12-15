package com.epam.andriushchenko.util;

import com.epam.andriushchenko.entities.dto.FilterDTO;

import java.util.List;

public class SQLQueryBuilder {

    public String getProductsByFilters(FilterDTO filterDTO) {
        StringBuilder preparedQuery = new StringBuilder();
        preparedQuery.append("SELECT * FROM products");
        buildQueryByFilter(filterDTO, preparedQuery);
        return preparedQuery.toString();
    }

    public String getCountProductsByFilters(FilterDTO filterDTO) {
        StringBuilder preparedQuery = new StringBuilder();
        preparedQuery.append("SELECT count(*) AS row_count FROM products");
        buildQueryByFilter(filterDTO, preparedQuery);
        return preparedQuery.toString();
    }

    private void buildQueryByFilter(FilterDTO filterDTO, StringBuilder preparedQuery) {
        boolean deleteFlag = false;
        String searchName = filterDTO.getSearchName();
        String minPrice = filterDTO.getMinPrice();
        String maxPrice = filterDTO.getMaxPrice();
        List<String> manufacture = filterDTO.getManufacture();
        List<String> category = filterDTO.getCategory();
        String sortBy = filterDTO.getSortBy();
        String sortWay = filterDTO.getSortWay();
        String productsOnPage = filterDTO.getProductsOnPage();
        int startProductPagination = filterDTO.getStartProductPagination();
        if ((searchName != null && !"".equals(searchName)) || (minPrice != null && !"".equals(minPrice))
                || (maxPrice != null && !"".equals(maxPrice)) || manufacture != null || category != null) {
            preparedQuery.append(" WHERE ");
        }
        if (addSearchNameConditionToQuery(preparedQuery, searchName)) {
            deleteFlag = true;
            preparedQuery.append(" && ");
        }
        if (addPriceConditionToQuery(preparedQuery, minPrice, maxPrice)) {
            deleteFlag = true;
            preparedQuery.append(" && ");
        }
        if (addManufactureConditionToQuery(preparedQuery, manufacture)) {
            deleteFlag = true;
            preparedQuery.append(" && ");
        }
        if (addCategoryConditionToQuery(preparedQuery, category)) {
            deleteFlag = true;
            preparedQuery.append(" && ");
        }
        if (deleteFlag) {
            preparedQuery.delete(preparedQuery.length() - 3, preparedQuery.length());
        }
        addSortBySortWayConditionToQuery(preparedQuery, sortBy, sortWay);
        addProductsOnPageConditionToQuery(preparedQuery, productsOnPage, startProductPagination);
    }

    private boolean addSearchNameConditionToQuery(StringBuilder preparedQuery, String searchName) {
        String templateForNameCondition = "model LIKE ?";
        if (searchName != null && !searchName.isEmpty()) {
            preparedQuery.append(templateForNameCondition);
            return true;
        }
        return false;
    }

    private boolean addPriceConditionToQuery(StringBuilder preparedQuery, String minPrice, String maxPrice) {
        String templateForPriceConditionMinMax = "cost>? && cost<?";
        String templateForPriceConditionMin = "cost>?";
        String templateForPriceConditionMax = "cost<?";
        if (minPrice != null && !minPrice.isEmpty() && maxPrice != null && !maxPrice.isEmpty()) {
            preparedQuery.append(templateForPriceConditionMinMax);
            return true;
        }
        if (minPrice != null && !minPrice.isEmpty()) {
            preparedQuery.append(templateForPriceConditionMin);
            return true;
        }
        if (maxPrice != null && !maxPrice.isEmpty()) {
            preparedQuery.append(templateForPriceConditionMax);
            return true;
        }
        return false;
    }

    private boolean addManufactureConditionToQuery(StringBuilder preparedQuery, List<String> manufactures) {
        String templateForManufactureCondition = "id_manufacture IN (?";
        String templateForManufactureConditionMoreThan2 = ",?";
        if (manufactures != null && !manufactures.isEmpty()) {
            preparedQuery.append(templateForManufactureCondition);
            for (int i = 1; i < manufactures.size(); i++) {
                preparedQuery.append(templateForManufactureConditionMoreThan2);
            }
            preparedQuery.append(")");
            return true;
        }
        return false;
    }

    private boolean addCategoryConditionToQuery(StringBuilder preparedQuery, List<String> category) {
        String templateForCategoryCondition = "id_category IN (?";
        String templateForCategoryConditionMoreThan2 = ",?";
        if (category != null && !category.isEmpty()) {
            preparedQuery.append(templateForCategoryCondition);
            for (int i = 1; i < category.size(); i++) {
                preparedQuery.append(templateForCategoryConditionMoreThan2);
            }
            preparedQuery.append(")");
            return true;
        }
        return false;
    }

    private void addSortBySortWayConditionToQuery(StringBuilder preparedQuery, String sortBy, String sortWay) {
        String templateForSortBySortWayCondition = " ORDER BY ";
        if (sortBy != null && !"".equals(sortBy) && sortWay != null && !"".equals(sortWay)) {
            preparedQuery.append(templateForSortBySortWayCondition).append(sortBy).append(" ").append(sortWay);
        }
    }

    private void addProductsOnPageConditionToQuery(StringBuilder preparedQuery, String productsOnPage, int startProductPagination) {
        String templateForSortBySortWayCondition = " LIMIT ";
        if (productsOnPage != null && !"".equals(productsOnPage)) {
            preparedQuery.append(templateForSortBySortWayCondition).append(startProductPagination).append(",").append(productsOnPage);
        }
    }
}
