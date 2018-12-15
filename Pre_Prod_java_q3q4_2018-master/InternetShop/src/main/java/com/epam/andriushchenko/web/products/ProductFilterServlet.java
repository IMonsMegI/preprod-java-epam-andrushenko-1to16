package com.epam.andriushchenko.web.products;

import com.epam.andriushchenko.entities.dto.FilterDTO;
import com.epam.andriushchenko.entities.products.CategoryProduct;
import com.epam.andriushchenko.entities.products.ManufactureProduct;
import com.epam.andriushchenko.entities.products.Product;
import com.epam.andriushchenko.services.ProductService;
import com.epam.andriushchenko.util.Path;
import com.epam.andriushchenko.util.ProductFilterValidator;
import com.epam.andriushchenko.util.SQLQueryBuilder;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@WebServlet("/productFilter")
public class ProductFilterServlet extends HttpServlet {
    private int amountOfLinksOnPage = 3;
    private ProductService productService;

    @Override
    public void init() {
        productService = (ProductService) getServletContext().getAttribute("productService");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<CategoryProduct> categoryProducts = null;
        List<ManufactureProduct> manufactureProducts = null;
        try {
            categoryProducts = productService.findAllCategory();
            manufactureProducts = productService.findAllManufacture();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        req.setAttribute("categoryProducts", categoryProducts);
        req.setAttribute("manufactureProducts", manufactureProducts);

        String searchName = req.getParameter("searchName");
        String minPrice = req.getParameter("minPrice");
        String maxPrice = req.getParameter("maxPrice");
        String[] manufact = req.getParameterValues("manufacture");
        String[] categor = req.getParameterValues("category");
        List<String> manufacture = null;
        List<String> category = null;
        if (manufact != null) {
            manufacture = Arrays.asList(manufact);
        }
        if (categor != null) {
            category = Arrays.asList(categor);
        }
        String sortBy = req.getParameter("sortBy");
        String sortWay = req.getParameter("sortWay");
        String productsOnPage = req.getParameter("productsOnPage");
        String currentPage = req.getParameter("currentPage");

        FilterDTO filterDTO = new FilterDTO(searchName, minPrice, maxPrice, manufacture, category, sortBy, sortWay, productsOnPage, currentPage, 0);
        req.setAttribute("filterDTO", filterDTO);
        new ProductFilterValidator().validateFilterInput(filterDTO);

        try {
            preparePaginationParameters(filterDTO, req);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        req.getRequestDispatcher(Path.PRODUCTS_PAGE).forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }

    private List<String> getFilterValues(FilterDTO filterDTO) {
        List<String> filterValues = new ArrayList<>();
        String searchName = filterDTO.getSearchName();
        String minPrice = filterDTO.getMinPrice();
        String maxPrice = filterDTO.getMaxPrice();
        List<String> manufacture = filterDTO.getManufacture();
        List<String> category = filterDTO.getCategory();
        if (searchName != null && !"".equals(searchName)) {
            filterValues.add(searchName + "%");
        }
        if (minPrice != null && !"".equals(minPrice)) {
            filterValues.add(minPrice);
        }
        if (maxPrice != null && !"".equals(maxPrice)) {
            filterValues.add(maxPrice);
        }
        if (manufacture != null) {
            filterValues.addAll(manufacture);
        }
        if (category != null) {
            filterValues.addAll(category);
        }
        return filterValues;
    }

    private int getStartValuePaginationBar(HttpServletRequest req) {
        String startValue = req.getParameter("startValue");
        return StringUtils.isNumericSpace(startValue) ? Integer.parseInt(startValue) : 1;
    }

    private int getEndValuePaginationBar(HttpServletRequest req, int countOfPages) {
        int endValue;
        if (!StringUtils.isNumericSpace(req.getParameter("endValue"))) {
            endValue = amountOfLinksOnPage > countOfPages ? countOfPages : amountOfLinksOnPage;
        } else {
            endValue = Integer.parseInt(req.getParameter("endValue"));
            if (amountOfLinksOnPage <= countOfPages && endValue < amountOfLinksOnPage) {
                endValue = amountOfLinksOnPage;
            }
            if (amountOfLinksOnPage > countOfPages) {
                endValue = countOfPages;
            }
        }
        return endValue;
    }

    private void preparePaginationParameters(FilterDTO filterDTO, HttpServletRequest req) throws SQLException {
        List<Product> products;
        SQLQueryBuilder sqlQueryBuilder = new SQLQueryBuilder();
        String filterQueryForCountOfProducts = sqlQueryBuilder.getCountProductsByFilters(filterDTO);
        List<String> filterValues = getFilterValues(filterDTO);
        int countOfProducts = productService.getCountOfProducts(filterQueryForCountOfProducts, filterValues);

        int productsOnPage = Integer.parseInt(filterDTO.getProductsOnPage());
        int currentPage = Integer.parseInt(filterDTO.getCurrentPage());
        if (currentPage > countOfProducts) {
            currentPage = 1;
        }

        int fromStartPagination = (currentPage - 1) * productsOnPage;
        filterDTO.setStartProductPagination(fromStartPagination);

        int countOfPages;
        if (countOfProducts % productsOnPage == 0) {
            countOfPages = countOfProducts / productsOnPage;
        } else {
            countOfPages = countOfProducts / productsOnPage + 1;
        }

        int startValue = getStartValuePaginationBar(req);
        int endValue = getEndValuePaginationBar(req, countOfPages);
        if (startValue > endValue) {
            startValue = 1;
            endValue = getEndValuePaginationBar(req, countOfPages);
        }
        if (currentPage > endValue) {
            startValue = currentPage;
            endValue = currentPage + amountOfLinksOnPage - 1;
        }
        if (currentPage < startValue) {
            startValue = startValue - amountOfLinksOnPage;
            endValue = currentPage;
        }
        if (endValue >= countOfPages) {
            endValue = countOfPages;
        }

        String filterQueryForProducts = sqlQueryBuilder.getProductsByFilters(filterDTO);
        products = productService.findProductsByFilter(filterQueryForProducts, filterValues);

        req.setAttribute("startValue", startValue);
        req.setAttribute("endValue", endValue);
        req.setAttribute("countOfPages", countOfPages);
        req.setAttribute("currentPage", currentPage);
        req.setAttribute("products", products);
        req.setAttribute("countOfProducts", countOfProducts);
    }
}
