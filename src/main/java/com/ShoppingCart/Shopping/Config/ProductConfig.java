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
                    "Zip-up",
                    "Gucci",
                    "Swagger"
            );
            Product dior = new Apparel(
                    2L,
                    "Dior Boss Hoddie",
                    200F,
                    "Hoddie",
                    "Dior",
                    "Boss"
            );
            Product harryPotter = new Book(
                    3L,
                    "Harry Potter and the Sorcerer's Stone",
                    12F,
                    "Fantasy",
                    "J.K. Rowling",
                    1997
            );

            Product ofMiceAndMen = new Book(
                    4L,
                    "John Steinbeck",
                    12F,
                    "Fantasy",
                    "John Steinbeck",
                    1937
            );
            repository.saveAll(List.of(gucci, dior, harryPotter, ofMiceAndMen));
        };
    }
}
