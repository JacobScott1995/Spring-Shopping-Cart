package com.ShoppingCart.Shopping.Models;

import javax.persistence.*;

@Entity
@Table(name = "products")
public class Product {

    @Id
    @SequenceGenerator(name="product_seq",sequenceName="product_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="product_seq")
    @Column(name = "product_id")
    private long productId;

    @Column(name = "product_name")
    private String productName;
    @Column(name = "product_price")
    private float price;
    @Column(name = "product_quantity")
    private int quantity;


    public Product(long productId, String productName, float price, int quantity) {
        this.productId = productId;
        this.productName = productName;
        this.price = price;
        this.quantity = quantity;
    }

    public Product() {
    }

    public long getProductId() {
        return productId;
    }

    public void setProductId(long productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }


    @Override
    public String toString() {
        return "Product{" +
                "productId=" + productId +
                ", productName='" + productName + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                '}';
    }
}
