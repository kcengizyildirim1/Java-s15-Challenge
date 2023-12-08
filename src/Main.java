import com.workintech.LibrarySystem.enums.BookStatus;
import com.workintech.LibrarySystem.enums.Categories;
import com.workintech.LibrarySystem.model.Book;
import com.workintech.LibrarySystem.model.Librarian;
import com.workintech.LibrarySystem.model.Library;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Book book = new Book(1, "Pinokyo", Categories.FANTASY, "Carlo Collodi", 200, BookStatus.IN_STOCK , 4);
        Book book1 = new Book(2, "Twilight" , Categories.FANTASY, "Stephenie Meyer" , 407 , BookStatus.IN_STOCK, 3);
        Book book2 = new Book(3 ,"Head First Java: A Brain-Friendly Guide", Categories.EDUCATION,
                "Kathy Sierra" ,722, BookStatus.OUT_OF_STOCK, 0);


        Library library = new Library();



        Librarian librarian = new Librarian("Lorem Ipsum", library);
        librarian.addBook(book);
        librarian.addBook(book1);
        librarian.addBook(book2);
        System.out.println(library.getBookList());
        System.out.println("-------------------------------------");

        librarian.searchBook("twilight"); // Output Aradiginiz kitap bulundu: Twilight
        System.out.println("-------------------------------------");
        librarian.deleteBook(2);
        System.out.println("-------------------------------------");
        System.out.println(library.getBookList());


//        Scanner scanner = new Scanner(System.in);
//
//        System.out.println("Kitap alacak kişinin rolünü girin (STUDENT veya ACADEMICIAN):");
//        String input = scanner.next();
//
//        ReaderType readerType = ReaderType.fromString(input);
//
//        if (readerType != null) {
//            switch (readerType) {
//                case STUDENT:
//                    System.out.println("Öğrenci, kitabı alabilir.");
//                    break;
//                case AKADEMISYEN:
//                    System.out.println("Akademisyen, kitabı alabilir.");
//                    break;
//                default:
//                    System.out.println("Bunu almaya yetkiniz yok.");
//            }
//        } else {
//            System.out.println("Bunu almaya yetkiniz yok.");
//        }

    }

}