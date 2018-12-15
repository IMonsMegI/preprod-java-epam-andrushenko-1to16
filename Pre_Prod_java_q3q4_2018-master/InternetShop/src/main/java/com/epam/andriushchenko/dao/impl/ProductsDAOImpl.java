package com.epam.andriushchenko.dao.impl;

import com.epam.andriushchenko.dao.ProductsDAO;
import com.epam.andriushchenko.db.ConnectionHolder;
import com.epam.andriushchenko.entities.products.CategoryProduct;
import com.epam.andriushchenko.entities.products.ManufactureProduct;
import com.epam.andriushchenko.entities.products.Product;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ProductsDAOImpl implements ProductsDAO {
    private static final String FIND_ALL_PRODUCTS = "SELECT * from products";
    private static final String FIND_ALL_CATEGORY = "SELECT * from product_category";
    private static final String FIND_ALL_MANUFACTURE = "SELECT * from product_manufacture";
    private static final String FIND_MANUFACTURE_BY_ID = "SELECT * from product_manufacture where id_manufacture=?";
    private static final String FIND_CATEGORY_BY_ID = "SELECT * from product_category where id_category=?";
    private static final String FIND_PRODUCT_BY_ID = "SELECT * from products where id_product = ?";

    @Override
    public List<Product> findAllProducts() {
        Statement stmt = null;
        ResultSet rs = null;
        List<Product> productList = new ArrayList<>();
        try {
            stmt = ConnectionHolder.getConnection().createStatement();
            rs = stmt.executeQuery(FIND_ALL_PRODUCTS);
            while (rs.next()) {
                Product product = extractProduct(rs);
                productList.add(product);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(stmt);
            close(rs);
        }
        return productList;
    }

    @Override
    public int getCountOfProducts(String filterQuery, List<String> filterValues) {
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        int countOfProducts = 0;
        try {
            pstmt = ConnectionHolder.getConnection().prepareStatement(filterQuery);
            completePreparedStatement(pstmt, filterValues);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                countOfProducts = rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(pstmt);
            close(rs);
        }
        return countOfProducts;
    }

    @Override
    public Product findProductById(int id) {
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        Product product = null;
        try {
            pstmt = ConnectionHolder.getConnection().prepareStatement(FIND_PRODUCT_BY_ID);
            pstmt.setInt(1, id);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                product = extractProduct(rs);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            close(pstmt);
            close(rs);
        }
        return product;
    }

    @Override
    public List<CategoryProduct> findAllCategory() {
        Statement stmt = null;
        ResultSet rs = null;
        List<CategoryProduct> categoryList = new ArrayList<>();
        try {
            stmt = ConnectionHolder.getConnection().createStatement();
            rs = stmt.executeQuery(FIND_ALL_CATEGORY);
            while (rs.next()) {
                CategoryProduct categoryProduct = extractCategory(rs);
                categoryList.add(categoryProduct);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(stmt);
            close(rs);
        }
        return categoryList;
    }

    @Override
    public List<ManufactureProduct> findAllManufacture() {
        Statement stmt = null;
        ResultSet rs = null;
        List<ManufactureProduct> manufactureList = new ArrayList<>();
        try {
            stmt = ConnectionHolder.getConnection().createStatement();
            rs = stmt.executeQuery(FIND_ALL_MANUFACTURE);
            while (rs.next()) {
                ManufactureProduct manufactureProduct = extractManufacture(rs);
                manufactureList.add(manufactureProduct);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(stmt);
            close(rs);
        }
        return manufactureList;
    }

    @Override
    public List<Product> findProductsByFilter(String filterQuery, List<String> filterValues) {
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        List<Product> productList = new ArrayList<>();
        try {
            pstmt = ConnectionHolder.getConnection().prepareStatement(filterQuery);
            completePreparedStatement(pstmt, filterValues);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                Product product = extractProduct(rs);
                productList.add(product);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(pstmt);
            close(rs);
        }
        return productList;
    }

    private void completePreparedStatement(PreparedStatement pstmt, List<String> filterValues) throws SQLException {
        int index = 1;
        for (String filterValue : filterValues) {
            pstmt.setObject(index++, filterValue);
        }
    }

    private ManufactureProduct findManufactureById(int id) {
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        ManufactureProduct manufactureProduct = null;
        try {
            pstmt = ConnectionHolder.getConnection().prepareStatement(FIND_MANUFACTURE_BY_ID);
            pstmt.setInt(1, id);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                manufactureProduct = extractManufacture(rs);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            close(pstmt);
            close(rs);
        }
        return manufactureProduct;
    }

    private CategoryProduct findCategoryById(int id) {
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        CategoryProduct categoryProduct = null;
        try {
            pstmt = ConnectionHolder.getConnection().prepareStatement(FIND_CATEGORY_BY_ID);
            pstmt.setInt(1, id);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                categoryProduct = extractCategory(rs);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            close(pstmt);
            close(rs);
        }
        return categoryProduct;
    }

    private Product extractProduct(ResultSet rs) throws SQLException {
        Product product = new Product();
        product.setId(rs.getInt("id_product"));
        product.setModel(rs.getString("model"));
        product.setCost(rs.getBigDecimal("cost"));
        product.setImage(rs.getString("image"));
        int manufactureId = rs.getInt("id_manufacture");
        product.setManufacture(findManufactureById(manufactureId));
        int catergoryId = rs.getInt("id_category");
        product.setCategoryProduct(findCategoryById(catergoryId));
        return product;
    }

    private CategoryProduct extractCategory(ResultSet rs) throws SQLException {
        CategoryProduct categoryProduct = new CategoryProduct();
        categoryProduct.setId(rs.getInt("id_category"));
        categoryProduct.setValue(rs.getString("name"));
        return categoryProduct;
    }

    private ManufactureProduct extractManufacture(ResultSet rs) throws SQLException {
        ManufactureProduct manufactureProduct = new ManufactureProduct();
        manufactureProduct.setId(rs.getInt("id_manufacture"));
        manufactureProduct.setValue(rs.getString("name"));
        return manufactureProduct;
    }

    private void close(ResultSet rs) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    private void close(Statement stmt) {
        if (stmt != null) {
            try {
                stmt.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
}
