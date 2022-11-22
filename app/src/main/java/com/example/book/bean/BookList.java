package com.example.book.bean;

public class BookList {
    private String bookName;
    private String author;
    private String type;
    private int count;

    public BookList() {
    }

    public BookList(String bookName, String author, String type, int count) {
        this.bookName = bookName;
        this.author = author;
        this.type = type;
        this.count = count;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "book{" +
                "bookName='" + bookName + '\'' +
                ", author='" + author + '\'' +
                ", type='" + type + '\'' +
                ", count=" + count +
                '}';
    }
}
