package data;

import books.Book;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class User {
    String name;
    String nim;
    String faculty;
    String programStudi;
    private ArrayList<Book> borrowedBooks;

    Book[] bookList = new Book[100];

    public User(String name, String nim, String faculty, String programStudi, String id) {
        this.name = name;
        this.nim = nim;
        this.faculty = faculty;
        this.programStudi = programStudi;
        this.borrowedBooks = new ArrayList<>();
    }

    public User(String name, String nim) {
    }

    public void displayBook(){
        for (Book book : bookList) {
            System.out.println(book.getTitle());
        }
    }
}



