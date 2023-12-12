package com.workintech.LibrarySystem.model;

import com.workintech.LibrarySystem.enums.BookStatus;
import com.workintech.LibrarySystem.enums.Categories;

import java.util.Objects;

public class Book {
    private long id;
    private String name;
    private Categories categories;
    private String author;
    private BookStatus bookStatus;
    private int stock;
    private double price;

    public Book(long id, String name, Categories categories, String author, BookStatus bookStatus,
                int stock, double price) {
        this.id = id;
        this.name = name;
        this.categories = categories;
        this.author = author;
        this.bookStatus = bookStatus;
        this.stock = stock;
        this.price = price;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Categories getCategories() {
        return categories;
    }

    public void setCategories(Categories categories) {
        this.categories = categories;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public BookStatus getBookStatus() {
        return bookStatus;
    }

    public void setBookStatus(BookStatus bookStatus) {
        this.bookStatus = bookStatus;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
        if (stock > 0) {
            this.bookStatus = BookStatus.IN_STOCK;
        } else {
            this.bookStatus = BookStatus.OUT_OF_STOCK;
        }
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return id == book.id && Objects.equals(name, book.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", categories=" + categories +
                ", author='" + author + '\'' +
                ", status= '" + bookStatus + '\'' +
                ", stock= '" + stock + '\'' +
                ", price= '" + price + '\'' +
                '}';
    }
}


