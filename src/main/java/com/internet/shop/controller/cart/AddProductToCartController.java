package com.internet.shop.controller.cart;

import com.internet.shop.lib.Injector;
import com.internet.shop.service.ProductService;
import com.internet.shop.service.ShoppingCartService;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AddProductToCartController extends HttpServlet {
    private static final Injector injector = Injector.getInstance("com.internet.shop");
    private static final String USER_ID = "user_id";
    private ProductService productService
            = (ProductService) injector.getInstance(ProductService.class);
    private ShoppingCartService shoppingCartService
            = (ShoppingCartService) injector.getInstance(ShoppingCartService.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String productId = req.getParameter("id");
        Long id = Long.valueOf(productId);
        Long userId = (Long) req.getSession().getAttribute(USER_ID);
        shoppingCartService.addProduct(shoppingCartService.getByUserId(userId),
                productService.get(id));
        resp.sendRedirect(req.getContextPath() + "/products/all");
    }
}
