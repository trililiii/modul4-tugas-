package data;

import books.Book;
import com.main.LibrarySystem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Student extends User {
    public static HashMap<String, ArrayList<Book>> borrowedBooksMap = new HashMap<>();
    public String nim;
    public Student() {
        super("", "", "", "", "");

    }



    public boolean login() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Masukkan NIM Anda ( 99 For Back ): ");
        nim = scanner.nextLine();
        System.out.println(checkNim(nim));
        return checkNim(nim);
    }

    private boolean checkNim(String nim) {
        for (User student : LibrarySystem.userStudents) {
            if (student.nim != null && student.nim.equals(nim)) {
                return true;
            }
        }
        return false;
    }

    public void menuStudent() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("==== Student Menu ====");
            System.out.println("1. Buku terpinjam");
            System.out.println("2. Pinjam buku");
            System.out.println("3. Display Book");
            System.out.println("4. Logout");
            System.out.print("Enter Your Choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    displayBorrowedBooks();
                    break;
                case 2:
                    borrowBook();
                    break;
                case 3:
                    displayBookList();
                    break;
                case 4:
                    logout();
                    System.out.println("Logout Success.");
                    return;
                default:
                    System.out.println("Invalid.");
            }
        }
    }

    public void borrowBook() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("=== Pinjam Buku ===");
            displayBookList();


            System.out.print("Input id buku yang ingin dipinjam: ");
            String bookId = scanner.next();
            scanner.nextLine();

            if (bookId.equals("99")) {
                return;
            }

            Book bookToBorrow = findBookById(bookId);
            if (bookToBorrow != null && !isBookAlreadyBorrowed(bookToBorrow)) {
                borrowedBooksMap.computeIfAbsent(nim, k -> new ArrayList<>()).add(bookToBorrow);
                System.out.println("Buku berhasil dipinjam.");
                return;
            } else {
                System.out.println("Buku tidak tersedia atau sudah dipinjam sebelumnya. Silakan coba lagi.");
            }
        }
    }

    public void displayBookList() {
        System.out.println("==========================================================================================================");
        System.out.println("|| Nomor     || Id Buku    || Nama Buku                 || Penulis           || Kategori           || Stok  || Durasi  ||");
        System.out.println("==========================================================================================================");
        for (int i = 0; i < LibrarySystem.bookList.length; i++) {
            Book book = LibrarySystem.bookList[i];
            System.out.println(
                    "|| " + (i+1) + "      || " + book.getBookId() + "      || " + book.getTitle() + "                 || " + book.getAuthor() + "                 || " + book.getCategory() + "             || " + book.getStock() + "  || " + book.getDuration() + "  || ");
        }
        System.out.println("==========================================================================================================");
    }

    Book findBookById(String id) {
        for (Book book : LibrarySystem.bookList) {
            if (book.getBookId().equals(id)) {
                return book;
            }
        }
        return null;
    }

    public boolean isBookAlreadyBorrowed(Book book) {
        ArrayList<Book> borrowedBooks = borrowedBooksMap.getOrDefault(nim, new ArrayList<>());
        return borrowedBooks.contains(book);
    }

    public void displayBorrowedBooks() {
        ArrayList<Book> borrowedBooks = borrowedBooksMap.getOrDefault(nim, new ArrayList<>());
        System.out.println("Daftar Buku yang Dipinjam:");
        for (Book book : borrowedBooks) {
            System.out.println("Id: " + book.getBookId());
            System.out.println("Judul: " + book.getTitle());
            System.out.println("Penulis: " + book.getAuthor());
            System.out.println("Kategori: " + book.getCategory());
            System.out.println();
        }
    }

    public void logout() {
        LibrarySystem.currentUser = null;
    }
}
