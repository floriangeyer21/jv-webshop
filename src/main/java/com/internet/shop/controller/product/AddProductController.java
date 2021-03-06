package com.internet.shop.controller.product;

import com.internet.shop.lib.Injector;
import com.internet.shop.model.Product;
import com.internet.shop.service.ProductService;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AddProductController extends HttpServlet {
    private static final Injector injector = Injector.getInstance("com.internet.shop");
    private ProductService productService
            = (ProductService) injector.getInstance(ProductService.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/views/products/addProduct.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String productName = req.getParameter("name");
        String price = req.getParameter("price");
        if (productName.length() == 0 || price.length() == 0) {
            req.setAttribute("message", "You did not entered name or price of the product");
            req.getRequestDispatcher("/WEB-INF/views/products/addProduct.jsp").forward(req, resp);
        } else {
            productService.create(new Product(productName, Double.parseDouble(price)));
            resp.sendRedirect(req.getContextPath() + "/");
        }
    }
}
