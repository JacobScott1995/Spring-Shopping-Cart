package com.ShoppingCart.Shopping.Services;

import com.ShoppingCart.Shopping.Models.Product;

import java.util.Optional;

public interface ProductsService {
    Optional<Product> findById(Long id);
}
