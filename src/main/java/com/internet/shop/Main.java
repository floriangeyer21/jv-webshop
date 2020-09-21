package com.internet.shop;

import com.internet.shop.dao.ProductDao;
import com.internet.shop.lib.Inject;
import com.internet.shop.lib.Service;
import com.internet.shop.model.Product;

@Service
public class Main {
    @Inject
    private static ProductDao productDao;

    public static void main(String[] args) {
        productDao.create(new Product("Meat", 10.0));
        productDao.create(new Product("Bread", 10.0));
        productDao.create(new Product("Salt", 10.0));

        //GET CHECK
        Product salt = productDao.get(3L).get();
        System.out.println(productDao.get(3L));

        System.out.println(productDao.getAll());

        // UPDATE PRODUCT CHECK
        Product cheese = new Product("Cheese", 15.0);
        cheese.setId(2L);
        System.out.println(productDao.update(cheese));

        // GET ALL CHECK
        System.out.println(productDao.getAll());

        // DELETE AND DELETEBYID CHECK
        productDao.delete(new Product("Salt", 10.0));
        productDao.deleteById(1L);

        System.out.println(productDao.getAll());
    }
}
