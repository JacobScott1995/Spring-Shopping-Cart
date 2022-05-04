package com.ShoppingCart.Shopping.Services;

import com.ShoppingCart.Shopping.Models.Product;
import com.ShoppingCart.Shopping.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@Service
@Transactional
public class CartServices implements ShoppingCartService {

    private final ProductRepository productRepository;

    private Map<Product, Long> products = new HashMap<>();

    @Autowired
    public CartServices(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }


    @Override
    public void addProduct(Product product) {
       if(products.containsKey(product)){
           products.replace(product, products.get(product) + 1);
       }
       else
       {
           products.put(product, 1L);
       }
    }

    @Override
    public void removeProduct(Product product) {

        if(products.containsKey(product)){
            if(products.get(product) > 1){
                products.replace(product, products.get(product) - 1);
            }
            else if(products.get(product) == 1){
                products.remove(product);
            }
        }
    }

    @Override
    public Map<Product, Long> getProducts() {
        return Collections.unmodifiableMap(products);
    }

    @Override
    public long getTotalPrice() {
        return products.entrySet().stream().mapToLong(entry -> (long) (entry.getKey().getPrice() * entry.getValue())).sum();
    }
}
