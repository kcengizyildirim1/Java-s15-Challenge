package com.workintech.LibrarySystem.model;

import com.workintech.LibrarySystem.enums.BookStatus;
import com.workintech.LibrarySystem.enums.ReaderType;
import com.workintech.LibrarySystem.interfaces.ReaderActions;

import java.util.*;


public class Reader extends Person implements ReaderActions {
    private long schoolNumber;
    private String password;
    private ReaderType readerType;
    private List<Book> borrowedBooks;
    private Library library;

    private double money;

    private List<Bill> bills;



    public Reader(String name, long schoolNumber, String password, ReaderType readerType, Library library,
                  double money) {
        super(name);
        this.schoolNumber = schoolNumber;
        this.password = password;
        this.readerType = readerType;
        this.borrowedBooks = new ArrayList<>();
        this.library = library;
        this.money = money;
        this.bills = new ArrayList<>();
    }

    public long getSchoolNumber() {
        return schoolNumber;
    }

    public String getPassword() {
        return password;
    }

    public ReaderType getReaderType() {
        return readerType;
    }

    public List<Book> getBorrowedBooks() {
        return borrowedBooks;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public List<String> displayBorrowedBooks() {
        List<String> result = new LinkedList<>();

        if (borrowedBooks.isEmpty()) {
            System.out.println("Sistemde kitap bulunmamaktadir.");
            return result;
        }

        for (Book book : borrowedBooks) {
            String bookName = book.getName();
            boolean bookAlreadyAdded = false;

            for (String entry : result) {
                if (entry.startsWith(bookName)) {
                    bookAlreadyAdded = true;
                    int count = Integer.parseInt(entry.split(" - ")[1]);
                    result.remove(entry);
                    result.add(bookName + " - " + (count + 1));
                    break;
                }
            }

            if (!bookAlreadyAdded) {
                result.add(bookName + " - 1");
            }
        }

        return result;
    }

    public Library getLibrary() {
        return library;
    }

    public List<Bill> getBills() {
        return bills;
    }

    @Override
    public boolean login(String inputPassword , long inputSchoolNumber) {
        if(password.equals(inputPassword) && inputSchoolNumber == schoolNumber){
            System.out.println("Hosgeldin " + getName());
            return true;
        }
        System.out.println("Hatali sifre lutfen tekrar deneyiniz.");
        return false;
    }

    @Override
    public void borrow(String requestBook) {
        if (borrowedBooks.size() <= 5) {
            for (Book book : library.getBookList().values()) {
                if (requestBook.equalsIgnoreCase(book.getName()) && book.getStock() > 0) {
                    double bookPrice = book.getPrice();

                    if (this.getMoney() >= bookPrice) {
                        borrowedBooks.add(book);
                        book.setStock(book.getStock() - 1);
                        this.setMoney(this.getMoney() - bookPrice);

                        Bill bill = new Bill(book.getId(), book.getName(), this.getName(), this.getReaderType(),
                                bookPrice);
                        bills.add(bill);

                        if (book.getBookStatus() == BookStatus.OUT_OF_STOCK) {
                            System.out.println("Son " + requestBook + " kitabi alinmistir. Bakiyenizden " + bookPrice + " TL düşüldü.");
                            bill.printBill();
                        } else {
                            System.out.println(requestBook + " kitabınız alınmıştır. Bakiyenizden " + bookPrice + " TL düşüldü.");
                            bill.printBill();
                        }
                        return;
                    } else {
                        System.out.println("Yetersiz bakiye. Kitabı ödünç almak için bakiyenizi yükleyin.");
                        return;
                    }
                }
            }
            System.out.println(requestBook + " kitabı stoklarda bulunmamaktadır.");
        } else {
            System.out.println("En fazla 5 kitap kiralayabilirsiniz.");
        }
    }


    @Override
    public void returnBook(String returnedBook) {
        Iterator<Book> iterator = borrowedBooks.iterator();
        while (iterator.hasNext()) {
            Book book = iterator.next();
            if (returnedBook.equalsIgnoreCase(book.getName())) {
                iterator.remove();
                book.setStock(book.getStock() + 1);

                // Fatura oluştur
                double bookPrice = book.getPrice();
                Bill returnBill = new Bill(book.getId(), book.getName(), this.getName(), this.getReaderType(),
                        bookPrice);

                // Faturayı listeden çıkar
                if (bills.contains(returnBill)) {
                    bills.remove(returnBill);
                }

                // Kitap ücretini iade et
                this.setMoney(this.getMoney() + bookPrice);

                System.out.println(returnedBook + " kitabınız iade edilmiştir. " + bookPrice + " TL iade edilmiştir.");
                returnBill.printBill();
                return;
            }
        }
        System.out.println(returnedBook + " kitabı zaten ödünç alınmamıştır.");
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
}
