package com.workintech.LibrarySystem.interfaces;

import com.workintech.LibrarySystem.model.Book;

public interface Actions {
    void addBook(Book book);
    boolean searchBook(String bookName);
    void deleteBook(long bookId);
}
