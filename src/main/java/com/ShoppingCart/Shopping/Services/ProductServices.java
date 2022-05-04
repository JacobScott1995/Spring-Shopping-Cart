package com.ShoppingCart.Shopping.Services;

import com.ShoppingCart.Shopping.Models.Product;
import com.ShoppingCart.Shopping.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class ProductServices implements ProductsService{

    private final ProductRepository productRepository;

    @Autowired
    public ProductServices(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public void addNewProduct(Product product) {
        Optional<Product> productOptional = productRepository.findById(product.getProductId());
        productRepository.save(product);
    }

    public void deleteItem(Long id) throws IllegalAccessException {
        boolean b = productRepository.existsById(id);
        if(!b)
        {
            throw new IllegalAccessException("Product with id "+id+" does not exist");
        }
        productRepository.deleteById(id);
    }
    @Transactional
    public void updateProduct(Long id, String name)
    {
        Product product = productRepository.findById(id).orElseThrow((()->new IllegalArgumentException("Product with id "+id+" does not exist")));

        if( name != null && !name.isEmpty())
        {
            product.setProductName(name);
        }
    }

    @Override
    public Optional<Product> findById(Long id) {
        return productRepository.findById(id);
    }
}
