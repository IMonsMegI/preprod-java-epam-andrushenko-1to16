package com.epam.andriushchenko.util;

import com.epam.andriushchenko.entities.dto.FilterDTO;

public class ProductFilterValidator {
    public void validateFilterInput(FilterDTO filterDTO) {
        String productsOnPage = filterDTO.getProductsOnPage();
        String currentPage = filterDTO.getCurrentPage();
        if (productsOnPage == null || "".equals(productsOnPage)) {
            filterDTO.setProductsOnPage("6");
        }
        if (currentPage == null || "".equals(currentPage)) {
            filterDTO.setCurrentPage("1");
        }
    }
}
