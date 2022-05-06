package com.ShoppingCart.Shopping.Models;

import javax.persistence.Entity;
@Entity
public class Book extends Product {

    private long id;

    private String genre;

    private String author;

    private int publishedDate;

    public Book(long productId, String productName, float price, int quanitity, String genre, String author, int publishedDate) {
        super(productId, productName, price, quanitity);
        this.genre = genre;
        this.author = author;
        this.publishedDate = publishedDate;
    }

    public Book(String genre, String author, int publishedDate) {
        this.genre = genre;
        this.author = author;
        this.publishedDate = publishedDate;
    }

    public Book() {
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getPublishedDate() {
        return publishedDate;
    }

    public void setPublishedDate(int publishedDate) {
        this.publishedDate = publishedDate;
    }
}
