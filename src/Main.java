import com.workintech.LibrarySystem.enums.BookStatus;
import com.workintech.LibrarySystem.enums.Categories;
import com.workintech.LibrarySystem.enums.ReaderType;
import com.workintech.LibrarySystem.model.Book;
import com.workintech.LibrarySystem.model.Librarian;
import com.workintech.LibrarySystem.model.Library;
import com.workintech.LibrarySystem.model.Reader;


public class Main {
    public static void main(String[] args) {
        Book book = new Book(1, "Pinokyo", Categories.FANTASY, "Carlo Collodi",  BookStatus.OUT_OF_STOCK , 0 , 20);
        Book book1 = new Book(2, "Twilight" , Categories.FANTASY, "Stephenie Meyer" ,  BookStatus.OUT_OF_STOCK, 0 ,30);
        Book book2 = new Book(3 ,"Head First Java: A Brain-Friendly Guide", Categories.EDUCATION,
                "Kathy Sierra" , BookStatus.OUT_OF_STOCK, 0, 25);


        Library library = new Library();

        // Kutuphaneye kitaplar eklendi.

        library.getBookList().put(book.getId(), book);
        library.getBookList().put(book1.getId(), book1);
        library.getBookList().put(book2.getId(), book2);

        System.out.println(library.getBookList());



        Librarian librarian = new Librarian("Lorem Ipsum", library);
        librarian.addBook(book);
        librarian.addBook(book);
        librarian.addBook(book1);
        librarian.addBook(book2);
        librarian.addBook(book2);
        librarian.addBook(book2);
        librarian.addBook(book2);
        librarian.addBook(book2);

        // Kitap editi yapiliyor.
        librarian.updateBook(book2, "deneme", "Carlo Collodi" , 15 , Categories.FANTASY, 2 , BookStatus.IN_STOCK);
        System.out.println(library.getBookList());



       System.out.println(library.getBookList());
       System.out.println("-------------------------------------");

        librarian.searchBook("pinokyo"); // Output Aradiginiz kitap bulundu: Twilight
        System.out.println("-------------------------------------");
        //librarian.deleteBook(2);
        System.out.println("-------------------------------------");
        System.out.println(library.getBookList());
        System.out.println("-------------------------------------");

        Reader reader = new Reader("Kursad Cengiz Yildirim", 1801142356 , "123456", ReaderType.STUDENT, library ,50);
        Reader reader1 = new Reader("Beren Ates", 1901142372, "345657", ReaderType.ACADEMICAN, library, 200);

        // Kullanici login
        reader.login("123456", 1801142356);
        reader1.login("345657", 1901142372);

       reader.borrow("Pinokyo");

       reader.borrow("Head First Java: A Brain-Friendly Guide");
        System.out.println("-------------------------------------");
       reader.borrow("Head First Java: A Brain-Friendly Guide");
        System.out.println("-------------------------------------");
       reader.borrow("Head First Java: A Brain-Friendly Guide");
        System.out.println("-------------------------------------");
       reader.borrow("Head First Java: A Brain-Friendly Guide");
        System.out.println("-------------------------------------");
       reader.borrow("deneme");
        System.out.println("-------------------------------------");
       reader.borrow("deneme");
        System.out.println("-------------------------------------");

        System.out.println(reader.displayBorrowedBooks());
        System.out.println(reader1.displayBorrowedBooks());
        System.out.println(reader.getName()+ " kullanicisin bakiyesi: "+ reader.getMoney() + " TL");
        System.out.println(reader1.getName()+ " kullanicisin bakiyesi: "+ reader1.getMoney() + " TL");


        System.out.println(reader.getBills());
        System.out.println("-------------------------------------");
        System.out.println(reader1.getBills());

        reader.returnBook("Pinokyo");
        System.out.println(reader.getMoney());
        System.out.println(reader1.getMoney());

//        reader.borrow("Twilight");
//        reader.borrow("Twilight");
//
//
//        reader.returnBook("Twilight");
//        reader.returnBook("Twilight");


//       reader1.borrow("Twilight");


//        System.out.println(library);




    }

}