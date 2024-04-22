package com.main;

import books.Book;
import data.Admin;
import data.Student;
import data.User;

import java.util.ArrayList;
import java.util.Scanner;

public class LibrarySystem {
    public static Book[] bookList = {
            new Book("111","Hujan", "Tere Liye", 6,0),
            new Book("222","Java Script", "thomas nelson",3, 0),
    };

    public static ArrayList<User> userStudents = new ArrayList<>();

    public static User currentUser = null;

    public static void main(String[] args) {
        menu();
    }

    public static void menu() {
        Scanner scanner = new Scanner(System.in);
        Student student = new Student();

        while (true) {
            System.out.println("==== Library System ====");
            System.out.println("1. Login as Student");
            System.out.println("2. Login as Admin");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    if (student.login()) {
                        currentUser = student;
                        student.menuStudent();
                    }
                    break;
                case 2:
                    Admin admin = new Admin();
                    if (admin.login()) {
                        admin.menuAdmin();
                    }
                    break;
                case 3:
                    System.out.println("Telah keluar dari program!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Tidak valid.");
            }
        }
    }
}
