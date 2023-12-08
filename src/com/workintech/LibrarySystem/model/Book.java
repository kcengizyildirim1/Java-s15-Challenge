package com.workintech.LibrarySystem.model;

import com.workintech.LibrarySystem.enums.BookStatus;
import com.workintech.LibrarySystem.enums.Categories;

import java.util.Objects;

public class Book {
    private long id;
    private String name;
    private Categories categories;
    private String writer;
    private int page;
    private BookStatus bookStatus;
    private int stock;

    public Book(long id, String name, Categories categories, String writer, int page, BookStatus bookStatus, int stock) {
        this.id = id;
        this.name = name;
        this.categories = categories;
        this.writer = writer;
        this.page = page;
        this.bookStatus = bookStatus;
        this.stock = stock;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
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

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
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
                ", writer='" + writer + '\'' +
                ", page= '" + page + '\'' +
                ", status= '" + bookStatus + '\'' +
                ", stock= '" + stock + '\'' +
                '}';
    }
}


