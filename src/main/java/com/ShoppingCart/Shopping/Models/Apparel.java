package com.ShoppingCart.Shopping.Models;

import com.ShoppingCart.Shopping.Models.Product;

import javax.persistence.Entity;
import javax.persistence.Id;
@Entity
public class Apparel extends Product {


    private long id;

    private String type;

    private String brand;

    private String design;


    public Apparel(long productId, String productName, float price, String type, String brand, String design) {
        super(productId, productName, price);
        this.type = type;
        this.brand = brand;
        this.design = design;
    }

    public Apparel(String type, String brand, String design) {
        this.type = type;
        this.brand = brand;
        this.design = design;
    }

    public Apparel() {
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getDesign() {
        return design;
    }

    public void setDesign(String design) {
        this.design = design;
    }

    @Override
    public String toString() {
        return "Apparel{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", brand='" + brand + '\'' +
                ", design='" + design + '\'' +
                '}';
    }
}
