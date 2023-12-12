package com.workintech.LibrarySystem.interfaces;

import com.workintech.LibrarySystem.enums.BookStatus;
import com.workintech.LibrarySystem.enums.Categories;
import com.workintech.LibrarySystem.model.Book;

public interface LibrarianActions {
    void addBook(Book book);
    boolean searchBook(String bookName);
    void deleteBook(long bookId);
    void updateBook(Book book , String name , String author , double price, Categories categories, int stock ,
                    BookStatus bookStatus);
}
