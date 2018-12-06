package cn.edu.hust.domain;

import java.io.Serializable;

public class Product implements Serializable{
    private int id;
    private String productName;
    private String description;
    private float price;

    public Product(int id, String productName, String description, float price) {
        this.id = id;
        this.productName = productName;
        this.description = description;
        this.price = price;
    }

    public Product() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
}
