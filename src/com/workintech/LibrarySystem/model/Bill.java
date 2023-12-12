package com.workintech.LibrarySystem.model;

import com.workintech.LibrarySystem.enums.ReaderType;

public class Bill {
    private long bookId;
    private String bookName;
    private String customerName;
    private ReaderType customerType;
    private double totalPrice;

    public Bill(long bookId, String bookName, String customerName, ReaderType customerType, double totalPrice) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.customerName = customerName;
        this.customerType = customerType;
        this.totalPrice = totalPrice;
    }

    public void printBill() {
        System.out.println("Fatura Detayları:");
        System.out.println("Kitap ID: " + bookId);
        System.out.println("Kitap İsmi: " + bookName);
        System.out.println("Alıcı Adı: " + customerName);
        System.out.println("Alıcı Tipi: " + customerType);
        System.out.println("Toplam Fiyat: " + totalPrice + " TL");
        System.out.println("------------------------");
    }

    @Override
    public String toString() {
        return "Bill{" +
                "bookId=" + bookId +
                ", bookName='" + bookName + '\'' +
                ", customerName='" + customerName + '\'' +
                ", customerType=" + customerType +
                ", totalPrice=" + totalPrice +
                '}';
    }
}




