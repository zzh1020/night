package com.example.book.bean;

public class Shop {
    private String book;

    public Shop() {
    }

    public Shop(String book) {
        this.book = book;
    }

    public String getBook() {
        return book;
    }

    @Override
    public String toString() {
        return "Shop{" +
                "book='" + book + '\'' +
                '}';
    }

    public void setBook(String book) {
        this.book = book;
    }
}
