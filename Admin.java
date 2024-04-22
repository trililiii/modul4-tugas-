package data;

import com.main.LibrarySystem;

import java.util.Scanner;

public class Admin extends User {
    String username = "Admin";
    String password = "admin123";

    String faculty;
    String studi;


    public Admin() {
        super("", "", "", "", "");
    }
    public boolean login() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Username: ");
        String inputUsername = scanner.nextLine();
        System.out.print("Password: ");
        String inputPassword = scanner.nextLine();
        if (inputUsername.equals(username) && inputPassword.equals(password)) {
            System.out.println("Login berhasil.");
            return true;
        } else {
            System.out.println("Login gagal.");
            return false;
        }
    }

    public void menuAdmin() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("==== Admin Menu ====");
            System.out.println("1. Add student");
            System.out.println("2. Display registered student");
            System.out.println("3. Logout");
            System.out.print("Enter Your Choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    displayRegisteredStudent();
                    break;
                case 3:
                    System.out.println("Logout Success.");
                    return;
                default:
                    System.out.println("Invalid.");
            }
        }
    }

    public void addStudent() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Masukkan Nama Mahasiswa: ");

        String name = scanner.nextLine();
        String nim = inputNim();
        String faculty = inputFaculty();
        String programStudi = inputProgramStudi();
        String id = generateId();

        User newStudent = new User(name, nim, faculty, programStudi, id);
        LibrarySystem.userStudents.add(newStudent);

        System.out.println("Student added successfully with ID: " + id);
    }

    public String inputNim() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("Masukkan NIM Mahasiswa: ");
            String nim = scanner.nextLine();
            if (nim.length() == 15) {
                return nim;
            } else {
                System.out.println("Silakan coba lagi.");
            }
        }
    }

    public String inputFaculty() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Masukkan Fakultas: ");
        faculty = scanner.nextLine();
        return faculty;
    }

    public String inputProgramStudi() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Masukkan Program Studi: ");
        studi = scanner.nextLine();
        return studi;
    }

    private void displayRegisteredStudent() {
        System.out.println("Daftar Mahasiswa Terdaftar:");
        for (User student : LibrarySystem.userStudents) {
            System.out.println("Nama: " + student.name);
            System.out.println("NIM: " + student.nim);
            System.out.println("Fakultas: " + student.faculty);
            System.out.println("Jurusan: " + student.programStudi);
        }
    }

    private static int idCounter = 100;
    public String generateId() {
        int id = idCounter++;
        String idStr = String.format("%05d", id);
        return "STD-" + idStr;
    }
}