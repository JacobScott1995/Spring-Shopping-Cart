package com.ShoppingCart.Shopping.Controller;

import com.ShoppingCart.Shopping.Models.Product;
import com.ShoppingCart.Shopping.Services.CartServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/cart")
public class CartController {

  private final CartServices cartServices;

    @Autowired
    public CartController(CartServices cartServices) {
        this.cartServices = cartServices;
    }
    @GetMapping
    public Map<Product, Long> getCart() {
        return cartServices.getProducts();
    }
    @PostMapping
    public void addToCart(@RequestBody Product product) {
        cartServices.addProduct(product);
    }
    @DeleteMapping
    public void removeFromCart(Product product) {
        cartServices.removeProduct(product);
    }
    @RequestMapping("/checkout")
    public Long getTotalPrice() {
        return cartServices.getTotalPrice();
    }
}
