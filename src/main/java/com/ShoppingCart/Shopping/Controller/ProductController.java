package com.ShoppingCart.Shopping.Controller;

import com.ShoppingCart.Shopping.Models.Product;
import com.ShoppingCart.Shopping.Services.ProductServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    private final ProductServices productServices;

    @Autowired
    public ProductController(ProductServices productServices) {
        this.productServices = productServices;
    }
    @GetMapping
    public List<Product> getAllProducts() {
        return productServices.getAllProducts();
    }
    @PostMapping
    public void createNewProduct(@RequestBody Product product) {
        productServices.addNewProduct(product);
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable Long id) throws IllegalAccessException {
        productServices.deleteItem(id);
    }

    @PutMapping("/{id}")
    public void updateProduct(@PathVariable Long id, @RequestBody Product product) {
        productServices.updateProduct(id, String.valueOf(product));
    }
}
