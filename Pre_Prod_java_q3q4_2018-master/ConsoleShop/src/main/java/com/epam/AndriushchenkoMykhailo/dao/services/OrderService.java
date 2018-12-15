package com.epam.AndriushchenkoMykhailo.dao.services;

import com.epam.AndriushchenkoMykhailo.dao.dao.OrderDAO;
import com.epam.AndriushchenkoMykhailo.entities.CartProduct;
import com.epam.AndriushchenkoMykhailo.entities.Order;
import com.epam.AndriushchenkoMykhailo.entities.products.Electronics;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.math.BigDecimal.valueOf;

public class OrderService {
    private OrderDAO order;

    public OrderService(OrderDAO order) {
        this.order = order;
    }

    public Map<String, Object> addOrder(LocalDateTime date, CartService cartService, ProductsService productsService) {
        Map<String, Object> processedData = new HashMap<>();
        BigDecimal sumCostOfProducts = BigDecimal.ZERO;
        List<Electronics> orderProducts = new ArrayList<>();
        for (CartProduct cartProduct : cartService.getCart()) {
            Electronics product = productsService.getProductById(cartProduct.getId());
            orderProducts.add(product);
            BigDecimal countOfProduct = valueOf(cartProduct.getCountOfProduct());
            sumCostOfProducts = sumCostOfProducts.add(product.getCost().multiply(countOfProduct));
        }
        processedData.put("orderProducts", orderProducts);
        processedData.put("sumCostOfProducts", sumCostOfProducts);
        order.addOrder(date, orderProducts);
        return processedData;
    }


    public List<Order> getOrdersFromTimeInterval(LocalDateTime before, LocalDateTime after) {
        return order.getOrdersFromTimeInterval(before, after);
    }

    public Order getNearestOrderToDate(LocalDateTime nearestDate) {
        return order.getNearestOrderToDate(nearestDate);
    }
}
