package com.workintech.LibrarySystem.model;

import java.util.HashMap;
import java.util.Map;

public class Library {
    private Map<Long, Book> bookList;

    public Library() {
        this.bookList = new HashMap<>();
    }

    public Map<Long, Book> getBookList() {
        return bookList;
    }

    public void setBookList(Map<Long, Book> bookList) {
        this.bookList = bookList;
    }

    public void addBook(Book book){
        bookList.put(book.getId(), book);
        System.out.println("Kitap eklendi: "+ book.getName());
    }


    @Override
    public String toString() {
        return "Library{" +
                "bookList=" + bookList +
                '}';
    }
}
