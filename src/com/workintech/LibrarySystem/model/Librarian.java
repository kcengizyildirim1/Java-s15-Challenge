package com.workintech.LibrarySystem.model;

import com.workintech.LibrarySystem.enums.BookStatus;
import com.workintech.LibrarySystem.enums.Categories;
import com.workintech.LibrarySystem.interfaces.LibrarianActions;

import java.util.Iterator;

public class Librarian extends Person implements LibrarianActions {

    private Library library;

    public Librarian(String name, Library library) {
        super(name);
        this.library = library;
    }

    @Override
    public void addBook(Book book) {
        if (book.getStock() == 0 && book.getBookStatus() == BookStatus.OUT_OF_STOCK) {
            book.setBookStatus(BookStatus.IN_STOCK);
        }
        book.setStock(book.getStock() + 1);
        library.getBookList().put(book.getId(), book);
    }

    @Override
    public boolean searchBook(String bookName) {
        for(Book book : library.getBookList().values()){
            if (book.getName().equalsIgnoreCase(bookName)){
                System.out.println("Aradiginiz kitap bulundu: " + book.getName());
                return true;
            }
        }
        System.out.println("Uzgunum aradiginiz kitap sistemimizde bulunmamaktadir.");
        return false;
    }

    @Override
    public void deleteBook(long bookId) {
        Iterator<Book> iterator = library.getBookList().values().iterator();
        while (iterator.hasNext()) {
            Book book = iterator.next();
            if (book.getId() == bookId) {
                iterator.remove();
                System.out.println("Kitap sistemimizden kaldırıldı: " + book.getName());
                return;
            }
        }
        System.out.println("Sistemde böyle bir kitap bulunmamaktadır.");
    }

    @Override
    public void updateBook(Book book , String name , String author , double price, Categories categories, int stock ,
     BookStatus bookStatus) {
        if(searchBook(book.getName())){
            book.setName(name);
            book.setAuthor(author);
            book.setPrice(price);
            book.setCategories(categories);
            book.setStock(stock);
            book.setBookStatus(bookStatus);
        }
    }

    @Override
    public String toString() {
        return "Librarian{" +
                "library=" + library +
                '}';
    }
}
