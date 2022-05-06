package com.ShoppingCart.Shopping.Config;

import com.ShoppingCart.Shopping.Models.Apparel;
import com.ShoppingCart.Shopping.Models.Book;
import com.ShoppingCart.Shopping.Models.Product;
import com.ShoppingCart.Shopping.Repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class ProductConfig {

    @Bean
    CommandLineRunner runner(ProductRepository repository) {
        return args -> {
            Product gucci = new Apparel(
                    1L,
                    "Gucci Swagger Zip-Up",
                    210F,
                    5,
                    "Zip-up",
                    "Gucci",
                    "Swagger"
            );
            Product dior = new Apparel(
                    2L,
                    "Dior Master Zip-Up",
                    210F,
                    15,
                    "Zip-up",
                    "Dior",
                    "Master"
            );
            Product harryPotter = new Book(
                    3L,
                    "Harry Potter and the Sorcerer's Stone",
                    12F,
                    5,
                    "Fantasy",
                    "J.K. Rowling",
                    1997
            );

            Product ofMiceAndMen = new Book(
                    4L,
                    "John Steinbeck",
                    12F,
                    5,
                    "Fantasy",
                    "John Steinbeck",
                    1937
            );
            repository.saveAll(List.of(gucci, dior, harryPotter, ofMiceAndMen));
        };
    }
}
