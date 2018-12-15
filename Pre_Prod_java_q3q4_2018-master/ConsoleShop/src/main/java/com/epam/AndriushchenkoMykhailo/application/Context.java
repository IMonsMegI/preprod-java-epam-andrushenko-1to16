package com.epam.AndriushchenkoMykhailo.application;

import com.epam.AndriushchenkoMykhailo.dao.dao.CartDAO;
import com.epam.AndriushchenkoMykhailo.dao.dao.CartHistoryDAO;
import com.epam.AndriushchenkoMykhailo.dao.dao.OrderDAO;
import com.epam.AndriushchenkoMykhailo.dao.dao.ProductsDAO;
import com.epam.AndriushchenkoMykhailo.dao.dao.impl.CartDAOImpl;
import com.epam.AndriushchenkoMykhailo.dao.dao.impl.CartHistoryDAOImpl;
import com.epam.AndriushchenkoMykhailo.dao.dao.impl.OrderDAOImpl;
import com.epam.AndriushchenkoMykhailo.dao.dao.impl.ProductsDAOImpl;
import com.epam.AndriushchenkoMykhailo.dao.services.CartHistoryService;
import com.epam.AndriushchenkoMykhailo.dao.services.CartService;
import com.epam.AndriushchenkoMykhailo.dao.services.OrderService;
import com.epam.AndriushchenkoMykhailo.dao.services.ProductsService;
import com.epam.AndriushchenkoMykhailo.entities.products.Electronics;
import com.epam.AndriushchenkoMykhailo.inputStrategy.InputStrategyContainer;
import com.epam.AndriushchenkoMykhailo.serialization.json.JsonReader;
import com.epam.AndriushchenkoMykhailo.userInterface.UIContainer;

import java.util.List;

public class Context {
    private UIContainer uiContainer = new UIContainer();
    private CartDAO cartDAO = new CartDAOImpl();
    private OrderDAO orderDAO = new OrderDAOImpl();
    private ProductsDAO productsDAO = new ProductsDAOImpl(initProducts());
    private CartHistoryDAO cartHistoryDAO = new CartHistoryDAOImpl(5);
    private CartService cartService = new CartService(cartDAO);
    private ProductsService productsService = new ProductsService(productsDAO);
    private OrderService orderService = new OrderService(orderDAO);
    private CartHistoryService cartHistoryService = new CartHistoryService(cartHistoryDAO);
    private InputStrategyContainer inputStrategyContainer = new InputStrategyContainer();

    public UIContainer getUiContainer() {
        return uiContainer;
    }

    public CartService getCartService() {
        return cartService;
    }

    public OrderService getOrderService() {
        return orderService;
    }

    public ProductsService getProductsService() {
        return productsService;
    }

    public CartHistoryService getCartHistoryService() {
        return cartHistoryService;
    }

    public InputStrategyContainer getInputStrategyContainer() {
        return inputStrategyContainer;
    }

    //This is a list of products just in case
//    private List<Electronics> initProducts() {
//        List<Electronics> products = new ArrayList<>();
//        products.add(new TV4K(0, new BigDecimal(18000), "Samsung Ultra 4k", 115, 43.0, true, 3840, 9.8, 2160, 3840 * 2160, "16:10"));
//        products.add(new TV4K(1, new BigDecimal(25000), "LG Ultra vision", 120, 40.0, true, 3820, 9.1, 2240, 3820 * 2240, "16:12"));
//        products.add(new SmartTV(2, new BigDecimal(18000), "Philips smart vision", 118, 42.0, true, 3840, 9.5, 2160, true, "16:10"));
//        products.add(new TV4K(3, new BigDecimal(20000), "Samsung UltraSuper 4k", 125, 43.0, true, 3840, 9.8, 2160, 3840 * 2160, "16:10"));
//        products.add(new TV4K(4, new BigDecimal(28000), "LG UltraSuper vision", 130, 40.0, true, 3820, 9.1, 2240, 3820 * 2240, "16:12"));
//        products.add(new SmartTV(5, new BigDecimal(15000), "Philips Super Smart vision", 112, 42.0, true, 3840, 9.5, 2160, true, "16:10"));
//        return products;
//    }

    private List<Electronics> initProducts() {
        return JsonReader.getProductListFromJson();
    }
}
