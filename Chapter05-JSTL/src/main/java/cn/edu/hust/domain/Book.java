package cn.edu.hust.domain;

public class Book {
    private String ISBN;
    private String title;
    private String description;
    private float price;

    public Book() {
    }

    public Book(String ISBN, String title, String description, float price) {
        this.ISBN = ISBN;
        this.title = title;
        this.description = description;
        this.price = price;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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
