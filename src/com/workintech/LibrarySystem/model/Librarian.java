package com.workintech.LibrarySystem.model;

import com.workintech.LibrarySystem.interfaces.Actions;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Librarian implements Actions {

        private String name;
        private Library library;

        public Librarian(String name, Library library) {

            this.name = name;
            this.library = library;
        }


    @Override
    public void addBook(Book book) {
        library.addBook(book);
    }

    @Override
    public boolean searchBook(String bookName) {
        for(Book book : library.getBookList().values()){
            if (book.getName().toLowerCase().equals(bookName.toLowerCase())){
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
                return;  // Kitap bulunduğunda işlemi sonlandır
            }
        }
        System.out.println("Sistemde böyle bir kitap bulunmamaktadır.");
    }




    @Override
    public String toString() {
        return "Librarian{" +
                ", name='" + name + '\'' +
                ", library=" + library +
                '}';
    }
}
