package com.ShoppingCart.Shopping.Services;

import com.ShoppingCart.Shopping.Models.Product;

import java.util.Map;

public interface ShoppingCartService {

    void addProduct(Product product);

    void removeProduct(Product product);

    Map<Product,Long> getProducts();

    long getTotalPrice();
}
