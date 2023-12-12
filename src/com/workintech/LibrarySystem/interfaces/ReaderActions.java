package com.workintech.LibrarySystem.interfaces;

import com.workintech.LibrarySystem.model.Book;
import com.workintech.LibrarySystem.model.Library;

public interface ReaderActions {
    boolean login(String inputPassword , long inputSchoolNumber);
    void borrow(String book);
    void returnBook(String returnedBook);
    boolean searchBook(String bookName);
}
